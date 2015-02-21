package com.anli.busstation.dal.sql.gateways.staff;

import com.anli.busstation.dal.ejb2.entities.staff.DriverImpl;
import com.anli.busstation.dal.interfaces.entities.staff.DriverSkill;
import com.anli.simpleorm.handling.EntityBuilder;

public class DriverGateway extends AbstractEmployeeGateway<DriverImpl> {

    protected static final String DRIVER = "Driver";
    protected static final String SKILL = "skill";

    @Override
    public EntityBuilder<DriverImpl> getBuilder(String entityName) {
        if (DRIVER.equals(entityName)) {
            return new DriverBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(DriverImpl entity, String entityName, String fieldName) {
        if (DRIVER.equals(entityName)) {
            if (SKILL.equals(fieldName)) {
                return getId(entity.getSkill());
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(DriverImpl entity, String entityName, String fieldName) {
        if (DRIVER.equals(entityName)) {
            if (SKILL.equals(fieldName)) {
                return entity.getSkill();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    protected class DriverBuilder extends EmployeeBuilder {

        @Override
        protected DriverImpl getNewInstance() {
            return new DriverImpl();
        }

        @Override
        protected String getEntityName() {
            return DRIVER;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (DRIVER.equals(entityName)) {
                if (SKILL.equals(fieldName)) {
                    getInstance().setSkill((DriverSkill) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
