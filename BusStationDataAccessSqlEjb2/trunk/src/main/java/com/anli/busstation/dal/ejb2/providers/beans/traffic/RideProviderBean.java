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
        getEntityHandler().pullCollection(ride, "ridePoints");
        return ride;
    }

    public Ride pullRideRoads(Ride ride) {
        getEntityHandler().pullCollection(ride, "rideRoads");
        return ride;
    }

    public Ride pullTickets(Ride ride) {
        getEntityHandler().pullCollection(ride, "tickets");
        return ride;
    }

    public List<Ride> findByBus(Bus bus) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("bus", bus);
    }

    public List<Ride> findByAnyBus(Collection<Bus> busList) {
        return getEntityHandler().selectEntitiesByAny("bus", busList);
    }

    public List<Ride> findByRidePoint(RidePoint ridePoint) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("ridePoints", ridePoint);
    }

    public List<Ride> findByAnyRidePoint(Collection<RidePoint> ridePointList) {
        return getEntityHandler().selectEntitiesByAny("ridePoints", ridePointList);
    }

    public List<Ride> findByRideRoad(RideRoad rideRoad) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("rideRoads", rideRoad);
    }

    public List<Ride> findByAnyRideRoad(Collection<RideRoad> rideRoadList) {
        return getEntityHandler().selectEntitiesByAny("rideRoads", rideRoadList);
    }

    public List<Ride> findByTicket(Ticket ticket) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("tickets", ticket);
    }

    public List<Ride> findByAnyTicket(Collection<Ticket> ticketList) {
        return getEntityHandler().selectEntitiesByAny("tickets", ticketList);
    }

    public List<BigInteger> collectIdsByBus(Bus bus) {
        return getEntityHandler().collectKeysByEqualsOrContains("bus", bus);
    }

    public List<BigInteger> collectIdsByAnyBus(Collection<Bus> busList) {
        return getEntityHandler().collectKeysByAny("bus", busList);
    }

    public List<BigInteger> collectIdsByRidePoint(RidePoint ridePoint) {
        return getEntityHandler().collectKeysByEqualsOrContains("ridePoints", ridePoint);
    }

    public List<BigInteger> collectIdsByAnyRidePoint(Collection<RidePoint> ridePointList) {
        return getEntityHandler().collectKeysByAny("ridePoints", ridePointList);
    }

    public List<BigInteger> collectIdsByRideRoad(RideRoad rideRoad) {
        return getEntityHandler().collectKeysByEqualsOrContains("rideRoads", rideRoad);
    }

    public List<BigInteger> collectIdsByAnyRideRoad(Collection<RideRoad> rideRoadList) {
        return getEntityHandler().collectKeysByAny("rideRoads", rideRoadList);
    }

    public List<BigInteger> collectIdsByTicket(Ticket ticket) {
        return getEntityHandler().collectKeysByEqualsOrContains("tickets", ticket);
    }

    public List<BigInteger> collectIdsByAnyTicket(Collection<Ticket> ticketList) {
        return getEntityHandler().collectKeysByAny("tickets", ticketList);
    }
}
