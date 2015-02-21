package com.anli.busstation.dal.sql.gateways.maintenance;

import com.anli.busstation.dal.ejb2.entities.maintenance.BusServiceImpl;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import com.anli.simpleorm.handling.EntityBuilder;

public abstract class AbstractBusServiceGateway<Entity extends BusServiceImpl>
        extends AbstractTechnicalAssignmentGateway<Entity> {

    protected static final String BUS_SERVICE = "BusService";
    protected static final String BUS = "bus";

    @Override
    public Object extractSingle(Entity entity, String entityName, String fieldName) {
        if (BUS_SERVICE.equals(entityName)) {
            if (BUS.equals(fieldName)) {
                return getId(entity.getBus());
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(Entity entity, String entityName, String fieldName) {
        if (BUS_SERVICE.equals(entityName)) {
            if (BUS.equals(fieldName)) {
                return entity.getBus();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    protected abstract class BusServiceBuilder extends TechnicalAssignmentBuilder {

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (BUS_SERVICE.equals(entityName)) {
                if (BUS.equals(fieldName)) {
                    getInstance().setBus((Bus) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
