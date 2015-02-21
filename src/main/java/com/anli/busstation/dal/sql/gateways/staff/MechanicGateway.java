package com.anli.busstation.dal.sql.gateways.staff;

import com.anli.busstation.dal.ejb2.entities.staff.MechanicImpl;
import com.anli.busstation.dal.interfaces.entities.staff.MechanicSkill;
import com.anli.simpleorm.handling.EntityBuilder;

public class MechanicGateway extends AbstractEmployeeGateway<MechanicImpl> {

    protected static final String MECHANIC = "Mechanic";
    protected static final String SKILL = "skill";

    @Override
    public EntityBuilder<MechanicImpl> getBuilder(String entityName) {
        if (MECHANIC.equals(entityName)) {
            return new MechanicBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(MechanicImpl entity, String entityName, String fieldName) {
        if (MECHANIC.equals(entityName)) {
            if (SKILL.equals(fieldName)) {
                return getId(entity.getSkill());
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(MechanicImpl entity, String entityName, String fieldName) {
        if (MECHANIC.equals(entityName)) {
            if (SKILL.equals(fieldName)) {
                return entity.getSkill();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    protected class MechanicBuilder extends EmployeeBuilder {

        @Override
        protected MechanicImpl getNewInstance() {
            return new MechanicImpl();
        }

        @Override
        protected String getEntityName() {
            return MECHANIC;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (MECHANIC.equals(entityName)) {
                if (SKILL.equals(fieldName)) {
                    getInstance().setSkill((MechanicSkill) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
