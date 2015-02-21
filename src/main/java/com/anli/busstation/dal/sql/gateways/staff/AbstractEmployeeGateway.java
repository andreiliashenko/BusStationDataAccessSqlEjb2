package com.anli.busstation.dal.sql.gateways.staff;

import com.anli.busstation.dal.ejb2.entities.staff.EmployeeImpl;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import java.math.BigDecimal;
import org.joda.time.DateTime;

public abstract class AbstractEmployeeGateway<Entity extends EmployeeImpl> extends BSEntityGateway<Entity> {

    protected static final String EMPLOYEE = "Employee";
    protected static final String HIRING_DATE = "hiringDate";
    protected static final String NAME = "name";
    protected static final String SALARY = "salary";

    @Override
    public Object extractSingle(Entity entity, String entityName, String fieldName) {
        if (EMPLOYEE.equals(entityName)) {
            if (HIRING_DATE.equals(fieldName)) {
                return entity.getHiringDate();
            }
            if (NAME.equals(fieldName)) {
                return entity.getName();
            }
            if (SALARY.equals(fieldName)) {
                return entity.getSalary();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    protected abstract class EmployeeBuilder extends BSEntityBuilder {

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (EMPLOYEE.equals(entityName)) {
                if (HIRING_DATE.equals(fieldName)) {
                    getInstance().setHiringDate((DateTime) fieldValue);
                    return this;
                }
                if (NAME.equals(fieldName)) {
                    getInstance().setName((String) fieldValue);
                    return this;
                }
                if (SALARY.equals(fieldName)) {
                    getInstance().setSalary((BigDecimal) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
