package com.anli.busstation.dal.ejb2.providers.beans.traffic;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.traffic.Ride;
import com.anli.busstation.dal.interfaces.entities.traffic.Route;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public class RouteProviderBean extends AbstractBSProviderBean<Route> {

    @Override
    protected String getEntityName() {
        return "Route";
    }

    public Route pullRoutePoints(Route route) {
        getEntityHandler().pullCollection(route, "routePoints");
        return route;
    }

    public Route pullRides(Route route) {
        getEntityHandler().pullCollection(route, "rides");
        return route;
    }

    public List<Route> findByNumCode(String numCode) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("numCode", numCode);
    }

    public List<Route> findByAnyNumCode(Collection<String> numCodes) {
        return getEntityHandler().selectEntitiesByAny("numCode", numCodes);
    }

    public List<Route> findByTicketPriceRange(BigDecimal ticketPriceLeft, boolean strictLeft,
            BigDecimal ticketPriceRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("ticketPrice", ticketPriceLeft, strictLeft,
                ticketPriceRight, strictRight);
    }

    public List<Route> findByRoutePoint(RoutePoint routePoint) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("routePoints", routePoint);
    }

    public List<Route> findByAnyRoutePoint(Collection<RoutePoint> routePoints) {
        return getEntityHandler().selectEntitiesByAny("routePoints", routePoints);
    }

    public List<Route> findByRide(Ride ride) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("rides", ride);
    }

    public List<Route> findByAnyRide(Collection<Ride> rides) {
        return getEntityHandler().selectEntitiesByAny("rides", rides);
    }

    public List<BigInteger> collectIdsByNumCode(String numCode) {
        return getEntityHandler().collectKeysByEqualsOrContains("numCode", numCode);
    }

    public List<BigInteger> collectIdsByAnyNumCode(Collection<String> numCodes) {
        return getEntityHandler().collectKeysByAny("numCode", numCodes);
    }

    public List<BigInteger> collectIdsByTicketPriceRange(BigDecimal ticketPriceLeft, boolean strictLeft,
            BigDecimal ticketPriceRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("ticketPrice", ticketPriceLeft, strictLeft,
                ticketPriceRight, strictRight);
    }

    public List<BigInteger> collectIdsByRoutePoint(RoutePoint routePoint) {
        return getEntityHandler().collectKeysByEqualsOrContains("routePoints", routePoint);
    }

    public List<BigInteger> collectIdsByAnyRoutePoint(Collection<RoutePoint> routePoints) {
        return getEntityHandler().collectKeysByAny("routePoints", routePoints);
    }

    public List<BigInteger> collectIdsByRide(Ride ride) {
        return getEntityHandler().collectKeysByEqualsOrContains("rides", ride);
    }

    public List<BigInteger> collectIdsByAnyRide(Collection<Ride> rides) {
        return getEntityHandler().collectKeysByAny("rides", rides);
    }
}
