package com.anli.busstation.dal.sql.transformation;

import com.anli.sqlexecution.transformation.SqlTransformer;

public class BooleanTransformer implements SqlTransformer<Boolean, Integer> {

    @Override
    public Integer toSql(Boolean source) {
        return Boolean.TRUE.equals(source) ? 1 : 0;
    }

    @Override
    public Boolean toJava(Integer source) {
        return source != null && !source.equals(0);
    }

    @Override
    public Class<? extends Boolean> getJavaClass() {
        return Boolean.class;
    }

    @Override
    public Class<? extends Integer> getSqlClass() {
        return Integer.class;
    }

}
