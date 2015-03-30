package com.anli.busstation.dal.ejb2.providers.beans.traffic;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.traffic.Ride;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.entities.traffic.RideRoad;
import com.anli.busstation.dal.interfaces.entities.traffic.Ticket;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public class RideProviderBean extends AbstractBSProviderBean<Ride> {

    @Override
    protected String getEntityName() {
        return "Ride";
    }

    public Ride pullRidePoints(Ride ride) {
        return pullCollection(ride, "ridePoints");
    }

    public Ride pullRideRoads(Ride ride) {
        return pullCollection(ride, "rideRoads");
    }

    public Ride pullTickets(Ride ride) {
        return pullCollection(ride, "tickets");
    }

    public List<Ride> findByBus(Bus bus) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("bus", bus);
    }

    public List<Ride> findByAnyBus(Collection<Bus> buses) {
        return getEntityHandler().selectEntitiesByAny("bus", buses);
    }

    public List<Ride> findByRidePoint(RidePoint ridePoint) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("ridePoints", ridePoint);
    }

    public List<Ride> findByAnyRidePoint(Collection<RidePoint> ridePoints) {
        return getEntityHandler().selectEntitiesByAny("ridePoints", ridePoints);
    }

    public List<Ride> findByRideRoad(RideRoad rideRoad) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("rideRoads", rideRoad);
    }

    public List<Ride> findByAnyRideRoad(Collection<RideRoad> rideRoads) {
        return getEntityHandler().selectEntitiesByAny("rideRoads", rideRoads);
    }

    public List<Ride> findByTicket(Ticket ticket) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("tickets", ticket);
    }

    public List<Ride> findByAnyTicket(Collection<Ticket> tickets) {
        return getEntityHandler().selectEntitiesByAny("tickets", tickets);
    }

    public List<BigInteger> collectIdsByBus(Bus bus) {
        return getEntityHandler().collectKeysByEqualsOrContains("bus", bus);
    }

    public List<BigInteger> collectIdsByAnyBus(Collection<Bus> buses) {
        return getEntityHandler().collectKeysByAny("bus", buses);
    }

    public List<BigInteger> collectIdsByRidePoint(RidePoint ridePoint) {
        return getEntityHandler().collectKeysByEqualsOrContains("ridePoints", ridePoint);
    }

    public List<BigInteger> collectIdsByAnyRidePoint(Collection<RidePoint> ridePoints) {
        return getEntityHandler().collectKeysByAny("ridePoints", ridePoints);
    }

    public List<BigInteger> collectIdsByRideRoad(RideRoad rideRoad) {
        return getEntityHandler().collectKeysByEqualsOrContains("rideRoads", rideRoad);
    }

    public List<BigInteger> collectIdsByAnyRideRoad(Collection<RideRoad> rideRoads) {
        return getEntityHandler().collectKeysByAny("rideRoads", rideRoads);
    }

    public List<BigInteger> collectIdsByTicket(Ticket ticket) {
        return getEntityHandler().collectKeysByEqualsOrContains("tickets", ticket);
    }

    public List<BigInteger> collectIdsByAnyTicket(Collection<Ticket> tickets) {
        return getEntityHandler().collectKeysByAny("tickets", tickets);
    }
}
