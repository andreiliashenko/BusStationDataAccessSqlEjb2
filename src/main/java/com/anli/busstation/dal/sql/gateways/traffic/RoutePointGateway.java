package com.anli.busstation.dal.sql.gateways.traffic;

import com.anli.busstation.dal.ejb2.entities.traffic.RoutePointImpl;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;

public class RoutePointGateway extends BSEntityGateway<RoutePointImpl> {

    protected static final String ROUTE_POINT = "RoutePoint";
    protected static final String STATION = "station";

    @Override
    public EntityBuilder<RoutePointImpl> getBuilder(String entityName) {
        if (ROUTE_POINT.equals(entityName)) {
            return new RoutePointBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(RoutePointImpl entity, String entityName, String fieldName) {
        if (ROUTE_POINT.equals(entityName)) {
            if (STATION.equals(fieldName)) {
                return getId(entity.getStation());
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(RoutePointImpl entity, String entityName, String fieldName) {
        if (ROUTE_POINT.equals(entityName)) {
            if (STATION.equals(fieldName)) {
                return entity.getStation();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    protected class RoutePointBuilder extends BSEntityBuilder {

        @Override
        protected RoutePointImpl getNewInstance() {
            return new RoutePointImpl();
        }

        @Override
        protected String getEntityName() {
            return ROUTE_POINT;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (ROUTE_POINT.equals(entityName)) {
                if (STATION.equals(fieldName)) {
                    getInstance().setStation((Station) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
