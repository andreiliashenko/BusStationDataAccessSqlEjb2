package com.anli.busstation.dal.sql.gateways.staff;

import com.anli.busstation.dal.ejb2.entities.staff.DriverSkillImpl;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;

public class DriverSkillGateway extends BSEntityGateway<DriverSkillImpl> {

    protected static final String DRIVER_SKILL = "DriverSkill";
    protected static final String MAX_PASSENGERS = "maxPassengers";
    protected static final String MAX_RIDE_LENGTH = "maxRideLength";
    protected static final String NAME = "name";

    @Override
    public EntityBuilder<DriverSkillImpl> getBuilder(String entityName) {
        if (DRIVER_SKILL.equals(entityName)) {
            return new DriverSkillBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(DriverSkillImpl entity, String entityName, String fieldName) {
        if (DRIVER_SKILL.equals(entityName)) {
            if (MAX_PASSENGERS.equals(fieldName)) {
                return entity.getMaxPassengers();
            }
            if (MAX_RIDE_LENGTH.equals(fieldName)) {
                return entity.getMaxRideLength();
            }
            if (NAME.equals(fieldName)) {
                return entity.getName();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    protected class DriverSkillBuilder extends BSEntityBuilder {

        @Override
        protected DriverSkillImpl getNewInstance() {
            return new DriverSkillImpl();
        }

        @Override
        protected String getEntityName() {
            return DRIVER_SKILL;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (DRIVER_SKILL.equals(entityName)) {
                if (MAX_PASSENGERS.equals(fieldName)) {
                    getInstance().setMaxPassengers((Integer) fieldValue);
                    return this;
                }
                if (MAX_RIDE_LENGTH.equals(fieldName)) {
                    getInstance().setMaxRideLength((Integer) fieldValue);
                    return this;
                }
                if (NAME.equals(fieldName)) {
                    getInstance().setName((String) fieldValue);
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
