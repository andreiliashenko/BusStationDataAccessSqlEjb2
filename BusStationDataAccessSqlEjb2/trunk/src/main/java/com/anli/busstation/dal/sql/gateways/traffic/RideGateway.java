package com.anli.busstation.dal.sql.gateways.traffic;

import com.anli.busstation.dal.ejb2.entities.traffic.RideImpl;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import java.util.Collection;
import java.util.List;

public class RideGateway extends BSEntityGateway<RideImpl> {

    protected static final String RIDE = "Ride";
    protected static final String BUS = "bus";
    protected static final String RIDE_POINTS = "ridePoints";
    protected static final String RIDE_ROADS = "rideRoads";
    protected static final String TICKETS = "tickets";

    @Override
    public EntityBuilder<RideImpl> getBuilder(String entityName) {
        if (RIDE.equals(entityName)) {
            return new RideBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(RideImpl entity, String entityName, String fieldName) {
        if (RIDE.equals(entityName)) {
            if (BUS.equals(fieldName)) {
                return getId(entity.getBus());
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(RideImpl entity, String entityName, String fieldName) {
        if (RIDE.equals(entityName)) {
            if (BUS.equals(fieldName)) {
                return entity.getBus();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    @Override
    public Collection extractFullCollection(RideImpl entity, String entityName, String fieldName) {
        if (RIDE.equals(entityName)) {
            if (RIDE_POINTS.equals(fieldName)) {
                return entity.getRidePoints();
            }
            if (RIDE_ROADS.equals(fieldName)) {
                return entity.getRideRoads();
            }
            if (TICKETS.equals(fieldName)) {
                return entity.getTickets();
            }
        }
        return super.extractFullCollection(entity, entityName, fieldName);
    }

    @Override
    public Collection extractCollectionKeys(RideImpl entity, String entityName, String fieldName) {
        if (RIDE.equals(entityName)) {
            if (RIDE_POINTS.equals(fieldName)) {
                return getIdCollection((List) entity.getRidePoints());
            }
            if (RIDE_ROADS.equals(fieldName)) {
                return getIdCollection((List) entity.getRideRoads());
            }
            if (TICKETS.equals(fieldName)) {
                return getIdCollection((List) entity.getTickets());
            }
        }
        return super.extractCollectionKeys(entity, entityName, fieldName);
    }

    @Override
    public Collection extractCollectionByKeys(RideImpl entity, String entityName, String fieldName, Collection keys) {
        if (RIDE.equals(entityName)) {
            if (RIDE_POINTS.equals(fieldName)) {
                return getCollectionByIds((List) entity.getRidePoints(), keys);
            }
            if (RIDE_ROADS.equals(fieldName)) {
                return getCollectionByIds((List) entity.getRideRoads(), keys);
            }
            if (TICKETS.equals(fieldName)) {
                return getCollectionByIds((List) entity.getTickets(), keys);
            }
        }
        return super.extractCollectionByKeys(entity, entityName, fieldName, keys);
    }

    @Override
    public void setCollectionField(RideImpl entity, String entityName, String fieldName, Collection value) {
        if (RIDE.equals(entityName)) {
            if (RIDE_POINTS.equals(fieldName)) {
                entity.setRidePoints((List) value);
                return;
            }
            if (RIDE_ROADS.equals(fieldName)) {
                entity.setRideRoads((List) value);
                return;
            }
            if (TICKETS.equals(fieldName)) {
                entity.setTickets((List) value);
                return;
            }
        }
        super.setCollectionField(entity, entityName, fieldName, value);
    }

    protected class RideBuilder extends BSEntityBuilder {

        @Override
        protected RideImpl getNewInstance() {
            return new RideImpl();
        }

        @Override
        protected String getEntityName() {
            return RIDE;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (RIDE.equals(entityName)) {
                if (BUS.equals(fieldName)) {
                    getInstance().setBus((Bus) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
