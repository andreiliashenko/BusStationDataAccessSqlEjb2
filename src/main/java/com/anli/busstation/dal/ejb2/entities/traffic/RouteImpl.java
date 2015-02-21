package com.anli.busstation.dal.ejb2.entities.traffic;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.traffic.Ride;
import com.anli.busstation.dal.interfaces.entities.traffic.Route;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import java.math.BigDecimal;
import java.util.List;

public class RouteImpl extends BSEntityImpl implements Route {

    protected String numCode;
    protected BigDecimal ticketPrice;
    protected List<RoutePointImpl> routePoints;
    protected List<RideImpl> rides;

    @Override
    public String getNumCode() {
        return numCode;
    }

    @Override
    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    @Override
    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public List<RoutePoint> getRoutePoints() {
        return (List) routePoints;
    }

    public void setRoutePoints(List<RoutePointImpl> routePoint) {
        this.routePoints = routePoint;
    }

    @Override
    public List<Ride> getRides() {
        return (List) rides;
    }

    public void setRides(List<RideImpl> rides) {
        this.rides = rides;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        RouteImpl routeComparee = (RouteImpl) comparee;
        return nullableEquals(this.numCode, routeComparee.numCode)
                && nullableEquals(this.ticketPrice, routeComparee.ticketPrice)
                && nullableListDeepEquals((List) this.rides, (List) routeComparee.rides)
                && nullableListDeepEquals((List) this.routePoints, (List) routeComparee.routePoints);
    }

    @Override
    public String toString() {
        return super.toString() + " numCode = " + numCode + " ticketPrice = "
                + ticketPrice + " rides = " + rides + " routePoints" + routePoints;
    }
}
