package com.anli.busstation.dal.sql.gateways.vehicles;

import com.anli.busstation.dal.ejb2.entities.vehicles.ModelImpl;
import com.anli.busstation.dal.interfaces.entities.vehicles.GasLabel;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import java.math.BigDecimal;

public class ModelGateway extends BSEntityGateway<ModelImpl> {

    protected static final String MODEL = "Model";
    protected static final String GAS_LABEL = "gasLabel";
    protected static final String GAS_RATE = "gasRate";
    protected static final String NAME = "name";
    protected static final String SEATS_NUMBER = "seatsNumber";
    protected static final String TANK_VOLUME = "tankVolume";

    @Override
    public EntityBuilder<ModelImpl> getBuilder(String entityName) {
        if (MODEL.equals(entityName)) {
            return new ModelBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(ModelImpl entity, String entityName, String fieldName) {
        if (MODEL.equals(entityName)) {
            if (GAS_LABEL.equals(fieldName)) {
                return getId(entity.getGasLabel());
            }
            if (GAS_RATE.equals(fieldName)) {
                return entity.getGasRate();
            }
            if (NAME.equals(fieldName)) {
                return entity.getName();
            }
            if (SEATS_NUMBER.equals(fieldName)) {
                return entity.getSeatsNumber();
            }
            if (TANK_VOLUME.equals(fieldName)) {
                return entity.getTankVolume();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(ModelImpl entity, String entityName, String fieldName) {
        if (MODEL.equals(entityName)) {
            if (GAS_LABEL.equals(fieldName)) {
                return entity.getGasLabel();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    protected class ModelBuilder extends BSEntityBuilder {

        @Override
        protected ModelImpl getNewInstance() {
            return new ModelImpl();
        }

        @Override
        protected String getEntityName() {
            return MODEL;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (MODEL.equals(entityName)) {
                if (GAS_LABEL.equals(fieldName)) {
                    getInstance().setGasLabel((GasLabel) fieldValue);
                    return this;
                }
                if (GAS_RATE.equals(fieldName)) {
                    getInstance().setGasRate((BigDecimal) fieldValue);
                    return this;
                }
                if (NAME.equals(fieldName)) {
                    getInstance().setName((String) fieldValue);
                    return this;
                }
                if (SEATS_NUMBER.equals(fieldName)) {
                    getInstance().setSeatsNumber((Integer) fieldValue);
                    return this;
                }
                if (TANK_VOLUME.equals(fieldName)) {
                    getInstance().setTankVolume((Integer) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
