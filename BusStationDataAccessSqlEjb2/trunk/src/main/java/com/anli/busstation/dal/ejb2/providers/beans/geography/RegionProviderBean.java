package com.anli.busstation.dal.ejb2.providers.beans.geography;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.geography.Region;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public class RegionProviderBean extends AbstractBSProviderBean<Region> {

    @Override
    protected String getEntityName() {
        return "Region";
    }

    public Region pullStations(Region region) throws RemoteException {
        return pullCollection(region, "stations");
    }

    public List<Region> findByName(String name) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("name", name);
    }

    public List<Region> findByNameRegexp(String nameRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("name", nameRegexp);
    }

    public List<Region> findByCode(Integer code) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("code", code);
    }

    public List<Region> findByAnyCode(Collection<Integer> codes) {
        return getEntityHandler().selectEntitiesByAny("code", codes);
    }

    public List<Region> findByStation(Station station) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("stations", station);
    }

    public List<Region> findByAnyStation(Collection<Station> stations) {
        return getEntityHandler().selectEntitiesByAny("stations", stations);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String nameRegexp) {
        return getEntityHandler().collectKeysByRegexp("name", nameRegexp);
    }

    public List<BigInteger> collectIdsByCode(Integer code) {
        return getEntityHandler().collectKeysByEqualsOrContains("code", code);
    }

    public List<BigInteger> collectIdsByAnyCode(Collection<Integer> codes) {
        return getEntityHandler().collectKeysByAny("code", codes);
    }

    public List<BigInteger> collectIdsByStation(Station station) {
        return getEntityHandler().collectKeysByEqualsOrContains("stations", station);
    }

    public List<BigInteger> collectIdsByAnyStation(Collection<Station> stations) {
        return getEntityHandler().collectKeysByAny("stations", stations);
    }
}
