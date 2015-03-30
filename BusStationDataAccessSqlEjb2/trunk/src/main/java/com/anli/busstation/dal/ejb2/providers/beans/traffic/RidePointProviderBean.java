package com.anli.busstation.dal.ejb2.providers.beans.traffic;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import org.joda.time.DateTime;

public class RidePointProviderBean extends AbstractBSProviderBean<RidePoint> {

    @Override
    protected String getEntityName() {
        return "RidePoint";
    }

    public List<RidePoint> findByRoutePoint(RoutePoint routePoint) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("routePoint", routePoint);
    }

    public List<RidePoint> findByAnyRoutePoint(Collection<RoutePoint> routePoints) {
        return getEntityHandler().selectEntitiesByAny("routePoint", routePoints);
    }

    public List<RidePoint> findByArrivalTimeRange(DateTime arrivalTimeLeft, boolean strictLeft,
            DateTime arrivalTimeRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("arrivalTime", arrivalTimeLeft, strictLeft,
                arrivalTimeRight, strictRight);
    }

    public List<RidePoint> findByDepartureTimeRange(DateTime departureTimeLeft, boolean strictLeft,
            DateTime departureTimeRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("departureTime", departureTimeLeft, strictLeft,
                departureTimeRight, strictRight);
    }

    public List<BigInteger> collectIdsByRoutePoint(RoutePoint routePoint) {
        return getEntityHandler().collectKeysByEqualsOrContains("routePoint", routePoint);
    }

    public List<BigInteger> collectIdsByAnyRoutePoint(Collection<RoutePoint> routePoints) {
        return getEntityHandler().collectKeysByAny("routePoint", routePoints);
    }

    public List<BigInteger> collectIdsByArrivalTimeRange(DateTime arrivalTimeLeft, boolean strictLeft,
            DateTime arrivalTimeRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("arrivalTime", arrivalTimeLeft, strictLeft,
                arrivalTimeRight, strictRight);
    }

    public List<BigInteger> collectIdsByDepartureTimeRange(DateTime departureTimeLeft, boolean strictLeft,
            DateTime departureTimeRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("departureTime", departureTimeLeft, strictLeft,
                departureTimeRight, strictRight);
    }
}
