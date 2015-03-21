package com.anli.busstation.dal.sql.transformation;

import com.anli.sqlexecution.transformation.SqlTransformer;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerTransformer implements SqlTransformer<BigInteger, BigDecimal> {

    @Override
    public BigDecimal toSql(BigInteger source) {
        return source == null ? null : new BigDecimal(source);
    }

    @Override
    public BigInteger toJava(BigDecimal source) {
        return source == null ? null : source.toBigInteger();
    }

    @Override
    public Class<? extends BigInteger> getJavaClass() {
        return BigInteger.class;
    }

    @Override
    public Class<? extends BigDecimal> getSqlClass() {
        return BigDecimal.class;
    }
}
