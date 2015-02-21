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
        getEntityHandler().pullCollection(region, "stations");
        return region;
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

    public List<Region> findByAnyCode(Collection<Integer> codeList) {
        return getEntityHandler().selectEntitiesByAny("code", codeList);
    }

    public List<Region> findByStation(Station station) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("stations", station);
    }

    public List<Region> findByAnyStation(Collection<Station> stationList) {
        return getEntityHandler().selectEntitiesByAny("stations", stationList);
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

    public List<BigInteger> collectIdsByAnyCode(Collection<Integer> codeList) {
        return getEntityHandler().collectKeysByAny("code", codeList);
    }

    public List<BigInteger> collectIdsByStation(Station station) {
        return getEntityHandler().collectKeysByEqualsOrContains("stations", station);
    }

    public List<BigInteger> collectIdsByAnyStation(Collection<Station> stationList) {
        return getEntityHandler().collectKeysByAny("stations", stationList);
    }
}
