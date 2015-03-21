package com.anli.busstation.dal.ejb2.providers.beans;

import com.anli.busstation.dal.exceptions.ConsistencyException;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.sql.configuration.ConfigurationHolder;
import com.anli.busstation.dal.sql.idgeneration.IdGenerator;
import com.anli.simpleorm.exceptions.NonExistentEntitiesException;
import com.anli.simpleorm.handling.EntityHandler;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public abstract class AbstractBSProviderBean<I extends BSEntity> implements SessionBean {

    protected abstract String getEntityName();

    protected EntityHandler<I> getEntityHandler() {
        return ConfigurationHolder.getHandlerConfiguration()
                .getHandler(getEntityName());
    }

    protected IdGenerator getIdGenerator() {
        return ConfigurationHolder.getIdGenerator();
    }

    public I create() {
        return getEntityHandler().insertEntity(getIdGenerator().generateId());
    }

    public I save(I entity) {
        try {
            getEntityHandler().updateEntity(entity);
            return entity;
        } catch (NonExistentEntitiesException neeException) {
            throw new ConsistencyException(neeException.getEntities(), neeException);
        }
    }

    public void remove(I entity) {
        try {
            getEntityHandler().deleteEntity(entity);
        } catch (NonExistentEntitiesException neeException) {
            throw new ConsistencyException(neeException.getEntities(), neeException);
        }
    }

    public I findById(BigInteger id) {
        return getEntityHandler().selectEntity(id);

    }

    public List<I> findAll() {
        return getEntityHandler().selectAllEntities();
    }

    public List<BigInteger> collectIdsAll() {
        return getEntityHandler().collectAllKeys();
    }

    public void ejbCreate() {
    }

    @Override
    public void ejbActivate() {
    }

    @Override
    public void ejbPassivate() {
    }

    @Override
    public void ejbRemove() {
    }

    @Override
    public void setSessionContext(SessionContext context) {
    }
}
