package com.anli.busstation.dal.sql.gateways.maintenance;

import com.anli.busstation.dal.ejb2.entities.maintenance.BusRepairmentImpl;
import com.anli.simpleorm.handling.EntityBuilder;
import java.math.BigDecimal;

public class BusRepairmentGateway extends AbstractBusServiceGateway<BusRepairmentImpl> {

    protected static final String BUS_REPAIRMENT = "BusRepairment";
    protected static final String EXPENDABLES_PRICE = "expendablesPrice";

    @Override
    public EntityBuilder<BusRepairmentImpl> getBuilder(String entityName) {
        if (BUS_REPAIRMENT.equals(entityName)) {
            return new BusRepairmentBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(BusRepairmentImpl entity, String entityName, String fieldName) {
        if (BUS_REPAIRMENT.equals(entityName)) {
            if (EXPENDABLES_PRICE.equals(fieldName)) {
                return entity.getExpendablesPrice();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    protected class BusRepairmentBuilder extends BusServiceBuilder {

        @Override
        protected BusRepairmentImpl getNewInstance() {
            return new BusRepairmentImpl();
        }

        @Override
        protected String getEntityName() {
            return BUS_REPAIRMENT;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (BUS_REPAIRMENT.equals(entityName)) {
                if (EXPENDABLES_PRICE.equals(fieldName)) {
                    getInstance().setExpendablesPrice((BigDecimal) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
