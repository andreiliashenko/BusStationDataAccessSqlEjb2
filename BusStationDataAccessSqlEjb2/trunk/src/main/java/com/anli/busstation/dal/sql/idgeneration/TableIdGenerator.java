package com.anli.busstation.dal.sql.idgeneration;

import com.anli.sqlexecution.execution.SqlExecutor;
import com.anli.sqlexecution.handling.ResultSetHandler;
import com.anli.sqlexecution.handling.TransformingResultSet;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

public class TableIdGenerator implements IdGenerator {

    private static final String SELECT_ID_QUERY
            = "select last_id from id_generation_sequences where entity = ?";
    private static final String INCREMENT_ID_QUERY
            = "update id_generation_sequences set last_id = last_id + 1 where entity = ?";
    private static final List<String> ENTITY_PARAMETER = Collections.singletonList("bs_entity");
    private static final String LAST_ID_COLUMN = "last_id";

    private final SqlExecutor executor;
    private final TransactionManager manager;
    private final IdSelector selector;

    public TableIdGenerator(SqlExecutor executor, TransactionManager manager) {
        this.executor = executor;
        this.manager = manager;
        selector = new IdSelector();
    }

    @Override
    public synchronized BigInteger generateId() {
        try {
            Transaction suspended = manager.suspend();
            manager.begin();
            BigInteger id = executor.executeSelect(SELECT_ID_QUERY, ENTITY_PARAMETER, selector);
            executor.executeUpdate(INCREMENT_ID_QUERY, ENTITY_PARAMETER);
            manager.commit();
            manager.resume(suspended);
            return id;
        } catch (SystemException | NotSupportedException | RollbackException | InvalidTransactionException | HeuristicMixedException | HeuristicRollbackException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static class IdSelector implements ResultSetHandler<BigInteger> {

        @Override
        public BigInteger handle(TransformingResultSet resultSet) throws SQLException {
            resultSet.next();
            return resultSet.getValue(LAST_ID_COLUMN, BigInteger.class);
        }
    }
}
