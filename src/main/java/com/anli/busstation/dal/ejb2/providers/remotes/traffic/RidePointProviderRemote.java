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

    List<RidePoint> findByAnyRoutePoint(Collection<RoutePoint> routePointList) throws RemoteException;

    List<RidePoint> findByArrivalTimeRange(DateTime leftTime, boolean leftStrict,
            DateTime rightTime, boolean rightStrict) throws RemoteException;

    List<RidePoint> findByDepartureTimeRange(DateTime leftTime, boolean leftStrict,
            DateTime rightTime, boolean rightStrict) throws RemoteException;

    List<BigInteger> collectIdsByRoutePoint(RoutePoint routePoint) throws RemoteException;

    List<BigInteger> collectIdsByAnyRoutePoint(Collection<RoutePoint> routePointList) throws RemoteException;

    List<BigInteger> collectIdsByArrivalTimeRange(DateTime leftTime, boolean leftStrict,
            DateTime rightTime, boolean rightStrict) throws RemoteException;

    List<BigInteger> collectIdsByDepartureTimeRange(DateTime leftTime, boolean leftStrict,
            DateTime rightTime, boolean rightStrict) throws RemoteException;
}
