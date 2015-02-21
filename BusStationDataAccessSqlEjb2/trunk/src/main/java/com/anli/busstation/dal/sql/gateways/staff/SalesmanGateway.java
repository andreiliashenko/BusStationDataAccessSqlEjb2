package com.anli.busstation.dal.sql.gateways.staff;

import com.anli.busstation.dal.ejb2.entities.staff.SalesmanImpl;
import com.anli.simpleorm.handling.EntityBuilder;

public class SalesmanGateway extends AbstractEmployeeGateway<SalesmanImpl> {

    protected static final String SALESMAN = "Salesman";
    protected static final String TOTAL_SALES = "totalSales";

    @Override
    public EntityBuilder<SalesmanImpl> getBuilder(String entityName) {
        if (SALESMAN.equals(entityName)) {
            return new SalesmanBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(SalesmanImpl entity, String entityName, String fieldName) {
        if (SALESMAN.equals(entityName)) {
            if (TOTAL_SALES.equals(fieldName)) {
                return entity.getTotalSales();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    protected class SalesmanBuilder extends EmployeeBuilder {

        @Override
        protected SalesmanImpl getNewInstance() {
            return new SalesmanImpl();
        }

        @Override
        protected String getEntityName() {
            return SALESMAN;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (SALESMAN.equals(entityName)) {
                if (TOTAL_SALES.equals(fieldName)) {
                    getInstance().setTotalSales((Integer) fieldValue);
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
