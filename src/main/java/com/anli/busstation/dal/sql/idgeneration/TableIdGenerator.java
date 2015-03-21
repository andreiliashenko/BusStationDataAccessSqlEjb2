package com.anli.busstation.dal.sql.idgeneration;

import com.anli.sqlexecution.execution.SqlExecutor;
import com.anli.sqlexecution.handling.ResultSetHandler;
import com.anli.sqlexecution.handling.TransformingResultSet;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableIdGenerator implements IdGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(TableIdGenerator.class);

    private static final String SELECT_ID_QUERY
            = "select last_id from id_generation_sequences where entity = ?";
    private static final String INCREMENT_ID_QUERY
            = "update id_generation_sequences set last_id = last_id + ? where entity = ?";
    private static final String LAST_ID_COLUMN = "last_id";

    private final SqlExecutor executor;
    private final TransactionManager manager;
    private final List incrementParameters;
    private final List selectParameters;
    private final IdSelector selector;

    public TableIdGenerator(SqlExecutor executor, TransactionManager manager,
            String name, int increment) {
        this.executor = executor;
        this.manager = manager;
        this.incrementParameters = Arrays.asList(increment, name);
        this.selectParameters = Arrays.asList(name);
        selector = new IdSelector();
    }

    @Override
    public synchronized BigInteger generateId() {
        try {
            Transaction suspended = manager.suspend();
            manager.begin();
            BigInteger id = executor.executeSelect(SELECT_ID_QUERY, selectParameters, selector);
            executor.executeUpdate(INCREMENT_ID_QUERY, incrementParameters);
            manager.commit();
            manager.resume(suspended);
            return id;
        } catch (SystemException | NotSupportedException | RollbackException |
                InvalidTransactionException | HeuristicMixedException |
                HeuristicRollbackException exception) {
            LOG.error("Id generation transaction exception", exception);
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
