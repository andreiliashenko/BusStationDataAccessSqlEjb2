package com.anli.busstation.dal.ejb2.providers.remotes.traffic;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import org.joda.time.DateTime;

public interface RidePointProviderRemote extends BSEntityProviderRemote<RidePoint> {

    List<RidePoint> findByRoutePoint(RoutePoint routePoint) throws RemoteException;

    List<RidePoint> findByAnyRoutePoint(Collection<RoutePoint> routePoints) throws RemoteException;

    List<RidePoint> findByArrivalTimeRange(DateTime arrivalTimeLeft, boolean strictLeft,
            DateTime arrivalTimeRight, boolean strictRight) throws RemoteException;

    List<RidePoint> findByDepartureTimeRange(DateTime departureTimeLeft, boolean strictLeft,
            DateTime departureTimeRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByRoutePoint(RoutePoint routePoint) throws RemoteException;

    List<BigInteger> collectIdsByAnyRoutePoint(Collection<RoutePoint> routePoints) throws RemoteException;

    List<BigInteger> collectIdsByArrivalTimeRange(DateTime arrivalTimeLeft, boolean strictLeft,
            DateTime arrivalTimeRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByDepartureTimeRange(DateTime departureTimeLeft, boolean strictLeft,
            DateTime departureTimeRight, boolean strictRight) throws RemoteException;
}
