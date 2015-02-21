package com.anli.busstation.dal.ejb2.entities.geography;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.geography.Road;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import java.math.BigDecimal;

public class RoadImpl extends BSEntityImpl implements Road {

    protected StationImpl aStation;
    protected StationImpl zStation;
    protected Integer length;
    protected BigDecimal ridePrice;

    @Override
    public Station getAStation() {
        return aStation;
    }

    @Override
    public void setAStation(Station aStation) {
        this.aStation = (StationImpl) aStation;
    }

    @Override
    public Station getZStation() {
        return zStation;
    }

    @Override
    public void setZStation(Station zStation) {
        this.zStation = (StationImpl) zStation;
    }

    @Override
    public Integer getLength() {
        return length;
    }

    @Override
    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public BigDecimal getRidePrice() {
        return ridePrice;
    }

    @Override
    public void setRidePrice(BigDecimal ridePrice) {
        this.ridePrice = ridePrice;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        RoadImpl roadComparee = (RoadImpl) comparee;
        return nullableDeepEquals(this.aStation, roadComparee.aStation)
                && nullableDeepEquals(this.zStation, roadComparee.zStation)
                && nullableEquals(this.length, roadComparee.length)
                && nullableEquals(this.ridePrice, roadComparee.ridePrice);
    }

    @Override
    public String toString() {
        return super.toString() + " aStation = {" + aStation + "} zStation = {"
                + zStation + "} length = " + length + " ridePrice = " + ridePrice;
    }
}
