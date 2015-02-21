package com.anli.busstation.dal.sql.gateways.vehicles;

import com.anli.busstation.dal.ejb2.entities.vehicles.BusImpl;
import com.anli.busstation.dal.interfaces.entities.vehicles.Model;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;

public class BusGateway extends BSEntityGateway<BusImpl> {

    protected static final String BUS = "Bus";
    protected static final String MODEL = "model";
    protected static final String PLATE = "plate";
    protected static final String STATE = "state";

    @Override
    public EntityBuilder<BusImpl> getBuilder(String entityName) {
        if (BUS.equals(entityName)) {
            return new BusBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(BusImpl entity, String entityName, String fieldName) {
        if (BUS.equals(entityName)) {
            if (MODEL.equals(fieldName)) {
                return getId(entity.getModel());
            }
            if (PLATE.equals(fieldName)) {
                return entity.getPlate();
            }
            if (STATE.equals(fieldName)) {
                return getId(entity.getState());
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(BusImpl entity, String entityName, String fieldName) {
        if (BUS.equals(entityName)) {
            if (MODEL.equals(fieldName)) {
                return entity.getModel();
            }
            if (STATE.equals(fieldName)) {
                return entity.getState();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    protected class BusBuilder extends BSEntityBuilder {

        @Override
        protected BusImpl getNewInstance() {
            return new BusImpl();
        }

        @Override
        protected String getEntityName() {
            return BUS;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (BUS.equals(entityName)) {
                if (MODEL.equals(fieldName)) {
                    getInstance().setModel((Model) fieldValue);
                    return this;
                }
                if (PLATE.equals(fieldName)) {
                    getInstance().setPlate((String) fieldValue);
                    return this;
                }
                if (STATE.equals(fieldName)) {
                    getInstance().setState((TechnicalState) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
