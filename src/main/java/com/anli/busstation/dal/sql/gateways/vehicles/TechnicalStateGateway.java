package com.anli.busstation.dal.sql.gateways.vehicles;

import com.anli.busstation.dal.ejb2.entities.vehicles.TechnicalStateImpl;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;

public class TechnicalStateGateway extends BSEntityGateway<TechnicalStateImpl> {

    protected static final String TECHNICAL_STATE = "TechnicalState";
    protected static final String DESCRIPTION = "description";
    protected static final String DIFFICULTY_LEVEL = "difficultyLevel";

    @Override
    public EntityBuilder<TechnicalStateImpl> getBuilder(String entityName) {
        if (TECHNICAL_STATE.equals(entityName)) {
            return new TechnicalStateBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(TechnicalStateImpl entity, String entityName, String fieldName) {
        if (TECHNICAL_STATE.equals(entityName)) {
            if (DESCRIPTION.equals(fieldName)) {
                return entity.getDescription();
            }
            if (DIFFICULTY_LEVEL.equals(fieldName)) {
                return entity.getDifficultyLevel();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    protected class TechnicalStateBuilder extends BSEntityBuilder {

        @Override
        protected TechnicalStateImpl getNewInstance() {
            return new TechnicalStateImpl();
        }

        @Override
        protected String getEntityName() {
            return TECHNICAL_STATE;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (TECHNICAL_STATE.equals(entityName)) {
                if (DESCRIPTION.equals(fieldName)) {
                    getInstance().setDescription((String) fieldValue);
                    return this;
                }
                if (DIFFICULTY_LEVEL.equals(fieldName)) {
                    getInstance().setDifficultyLevel((Integer) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
