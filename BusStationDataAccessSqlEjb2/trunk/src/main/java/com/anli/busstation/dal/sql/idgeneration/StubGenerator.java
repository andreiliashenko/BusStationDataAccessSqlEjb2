package com.anli.busstation.dal.sql.idgeneration;

import java.math.BigInteger;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

public class StubGenerator implements IdGenerator {

    private static final StubGenerator instance = new StubGenerator();

    private static final long denominator = 1000000000000000000L;

    public static StubGenerator getInstance() {
        return instance;
    }

    private BigInteger lastId = BigInteger.valueOf(System.currentTimeMillis() % denominator);

    private StubGenerator() {
    }

    @Override
    public synchronized BigInteger generateId() {
        lastId = lastId.add(BigInteger.ONE);
        return lastId;
    }

}
