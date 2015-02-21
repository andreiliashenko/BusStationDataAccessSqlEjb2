package com.anli.busstation.dal.sql.gateways.geography;

import com.anli.busstation.dal.ejb2.entities.geography.RoadImpl;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import java.math.BigDecimal;

public class RoadGateway extends BSEntityGateway<RoadImpl> {

    protected static final String ROAD = "Road";
    protected static final String A_STATION = "aStation";
    protected static final String LENGTH = "length";
    protected static final String RIDE_PRICE = "ridePrice";
    protected static final String Z_STATION = "zStation";

    @Override
    public EntityBuilder<RoadImpl> getBuilder(String entityName) {
        if (ROAD.equals(entityName)) {
            return new RoadBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(RoadImpl entity, String entityName, String fieldName) {
        if (ROAD.equals(entityName)) {
            if (A_STATION.equals(fieldName)) {
                return getId(entity.getAStation());
            }
            if (LENGTH.equals(fieldName)) {
                return entity.getLength();
            }
            if (RIDE_PRICE.equals(fieldName)) {
                return entity.getRidePrice();
            }
            if (Z_STATION.equals(fieldName)) {
                return getId(entity.getZStation());
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(RoadImpl entity, String entityName, String fieldName) {
        if (ROAD.equals(entityName)) {
            if (A_STATION.equals(fieldName)) {
                return entity.getAStation();
            }
            if (Z_STATION.equals(fieldName)) {
                return entity.getZStation();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    protected class RoadBuilder extends BSEntityBuilder {

        @Override
        protected RoadImpl getNewInstance() {
            return new RoadImpl();
        }

        @Override
        protected String getEntityName() {
            return ROAD;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (ROAD.equals(entityName)) {
                if (A_STATION.equals(fieldName)) {
                    getInstance().setAStation((Station) fieldValue);
                    return this;
                }
                if (LENGTH.equals(fieldName)) {
                    getInstance().setLength((Integer) fieldValue);
                    return this;
                }
                if (RIDE_PRICE.equals(fieldName)) {
                    getInstance().setRidePrice((BigDecimal) fieldValue);
                    return this;
                }
                if (Z_STATION.equals(fieldName)) {
                    getInstance().setZStation((Station) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
