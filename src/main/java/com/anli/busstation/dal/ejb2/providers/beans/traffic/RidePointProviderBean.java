package com.anli.busstation.dal.ejb2.providers.beans.traffic;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;

public class RidePointProviderBean extends AbstractBSProviderBean<RidePoint> {

    @Override
    protected String getEntityName() {
        return "RidePoint";
    }

    public List<RidePoint> findByRoutePoint(RoutePoint routePoint) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("routePoint", routePoint);
    }

    public List<RidePoint> findByAnyRoutePoint(Collection<RoutePoint> routePointList) {
        return getEntityHandler().selectEntitiesByAny("routePoint", routePointList);
    }

    public List<RidePoint> findByArrivalTimeRange(DateTime leftTime, boolean leftStrict,
            DateTime rightTime, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("arrivalTime", leftTime, leftStrict,
                rightTime, rightStrict);
    }

    public List<RidePoint> findByDepartureTimeRange(DateTime leftTime, boolean leftStrict,
            DateTime rightTime, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("departureTime", leftTime, leftStrict,
                rightTime, rightStrict);
    }

    public List<BigInteger> collectIdsByRoutePoint(RoutePoint routePoint) {
        return getEntityHandler().collectKeysByEqualsOrContains("routePoint", routePoint);
    }

    public List<BigInteger> collectIdsByAnyRoutePoint(Collection<RoutePoint> routePointList) {
        return getEntityHandler().collectKeysByAny("routePoint", routePointList);
    }

    public List<BigInteger> collectIdsByArrivalTimeRange(DateTime leftTime, boolean leftStrict,
            DateTime rightTime, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("arrivalTime", leftTime, leftStrict,
                rightTime, rightStrict);
    }

    public List<BigInteger> collectIdsByDepartureTimeRange(DateTime leftTime, boolean leftStrict,
            DateTime rightTime, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("departureTime", leftTime, leftStrict,
                rightTime, rightStrict);
    }
}
