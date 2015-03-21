package com.anli.busstation.dal.ejb2.providers.beans.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.BusService;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public abstract class AbstractBusServiceProviderBean<I extends BusService>
        extends AbstractTechnicalAssignmentProviderBean<I> {

    public List<I> findByBus(Bus bus) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("bus", bus);
    }

    public List<I> findByAnyBus(Collection<Bus> buses) {
        return getEntityHandler().selectEntitiesByAny("bus", buses);
    }

    public List<BigInteger> collectIdsByBus(Bus bus) {
        return getEntityHandler().collectKeysByEqualsOrContains("bus", bus);
    }

    public List<BigInteger> collectIdsByAnyBus(Collection<Bus> buses) {
        return getEntityHandler().collectKeysByAny("bus", buses);
    }
}
