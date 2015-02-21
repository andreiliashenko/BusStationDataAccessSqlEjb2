package com.anli.busstation.dal.sql.gateways.geography;

import com.anli.busstation.dal.ejb2.entities.geography.StationImpl;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public class StationGateway extends BSEntityGateway<StationImpl> {

    protected static final String STATION = "Station";
    protected static final String BUSES = "buses";
    protected static final String EMPLOYEES = "employees";
    protected static final String LATITUDE = "latitude";
    protected static final String LONGITUDE = "longitude";
    protected static final String NAME = "name";

    @Override
    public EntityBuilder<StationImpl> getBuilder(String entityName) {
        if (STATION.equals(entityName)) {
            return new StationBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(StationImpl entity, String entityName, String fieldName) {
        if (STATION.equals(entityName)) {
            if (LATITUDE.equals(fieldName)) {
                return entity.getLatitude();
            }
            if (LONGITUDE.equals(fieldName)) {
                return entity.getLongitude();
            }
            if (NAME.equals(fieldName)) {
                return entity.getName();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Collection extractCollectionByKeys(StationImpl entity, String entityName, String fieldName, Collection keys) {
        if (STATION.equals(entityName)) {
            if (BUSES.equals(fieldName)) {
                return getCollectionByIds((List) entity.getBuses(), keys);
            }
            if (EMPLOYEES.equals(fieldName)) {
                return getCollectionByIds((List) entity.getEmployees(), keys);
            }
        }
        return super.extractCollectionByKeys(entity, entityName, fieldName, keys);
    }

    @Override
    public Collection extractCollectionKeys(StationImpl entity, String entityName, String fieldName) {
        if (STATION.equals(entityName)) {
            if (BUSES.equals(fieldName)) {
                return getIdCollection((List) entity.getBuses());
            }
            if (EMPLOYEES.equals(fieldName)) {
                return getIdCollection((List) entity.getEmployees());
            }
        }
        return super.extractCollectionKeys(entity, entityName, fieldName);
    }

    @Override
    public Collection extractFullCollection(StationImpl entity, String entityName, String fieldName) {
        if (STATION.equals(entityName)) {
            if (BUSES.equals(fieldName)) {
                return entity.getBuses();
            }
            if (EMPLOYEES.equals(fieldName)) {
                return entity.getEmployees();
            }
        }
        return super.extractFullCollection(entity, entityName, fieldName);
    }

    @Override
    public void setCollectionField(StationImpl entity, String entityName, String fieldName, Collection value) {
        if (STATION.equals(entityName)) {
            if (BUSES.equals(fieldName)) {
                entity.setBuses((List) value);
                return;
            }
            if (EMPLOYEES.equals(fieldName)) {
                entity.setEmployees((List) value);
                return;
            }
        }
        super.setCollectionField(entity, entityName, fieldName, value);
    }

    protected class StationBuilder extends BSEntityBuilder {

        @Override
        protected StationImpl getNewInstance() {
            return new StationImpl();
        }

        @Override
        protected String getEntityName() {
            return STATION;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (STATION.equals(entityName)) {
                if (LATITUDE.equals(fieldName)) {
                    getInstance().setLatitude((BigDecimal) fieldValue);
                    return this;
                }
                if (LONGITUDE.equals(fieldName)) {
                    getInstance().setLongitude((BigDecimal) fieldValue);
                    return this;
                }
                if (NAME.equals(fieldName)) {
                    getInstance().setName((String) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
