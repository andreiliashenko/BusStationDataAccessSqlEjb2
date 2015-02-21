package com.anli.busstation.dal.sql.gateways;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.simpleorm.handling.EntityBuilder;
import com.anli.simpleorm.handling.EntityGateway;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public abstract class BSEntityGateway<Entity extends BSEntityImpl> implements EntityGateway<Entity> {

    protected static final String ID = "id";

    @Override
    public abstract EntityBuilder<Entity> getBuilder(String entityName);

    protected BigInteger getId(BSEntity entity) {
        return entity != null ? entity.getId() : null;
    }

    protected Collection<BigInteger> getIdCollection(Collection<BSEntity> entities) {
        if (entities == null) {
            return null;
        }
        ArrayList<BigInteger> idList = new ArrayList<>(entities.size());
        for (BSEntity entity : entities) {
            idList.add(entity.getId());
        }
        return idList;
    }

    protected Collection<BSEntity> getCollectionByIds(Collection<BSEntity> entities,
            Collection<BigInteger> ids) {
        if (entities == null || ids == null) {
            return null;
        }
        if (ids.isEmpty()) {
            return Collections.emptyList();
        }
        LinkedList<BSEntity> result = new LinkedList<>();
        for (BSEntity entity : entities) {
            if (ids.contains(entity.getId())) {
                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public Object extractSingle(Entity entity, String entityName, String fieldName) {
        if (ID.equals(fieldName)) {
            return entity.getId();
        }
        return null;
    }

    @Override
    public Object extractFullReference(Entity entity, String entityName, String fieldName) {
        return null;
    }

    @Override
    public Collection extractCollectionKeys(Entity entity, String entityName, String fieldName) {
        return null;
    }

    @Override
    public Collection extractFullCollection(Entity entity, String entityName, String fieldName) {
        return null;
    }

    @Override
    public Collection extractCollectionByKeys(Entity entity, String entityName, String fieldName, Collection keys) {
        return null;
    }

    @Override
    public void setCollectionField(Entity entity, String entityName, String fieldName, Collection value) {
    }

    protected abstract class BSEntityBuilder implements EntityBuilder<Entity> {

        protected Entity instance;

        @Override
        public EntityBuilder startBuilding() {
            instance = getNewInstance();
            return this;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (ID.equals(fieldName) && getEntityName().equals(entityName)) {
                getInstance().setId((BigInteger) fieldValue);
                return this;
            }
            return this;
        }

        @Override
        public Entity build() {
            Entity result = instance;
            instance = null;
            return result;
        }

        protected abstract Entity getNewInstance();

        protected abstract String getEntityName();
        
        protected Entity getInstance() {
            return instance;
        }
    }
}
