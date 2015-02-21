package com.anli.busstation.dal.sql.gateways.maintenance;

import com.anli.busstation.dal.ejb2.entities.maintenance.TechnicalAssignmentImpl;
import com.anli.busstation.dal.interfaces.entities.staff.Mechanic;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import java.math.BigDecimal;
import org.joda.time.DateTime;

public abstract class AbstractTechnicalAssignmentGateway<Entity extends TechnicalAssignmentImpl>
        extends BSEntityGateway<Entity> {
    
    protected static final String TECHNICAL_ASSIGNMENT = "TechnicalAssignment";
    protected static final String BEGIN_TIME = "beginTime";
    protected static final String END_TIME = "endTime";
    protected static final String MECHANIC = "mechanic";
    protected static final String SERVICE_COST = "serviceCost";
    
    @Override
    public Object extractSingle(Entity entity, String entityName, String fieldName) {
        if (TECHNICAL_ASSIGNMENT.equals(entityName)) {
            if (BEGIN_TIME.equals(fieldName)) {
                return entity.getBeginTime();
            }
            if (END_TIME.equals(fieldName)) {
                return entity.getEndTime();
            }
            if (MECHANIC.equals(fieldName)) {
                return getId(entity.getMechanic());
            }
            if (SERVICE_COST.equals(fieldName)) {
                return entity.getServiceCost();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }
    
    @Override
    public Object extractFullReference(Entity entity, String entityName, String fieldName) {
        if (TECHNICAL_ASSIGNMENT.equals(entityName)) {
            if (MECHANIC.equals(fieldName)) {
                return entity.getMechanic();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }
    
    protected abstract class TechnicalAssignmentBuilder extends BSEntityBuilder {
        
        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (TECHNICAL_ASSIGNMENT.equals(entityName)) {
                if (BEGIN_TIME.equals(fieldName)) {
                    getInstance().setBeginTime((DateTime) fieldValue);
                    return this;
                }
                if (END_TIME.equals(fieldName)) {
                    getInstance().setEndTime((DateTime) fieldValue);
                    return this;
                }
                if (MECHANIC.equals(fieldName)) {
                    getInstance().setMechanic((Mechanic) fieldValue);
                    return this;
                }
                if (SERVICE_COST.equals(fieldName)) {
                    getInstance().setServiceCost((BigDecimal) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
