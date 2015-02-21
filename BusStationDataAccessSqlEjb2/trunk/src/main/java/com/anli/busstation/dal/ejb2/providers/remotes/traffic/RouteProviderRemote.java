package com.anli.busstation.dal.ejb2.providers.remotes.traffic;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.traffic.Ride;
import com.anli.busstation.dal.interfaces.entities.traffic.Route;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface RouteProviderRemote extends BSEntityProviderRemote<Route> {

    Route pullRoutePoints(Route route) throws RemoteException;

    Route pullRides(Route route) throws RemoteException;

    List<Route> findByNumCode(String numCode) throws RemoteException;

    List<Route> findByAnyNumCode(Collection<String> numCodeList) throws RemoteException;

    List<Route> findByTicketPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) throws RemoteException;

    List<Route> findByRoutePoint(RoutePoint routePoint) throws RemoteException;

    List<Route> findByAnyRoutePoint(Collection<RoutePoint> routePointList) throws RemoteException;

    List<Route> findByRide(Ride ride) throws RemoteException;

    List<Route> findByAnyRide(Collection<Ride> rideList) throws RemoteException;

    List<BigInteger> collectIdsByNumCode(String numCode) throws RemoteException;

    List<BigInteger> collectIdsByAnyNumCode(Collection<String> numCodeList) throws RemoteException;

    List<BigInteger> collectIdsByTicketPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByRoutePoint(RoutePoint routePoint) throws RemoteException;

    List<BigInteger> collectIdsByAnyRoutePoint(Collection<RoutePoint> routePointList) throws RemoteException;

    List<BigInteger> collectIdsByRide(Ride ride) throws RemoteException;

    List<BigInteger> collectIdsByAnyRide(Collection<Ride> rideList) throws RemoteException;
}
