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

    public List<RidePoint> findByArrivalTimeRange(DateTime arrivalTimeLeft, boolean leftStrict,
            DateTime arrivalTimeRight, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("arrivalTime", arrivalTimeLeft, leftStrict,
                arrivalTimeRight, rightStrict);
    }

    public List<RidePoint> findByDepartureTimeRange(DateTime departureTimeLeft, boolean leftStrict,
            DateTime departureTimeRight, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("departureTime", departureTimeLeft, leftStrict,
                departureTimeRight, rightStrict);
    }

    public List<BigInteger> collectIdsByRoutePoint(RoutePoint routePoint) {
        return getEntityHandler().collectKeysByEqualsOrContains("routePoint", routePoint);
    }

    public List<BigInteger> collectIdsByAnyRoutePoint(Collection<RoutePoint> routePoints) {
        return getEntityHandler().collectKeysByAny("routePoint", routePoints);
    }

    public List<BigInteger> collectIdsByArrivalTimeRange(DateTime arrivalTimeLeft, boolean leftStrict,
            DateTime arrivalTimeRight, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("arrivalTime", arrivalTimeLeft, leftStrict,
                arrivalTimeRight, rightStrict);
    }

    public List<BigInteger> collectIdsByDepartureTimeRange(DateTime departureTimeLeft, boolean leftStrict,
            DateTime departureTimeRight, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("departureTime", departureTimeLeft, leftStrict,
                departureTimeRight, rightStrict);
    }
}
