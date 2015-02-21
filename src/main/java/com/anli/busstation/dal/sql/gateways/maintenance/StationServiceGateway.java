package com.anli.busstation.dal.sql.gateways.maintenance;

import com.anli.busstation.dal.ejb2.entities.maintenance.StationServiceImpl;
import com.anli.simpleorm.handling.EntityBuilder;

public class StationServiceGateway extends AbstractTechnicalAssignmentGateway<StationServiceImpl> {

    protected static final String STATION_SERVICE = "StationService";
    protected static final String DESCRIPTION = "description";

    @Override
    public EntityBuilder<StationServiceImpl> getBuilder(String entityName) {
        if (STATION_SERVICE.equals(entityName)) {
            return new StationServiceBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(StationServiceImpl entity, String entityName, String fieldName) {
        if (STATION_SERVICE.equals(entityName)) {
            if (DESCRIPTION.equals(fieldName)) {
                return entity.getDescription();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    protected class StationServiceBuilder extends TechnicalAssignmentBuilder {

        @Override
        protected StationServiceImpl getNewInstance() {
            return new StationServiceImpl();
        }

        @Override
        protected String getEntityName() {
            return STATION_SERVICE;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (STATION_SERVICE.equals(entityName)) {
                if (DESCRIPTION.equals(fieldName)) {
                    getInstance().setDescription((String) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
