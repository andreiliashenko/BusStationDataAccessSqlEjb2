package com.anli.busstation.dal.sql.transformation;

import com.anli.sqlexecution.transformation.SqlTransformer;
import java.sql.Timestamp;
import org.joda.time.DateTime;

public class DateTimeTransformer implements SqlTransformer<DateTime, Timestamp>{

    @Override
    public Timestamp toSql(DateTime source) {
        return source == null ? null : new Timestamp(source.getMillis());
    }

    @Override
    public DateTime toJava(Timestamp source) {
        return source == null ? null : new DateTime(source.getTime());
    }

    @Override
    public Class<? extends DateTime> getJavaClass() {
        return DateTime.class;
    }

    @Override
    public Class<? extends Timestamp> getSqlClass() {
        return Timestamp.class;
    }
}
