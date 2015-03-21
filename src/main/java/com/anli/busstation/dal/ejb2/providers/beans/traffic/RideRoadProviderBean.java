package com.anli.busstation.dal.ejb2.providers.beans.traffic;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.geography.Road;
import com.anli.busstation.dal.interfaces.entities.staff.Driver;
import com.anli.busstation.dal.interfaces.entities.traffic.RideRoad;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public class RideRoadProviderBean extends AbstractBSProviderBean<RideRoad> {

    @Override
    protected String getEntityName() {
        return "RideRoad";
    }

    public List<RideRoad> findByRoad(Road road) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("road", road);
    }

    public List<RideRoad> findByAnyRoad(Collection<Road> roads) {
        return getEntityHandler().selectEntitiesByAny("road", roads);
    }

    public List<RideRoad> findByDriver(Driver driver) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("driver", driver);
    }

    public List<RideRoad> findByAnyDriver(Collection<Driver> drivers) {
        return getEntityHandler().selectEntitiesByAny("driver", drivers);
    }

    public List<BigInteger> collectIdsByRoad(Road road) {
        return getEntityHandler().collectKeysByEqualsOrContains("road", road);
    }

    public List<BigInteger> collectIdsByAnyRoad(Collection<Road> roads) {
        return getEntityHandler().collectKeysByAny("road", roads);
    }

    public List<BigInteger> collectIdsByDriver(Driver driver) {
        return getEntityHandler().collectKeysByEqualsOrContains("driver", driver);
    }

    public List<BigInteger> collectIdsByAnyDriver(Collection<Driver> drivers) {
        return getEntityHandler().collectKeysByAny("driver", drivers);
    }
}
