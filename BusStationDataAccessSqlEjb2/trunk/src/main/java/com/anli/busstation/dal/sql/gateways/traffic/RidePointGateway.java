package com.anli.busstation.dal.sql.gateways.traffic;

import com.anli.busstation.dal.ejb2.entities.traffic.RidePointImpl;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import org.joda.time.DateTime;

public class RidePointGateway extends BSEntityGateway<RidePointImpl> {

    protected static final String RIDE_POINT = "RidePoint";
    protected static final String ARRIVAL_TIME = "arrivalTime";
    protected static final String DEPARTURE_TIME = "departureTime";
    protected static final String ROUTE_POINT = "routePoint";

    @Override
    public EntityBuilder<RidePointImpl> getBuilder(String entityName) {
        if (RIDE_POINT.equals(entityName)) {
            return new RidePointBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(RidePointImpl entity, String entityName, String fieldName) {
        if (RIDE_POINT.equals(entityName)) {
            if (ARRIVAL_TIME.equals(fieldName)) {
                return entity.getArrivalTime();
            }
            if (DEPARTURE_TIME.equals(fieldName)) {
                return entity.getDepartureTime();
            }
            if (ROUTE_POINT.equals(fieldName)) {
                return getId(entity.getRoutePoint());
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(RidePointImpl entity, String entityName, String fieldName) {
        if (RIDE_POINT.equals(entityName)) {
            if (ROUTE_POINT.equals(fieldName)) {
                return entity.getRoutePoint();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    protected class RidePointBuilder extends BSEntityBuilder {

        @Override
        protected RidePointImpl getNewInstance() {
            return new RidePointImpl();
        }

        @Override
        protected String getEntityName() {
            return RIDE_POINT;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (RIDE_POINT.equals(entityName)) {
                if (ARRIVAL_TIME.equals(fieldName)) {
                    getInstance().setArrivalTime((DateTime) fieldValue);
                    return this;
                }
                if (DEPARTURE_TIME.equals(fieldName)) {
                    getInstance().setDepartureTime((DateTime) fieldValue);
                    return this;
                }
                if (ROUTE_POINT.equals(fieldName)) {
                    getInstance().setRoutePoint((RoutePoint) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
