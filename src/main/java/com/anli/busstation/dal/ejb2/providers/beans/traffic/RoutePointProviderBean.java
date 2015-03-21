package com.anli.busstation.dal.ejb2.providers.beans.traffic;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public class RoutePointProviderBean extends AbstractBSProviderBean<RoutePoint> {

    @Override
    protected String getEntityName() {
        return "RoutePoint";
    }

    public List<RoutePoint> findByStation(Station station) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("station", station);
    }

    public List<RoutePoint> findByAnyStation(Collection<Station> stations) {
        return getEntityHandler().selectEntitiesByAny("station", stations);
    }

    public List<BigInteger> collectIdsByStation(Station station) {
        return getEntityHandler().collectKeysByEqualsOrContains("station", station);
    }

    public List<BigInteger> collectIdsByAnyStation(Collection<Station> stations) {
        return getEntityHandler().collectKeysByAny("station", stations);
    }
}
