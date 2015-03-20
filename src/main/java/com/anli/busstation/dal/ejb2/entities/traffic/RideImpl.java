package com.anli.busstation.dal.ejb2.entities.traffic;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.ejb2.entities.vehicles.BusImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import com.anli.busstation.dal.interfaces.entities.traffic.Ride;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.entities.traffic.RideRoad;
import com.anli.busstation.dal.interfaces.entities.traffic.Ticket;
import java.util.List;

public class RideImpl extends BSEntityImpl implements Ride {

    protected BusImpl bus;
    protected List<RidePointImpl> ridePoints;
    protected List<RideRoadImpl> rideRoads;
    protected List<TicketImpl> tickets;

    @Override
    public Bus getBus() {
        return bus;
    }

    @Override
    public void setBus(Bus bus) {
        this.bus = (BusImpl) bus;
    }

    @Override
    public List<RidePoint> getRidePoints() {
        return (List) ridePoints;
    }

    public void setRidePoints(List<RidePointImpl> ridePoints) {
        this.ridePoints = ridePoints;
    }

    @Override
    public List<RideRoad> getRideRoads() {
        return (List) rideRoads;
    }

    public void setRideRoads(List<RideRoadImpl> rideRoads) {
        this.rideRoads = rideRoads;
    }

    @Override
    public List<Ticket> getTickets() {
        return (List) tickets;
    }

    public void setTickets(List<TicketImpl> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        RideImpl rideComparee = (RideImpl) comparee;
        return nullableDeepEquals(this.bus, rideComparee.bus)
                && nullableListDeepEquals((List) this.ridePoints, (List) rideComparee.ridePoints)
                && nullableListDeepEquals((List) this.rideRoads, (List) rideComparee.rideRoads)
                && nullableListDeepEquals((List) this.tickets, (List) rideComparee.tickets);
    }
    
    @Override
    public String toString() {
        return super.toString() + " bus = {" + bus + "} ridePoints = "
                + ridePoints + " rideRoads = " + rideRoads + " tickets = " + tickets;
    }
}
