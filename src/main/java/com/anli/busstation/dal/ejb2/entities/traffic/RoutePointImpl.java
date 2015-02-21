package com.anli.busstation.dal.ejb2.entities.traffic;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.ejb2.entities.geography.StationImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import com.anli.busstation.dal.interfaces.entities.geography.Station;

public class RoutePointImpl extends BSEntityImpl implements RoutePoint {

    protected StationImpl station;

    @Override
    public Station getStation() {
        return station;
    }

    @Override
    public void setStation(Station station) {
        this.station = (StationImpl) station;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        RoutePointImpl rpComparee = (RoutePointImpl) comparee;
        return nullableDeepEquals(this.station, rpComparee.station);
    }

    @Override
    public String toString() {
        return super.toString() + " station = {" + station + "}";
    }
}
