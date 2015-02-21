package com.anli.busstation.dal.ejb2.providers.remotes.traffic;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.traffic.Ride;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.entities.traffic.RideRoad;
import com.anli.busstation.dal.interfaces.entities.traffic.Ticket;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface RideProviderRemote extends BSEntityProviderRemote<Ride> {

    Ride pullRidePoints(Ride ride) throws RemoteException;

    Ride pullRideRoads(Ride ride) throws RemoteException;

    Ride pullTickets(Ride ride) throws RemoteException;

    List<Ride> findByBus(Bus bus) throws RemoteException;

    List<Ride> findByAnyBus(Collection<Bus> busList) throws RemoteException;

    List<Ride> findByRidePoint(RidePoint ridePoint) throws RemoteException;

    List<Ride> findByAnyRidePoint(Collection<RidePoint> ridePointList) throws RemoteException;

    List<Ride> findByRideRoad(RideRoad rideRoad) throws RemoteException;

    List<Ride> findByAnyRideRoad(Collection<RideRoad> rideRoadList) throws RemoteException;

    List<Ride> findByTicket(Ticket ticket) throws RemoteException;

    List<Ride> findByAnyTicket(Collection<Ticket> ticketList) throws RemoteException;

    List<BigInteger> collectIdsByBus(Bus bus) throws RemoteException;

    List<BigInteger> collectIdsByAnyBus(Collection<Bus> busList) throws RemoteException;

    List<BigInteger> collectIdsByRidePoint(RidePoint ridePoint) throws RemoteException;

    List<BigInteger> collectIdsByAnyRidePoint(Collection<RidePoint> ridePointList) throws RemoteException;

    List<BigInteger> collectIdsByRideRoad(RideRoad rideRoad) throws RemoteException;

    List<BigInteger> collectIdsByAnyRideRoad(Collection<RideRoad> rideRoadList) throws RemoteException;

    List<BigInteger> collectIdsByTicket(Ticket ticket) throws RemoteException;

    List<BigInteger> collectIdsByAnyTicket(Collection<Ticket> ticketList) throws RemoteException;
}
