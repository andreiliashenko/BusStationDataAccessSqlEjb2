package com.anli.busstation.dal.sql.gateways.vehicles;

import com.anli.busstation.dal.ejb2.entities.vehicles.GasLabelImpl;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import java.math.BigDecimal;

public class GasLabelGateway extends BSEntityGateway<GasLabelImpl> {

    protected static final String GAS_LABEL = "GasLabel";
    protected static final String NAME = "name";
    protected static final String PRICE = "price";

    @Override
    public EntityBuilder<GasLabelImpl> getBuilder(String entityName) {
        if (GAS_LABEL.equals(entityName)) {
            return new GasLabelBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(GasLabelImpl entity, String entityName, String fieldName) {
        if (GAS_LABEL.equals(entityName)) {
            if (NAME.equals(fieldName)) {
                return entity.getName();
            }
            if (PRICE.equals(fieldName)) {
                return entity.getPrice();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    protected class GasLabelBuilder extends BSEntityBuilder {

        @Override
        protected GasLabelImpl getNewInstance() {
            return new GasLabelImpl();
        }

        @Override
        protected String getEntityName() {
            return GAS_LABEL;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (GAS_LABEL.equals(entityName)) {
                if (NAME.equals(fieldName)) {
                    getInstance().setName((String) fieldValue);
                    return this;
                }
                if (PRICE.equals(fieldName)) {
                    getInstance().setPrice((BigDecimal) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
