package com.anli.busstation.dal.ejb2.providers.beans.geography;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.geography.Road;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RoadProviderBean extends AbstractBSProviderBean<Road> {

    @Override
    protected String getEntityName() {
        return "Road";
    }

    public List<Road> findByAStation(Station aStation) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("aStation", aStation);
    }

    public List<Road> findByAnyAStation(Collection<Station> aStationList) {
        return getEntityHandler().selectEntitiesByAny("aStation", aStationList);
    }

    public List<Road> findByZStation(Station zStation) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("zStation", zStation);
    }

    public List<Road> findByAnyZStation(Collection<Station> zStationList) {
        return getEntityHandler().selectEntitiesByAny("zStation", zStationList);
    }

    public List<Road> findByStation(Station station) {
        if (station == null) {
            return getEntityHandler().selectEntitiesByNamedQuery("byNullStation", null);
        }
        BigInteger stationId = station.getId();
        return getEntityHandler().selectEntitiesByNamedQuery("byStation",
                Arrays.asList(stationId, stationId));
    }

    public List<Road> findByAnyStation(Collection<Station> stationList) {
        if (stationList == null || stationList.isEmpty()) {
            return Collections.emptyList();
        }
        Collection<BigInteger> idList = getStationIds(stationList);
        return getEntityHandler().selectEntitiesByNamedQuery("byAnyStation",
                Arrays.asList(idList, idList));
    }

    public List<Road> findByLengthRange(Integer lengthLeft, boolean strictLeft,
            Integer lengthRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("length", lengthLeft, strictLeft, lengthRight, strictRight);
    }

    public List<Road> findByRidePriceRange(BigDecimal rPriceLeft, boolean strictLeft,
            BigDecimal rPriceRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("ridePrice", rPriceLeft, strictLeft, rPriceRight, strictRight);
    }

    public List<BigInteger> collectIdsByAStation(Station aStation) {
        return getEntityHandler().collectKeysByEqualsOrContains("aStation", aStation);
    }

    public List<BigInteger> collectIdsByAnyAStation(Collection<Station> aStationList) {
        return getEntityHandler().collectKeysByAny("aStation", aStationList);
    }

    public List<BigInteger> collectIdsByZStation(Station zStation) {
        return getEntityHandler().collectKeysByEqualsOrContains("zStation", zStation);
    }

    public List<BigInteger> collectIdsByAnyZStation(Collection<Station> zStationList) {
        return getEntityHandler().collectKeysByAny("zStation", zStationList);
    }

    public List<BigInteger> collectIdsByStation(Station station) {
        if (station == null) {
            return getEntityHandler().collectKeysByNamedQuery("byNullStation", null);
        }
        BigInteger stationId = station.getId();
        return getEntityHandler().collectKeysByNamedQuery("byStation",
                Arrays.asList(stationId, stationId));
    }

    public List<BigInteger> collectIdsByAnyStation(Collection<Station> stationList) {
        if (stationList == null || stationList.isEmpty()) {
            return Collections.emptyList();
        }
        Collection<BigInteger> idList = getStationIds(stationList);
        return getEntityHandler().collectKeysByNamedQuery("byAnyStation",
                Arrays.asList(idList, idList));
    }

    public List<BigInteger> collectIdsByLengthRange(Integer lengthLeft, boolean strictLeft,
            Integer lengthRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("length", lengthLeft, strictLeft, lengthRight, strictRight);
    }

    public List<BigInteger> collectIdsByRidePriceRange(BigDecimal rPriceLeft, boolean strictLeft,
            BigDecimal rPriceRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("ridePrice", rPriceLeft, strictLeft, rPriceRight, strictRight);
    }

    protected Collection<BigInteger> getStationIds(Collection<Station> stations) {
        ArrayList<BigInteger> stationIds = new ArrayList<>(stations.size());
        for (Station station : stations) {
            stationIds.add(station != null ? station.getId() : null);
        }
        return stationIds;
    }
}
