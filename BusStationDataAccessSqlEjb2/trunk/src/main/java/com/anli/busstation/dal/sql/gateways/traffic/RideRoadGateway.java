package com.anli.busstation.dal.sql.gateways.traffic;

import com.anli.busstation.dal.ejb2.entities.traffic.RideRoadImpl;
import com.anli.busstation.dal.interfaces.entities.geography.Road;
import com.anli.busstation.dal.interfaces.entities.staff.Driver;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;

public class RideRoadGateway extends BSEntityGateway<RideRoadImpl> {

    protected static final String RIDE_ROAD = "RideRoad";
    protected static final String DRIVER = "driver";
    protected static final String ROAD = "road";

    @Override
    public EntityBuilder<RideRoadImpl> getBuilder(String entityName) {
        if (RIDE_ROAD.equals(entityName)) {
            return new RideRoadBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(RideRoadImpl entity, String entityName, String fieldName) {
        if (RIDE_ROAD.equals(entityName)) {
            if (DRIVER.equals(fieldName)) {
                return getId(entity.getDriver());
            }
            if (ROAD.equals(fieldName)) {
                return getId(entity.getRoad());
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(RideRoadImpl entity, String entityName, String fieldName) {
        if (RIDE_ROAD.equals(entityName)) {
            if (DRIVER.equals(fieldName)) {
                return entity.getDriver();
            }
            if (ROAD.equals(fieldName)) {
                return entity.getRoad();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    protected class RideRoadBuilder extends BSEntityBuilder {

        @Override
        protected RideRoadImpl getNewInstance() {
            return new RideRoadImpl();
        }

        @Override
        protected String getEntityName() {
            return RIDE_ROAD;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (RIDE_ROAD.equals(entityName)) {
                if (DRIVER.equals(fieldName)) {
                    getInstance().setDriver((Driver) fieldValue);
                    return this;
                }
                if (ROAD.equals(fieldName)) {
                    getInstance().setRoad((Road) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
