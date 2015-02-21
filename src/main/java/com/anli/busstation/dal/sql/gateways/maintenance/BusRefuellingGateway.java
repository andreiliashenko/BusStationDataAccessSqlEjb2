package com.anli.busstation.dal.sql.gateways.maintenance;

import com.anli.busstation.dal.ejb2.entities.maintenance.BusRefuellingImpl;
import com.anli.simpleorm.handling.EntityBuilder;

public class BusRefuellingGateway extends AbstractBusServiceGateway<BusRefuellingImpl> {

    protected static final String BUS_REFUELLING = "BusRefuelling";
    protected static final String VOLUME = "volume";

    @Override
    public EntityBuilder<BusRefuellingImpl> getBuilder(String entityName) {
        if (BUS_REFUELLING.equals(entityName)) {
            return new BusRefuellingBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(BusRefuellingImpl entity, String entityName, String fieldName) {
        if (BUS_REFUELLING.equals(entityName)) {
            if (VOLUME.equals(fieldName)) {
                return entity.getVolume();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    protected class BusRefuellingBuilder extends BusServiceBuilder {

        @Override
        protected BusRefuellingImpl getNewInstance() {
            return new BusRefuellingImpl();
        }

        @Override
        protected String getEntityName() {
            return BUS_REFUELLING;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (BUS_REFUELLING.equals(entityName)) {
                if (VOLUME.equals(fieldName)) {
                    getInstance().setVolume((Integer) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
