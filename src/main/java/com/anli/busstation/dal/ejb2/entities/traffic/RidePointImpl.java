package com.anli.busstation.dal.ejb2.entities.traffic;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import org.joda.time.DateTime;

public class RidePointImpl extends BSEntityImpl implements RidePoint {

    protected RoutePointImpl routePoint;
    protected DateTime arrivalTime;
    protected DateTime departureTime;

    @Override
    public RoutePoint getRoutePoint() {
        return routePoint;
    }

    @Override
    public void setRoutePoint(RoutePoint routePoint) {
        this.routePoint = (RoutePointImpl) routePoint;
    }

    @Override
    public DateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public void setArrivalTime(DateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public DateTime getDepartureTime() {
        return departureTime;
    }

    @Override
    public void setDepartureTime(DateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        RidePointImpl rpComparee = (RidePointImpl) comparee;
        return nullableDeepEquals(this.routePoint, rpComparee.routePoint)
                && nullableEquals(this.arrivalTime, rpComparee.arrivalTime)
                && nullableEquals(this.departureTime, rpComparee.departureTime);
    }

    @Override
    public String toString() {
        return super.toString() + " routePoint = {" + routePoint + "} arrivalTime = "
                + arrivalTime + " departureTime = " + departureTime;
    }
}
