package com.anli.busstation.dal.sql.gateways.traffic;

import com.anli.busstation.dal.ejb2.entities.traffic.RouteImpl;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public class RouteGateway extends BSEntityGateway<RouteImpl> {

    protected static final String ROUTE = "Route";
    protected static final String NUM_CODE = "numCode";
    protected static final String RIDES = "rides";
    protected static final String ROUTE_POINTS = "routePoints";
    protected static final String TICKET_PRICE = "ticketPrice";

    @Override
    public EntityBuilder<RouteImpl> getBuilder(String entityName) {
        if (ROUTE.equals(entityName)) {
            return new RouteBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(RouteImpl entity, String entityName, String fieldName) {
        if (ROUTE.equals(entityName)) {
            if (NUM_CODE.equals(fieldName)) {
                return entity.getNumCode();
            }
            if (TICKET_PRICE.equals(fieldName)) {
                return entity.getTicketPrice();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Collection extractCollectionKeys(RouteImpl entity, String entityName, String fieldName) {
        if (ROUTE.equals(entityName)) {
            if (RIDES.equals(fieldName)) {
                return getIdCollection((List) entity.getRides());
            }
            if (ROUTE_POINTS.equals(fieldName)) {
                return getIdCollection((List) entity.getRoutePoints());
            }
        }
        return super.extractCollectionKeys(entity, entityName, fieldName);
    }

    @Override
    public Collection extractCollectionByKeys(RouteImpl entity, String entityName, String fieldName, Collection keys) {
        if (ROUTE.equals(entityName)) {
            if (RIDES.equals(fieldName)) {
                return getCollectionByIds((List) entity.getRides(), keys);
            }
            if (ROUTE_POINTS.equals(fieldName)) {
                return getCollectionByIds((List) entity.getRoutePoints(), keys);
            }
        }
        return super.extractCollectionByKeys(entity, entityName, fieldName, keys);
    }

    @Override
    public Collection extractFullCollection(RouteImpl entity, String entityName, String fieldName) {
        if (ROUTE.equals(entityName)) {
            if (RIDES.equals(fieldName)) {
                return entity.getRides();
            }
            if (ROUTE_POINTS.equals(fieldName)) {
                return entity.getRoutePoints();
            }
        }
        return super.extractFullCollection(entity, entityName, fieldName);
    }

    @Override
    public void setCollectionField(RouteImpl entity, String entityName, String fieldName, Collection value) {
        if (ROUTE.equals(entityName)) {
            if (RIDES.equals(fieldName)) {
                entity.setRides((List) value);
                return;
            }
            if (ROUTE_POINTS.equals(fieldName)) {
                entity.setRoutePoints((List) value);
                return;
            }
        }
        super.setCollectionField(entity, entityName, fieldName, value);
    }

    protected class RouteBuilder extends BSEntityBuilder {

        @Override
        protected RouteImpl getNewInstance() {
            return new RouteImpl();
        }

        @Override
        protected String getEntityName() {
            return ROUTE;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (ROUTE.equals(entityName)) {
                if (NUM_CODE.equals(fieldName)) {
                    getInstance().setNumCode((String) fieldValue);
                    return this;
                }
                if (TICKET_PRICE.equals(fieldName)) {
                    getInstance().setTicketPrice((BigDecimal) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
