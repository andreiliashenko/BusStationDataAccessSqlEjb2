package com.anli.busstation.dal.sql.gateways.geography;

import com.anli.busstation.dal.ejb2.entities.geography.RegionImpl;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import java.util.Collection;
import java.util.List;

public class RegionGateway extends BSEntityGateway<RegionImpl> {

    protected static final String REGION = "Region";
    protected static final String CODE = "code";
    protected static final String NAME = "name";
    protected static final String STATIONS = "stations";

    @Override
    public EntityBuilder<RegionImpl> getBuilder(String entityName) {
        if (REGION.equals(entityName)) {
            return new RegionBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(RegionImpl entity, String entityName, String fieldName) {
        if (REGION.equals(entityName)) {
            if (CODE.equals(fieldName)) {
                return entity.getCode();
            }
            if (NAME.equals(fieldName)) {
                return entity.getName();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Collection extractCollectionKeys(RegionImpl entity, String entityName, String fieldName) {
        if (REGION.equals(entityName)) {
            if (STATIONS.equals(fieldName)) {
                return getIdCollection((List) entity.getStations());
            }
        }
        return super.extractCollectionKeys(entity, entityName, fieldName);
    }

    @Override
    public Collection extractCollectionByKeys(RegionImpl entity, String entityName, String fieldName, Collection keys) {
        if (REGION.equals(entityName)) {
            if (STATIONS.equals(fieldName)) {
                return getCollectionByIds((List) entity.getStations(), keys);
            }
        }
        return super.extractCollectionByKeys(entity, entityName, fieldName, keys);
    }

    @Override
    public Collection extractFullCollection(RegionImpl entity, String entityName, String fieldName) {
        if (REGION.equals(entityName)) {
            if (STATIONS.equals(fieldName)) {
                return entity.getStations();
            }
        }
        return super.extractFullCollection(entity, entityName, fieldName);
    }

    @Override
    public void setCollectionField(RegionImpl entity, String entityName, String fieldName, Collection value) {
        if (REGION.equals(entityName)) {
            if (STATIONS.equals(fieldName)) {
                entity.setStations((List) value);
                return;
            }
        }
        super.setCollectionField(entity, entityName, fieldName, value);
    }

    protected class RegionBuilder extends BSEntityBuilder {

        @Override
        protected RegionImpl getNewInstance() {
            return new RegionImpl();
        }

        @Override
        protected String getEntityName() {
            return REGION;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (REGION.equals(entityName)) {
                if (CODE.equals(fieldName)) {
                    getInstance().setCode((Integer) fieldValue);
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
