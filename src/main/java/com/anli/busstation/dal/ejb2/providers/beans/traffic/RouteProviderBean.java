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
    
    public List<Route> findByAnyNumCode(Collection<String> numCodeList) {
        return getEntityHandler().selectEntitiesByAny("numCode", numCodeList);
    }
    
    public List<Route> findByTicketPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("ticketPrice", priceLeft, strictLeft,
                priceRight, strictRight);
    }
    
    public List<Route> findByRoutePoint(RoutePoint routePoint) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("routePoints", routePoint);
    }
    
    public List<Route> findByAnyRoutePoint(Collection<RoutePoint> routePointList) {
        return getEntityHandler().selectEntitiesByAny("routePoints", routePointList);
    }
    
    public List<Route> findByRide(Ride ride) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("rides", ride);
    }
    
    public List<Route> findByAnyRide(Collection<Ride> rideList) {
        return getEntityHandler().selectEntitiesByAny("rides", rideList);
    }
    
    public List<BigInteger> collectIdsByNumCode(String numCode) {
        return getEntityHandler().collectKeysByEqualsOrContains("numCode", numCode);
    }
    
    public List<BigInteger> collectIdsByAnyNumCode(Collection<String> numCodeList) {
        return getEntityHandler().collectKeysByAny("numCode", numCodeList);
    }
    
    public List<BigInteger> collectIdsByTicketPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("ticketPrice", priceLeft, strictLeft,
                priceRight, strictRight);
    }
    
    public List<BigInteger> collectIdsByRoutePoint(RoutePoint routePoint) {
        return getEntityHandler().collectKeysByEqualsOrContains("routePoints", routePoint);
    }
    
    public List<BigInteger> collectIdsByAnyRoutePoint(Collection<RoutePoint> routePointList) {
        return getEntityHandler().collectKeysByAny("routePoints", routePointList);
    }
    
    public List<BigInteger> collectIdsByRide(Ride ride) {
        return getEntityHandler().collectKeysByEqualsOrContains("rides", ride);
    }
    
    public List<BigInteger> collectIdsByAnyRide(Collection<Ride> rideList) {
        return getEntityHandler().collectKeysByAny("rides", rideList);
    }
}
