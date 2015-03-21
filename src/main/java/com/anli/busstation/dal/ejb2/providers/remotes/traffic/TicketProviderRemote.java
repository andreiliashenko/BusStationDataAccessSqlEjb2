package com.anli.busstation.dal.ejb2.providers.remotes.traffic;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.staff.Salesman;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.entities.traffic.Ticket;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import org.joda.time.DateTime;

public interface TicketProviderRemote extends BSEntityProviderRemote<Ticket> {

    List<Ticket> findByDeparturePoint(RidePoint departurePoint) throws RemoteException;

    List<Ticket> findByAnyDeparturePoint(Collection<RidePoint> departurePoints) throws RemoteException;

    List<Ticket> findByArrivalPoint(RidePoint arrivalPoint) throws RemoteException;

    List<Ticket> findByAnyArrivalPoint(Collection<RidePoint> arrivalPoints) throws RemoteException;

    List<Ticket> findBySeat(Integer seat) throws RemoteException;

    List<Ticket> findBySeatRange(Integer seatLeft, boolean strictLeft,
            Integer seatRight, boolean strictRight) throws RemoteException;

    List<Ticket> findBySalesman(Salesman salesman) throws RemoteException;

    List<Ticket> findByAnySalesman(Collection<Salesman> salesmen) throws RemoteException;

    List<Ticket> findBySaleDateRange(DateTime saleDateLeft, boolean strictLeft,
            DateTime saleDateRight, boolean strictRight) throws RemoteException;

    List<Ticket> findByCustomerName(String customerName) throws RemoteException;

    List<Ticket> findByCustomerNameRegexp(String customerNameRegexp) throws RemoteException;

    List<Ticket> findByPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) throws RemoteException;

    List<Ticket> findBySold(boolean sold) throws RemoteException;

    List<BigInteger> collectIdsByDeparturePoint(RidePoint departurePoint) throws RemoteException;

    List<BigInteger> collectIdsByAnyDeparturePoint(Collection<RidePoint> departurePoints) throws RemoteException;

    List<BigInteger> collectIdsByArrivalPoint(RidePoint arrivalPoint) throws RemoteException;

    List<BigInteger> collectIdsByAnyArrivalPoint(Collection<RidePoint> arrivalPoints) throws RemoteException;

    List<BigInteger> collectIdsBySeat(Integer seat) throws RemoteException;

    List<BigInteger> collectIdsBySeatRange(Integer seatLeft, boolean strictLeft,
            Integer seatRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsBySalesman(Salesman salesman) throws RemoteException;

    List<BigInteger> collectIdsByAnySalesman(Collection<Salesman> salesmen) throws RemoteException;

    List<BigInteger> collectIdsBySaleDateRange(DateTime saleDateLeft, boolean strictLeft,
            DateTime saleDateRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByCustomerName(String customerName) throws RemoteException;

    List<BigInteger> collectIdsByCustomerNameRegexp(String customerNameRegexp) throws RemoteException;

    List<BigInteger> collectIdsByPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsBySold(boolean sold) throws RemoteException;
}
