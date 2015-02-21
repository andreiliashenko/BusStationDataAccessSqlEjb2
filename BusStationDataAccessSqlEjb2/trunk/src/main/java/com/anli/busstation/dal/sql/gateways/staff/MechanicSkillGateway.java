package com.anli.busstation.dal.sql.gateways.staff;

import com.anli.busstation.dal.ejb2.entities.staff.MechanicSkillImpl;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;

public class MechanicSkillGateway extends BSEntityGateway<MechanicSkillImpl> {

    protected static final String MECHANIC_SKILL = "MechanicSkill";
    protected static final String MAX_DIFF_LEVEL = "maxDiffLevel";
    protected static final String NAME = "name";

    @Override
    public EntityBuilder<MechanicSkillImpl> getBuilder(String entityName) {
        if (MECHANIC_SKILL.equals(entityName)) {
            return new MechanicSkillBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(MechanicSkillImpl entity, String entityName, String fieldName) {
        if (MECHANIC_SKILL.equals(entityName)) {
            if (MAX_DIFF_LEVEL.equals(fieldName)) {
                return entity.getMaxDiffLevel();
            }
            if (NAME.equals(fieldName)) {
                return entity.getName();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    protected class MechanicSkillBuilder extends BSEntityBuilder {

        @Override
        protected MechanicSkillImpl getNewInstance() {
            return new MechanicSkillImpl();
        }

        @Override
        protected String getEntityName() {
            return MECHANIC_SKILL;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (MECHANIC_SKILL.equals(entityName)) {
                if (MAX_DIFF_LEVEL.equals(fieldName)) {
                    getInstance().setMaxDiffLevel((Integer) fieldValue);
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
