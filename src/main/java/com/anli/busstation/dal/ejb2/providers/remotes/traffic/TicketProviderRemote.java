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

    List<Ticket> findByDeparturePoint(RidePoint point) throws RemoteException;

    List<Ticket> findByAnyDeparturePoint(Collection<RidePoint> pointList) throws RemoteException;

    List<Ticket> findByArrivalPoint(RidePoint point) throws RemoteException;

    List<Ticket> findByAnyArrivalPoint(Collection<RidePoint> pointList) throws RemoteException;

    List<Ticket> findBySeat(Integer seat) throws RemoteException;

    List<Ticket> findBySeatRange(Integer seatLeft, boolean strictLeft,
            Integer seatRight, boolean strictRight) throws RemoteException;

    List<Ticket> findBySalesman(Salesman salesman) throws RemoteException;

    List<Ticket> findByAnySalesman(Collection<Salesman> salesmenList) throws RemoteException;

    List<Ticket> findBySaleDateRange(DateTime dateLeft, boolean strictLeft,
            DateTime dateRight, boolean strictRight) throws RemoteException;

    List<Ticket> findByCustomerName(String custName) throws RemoteException;

    List<Ticket> findByCustomerNameRegexp(String custNameRegexp) throws RemoteException;

    List<Ticket> findByPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) throws RemoteException;

    List<Ticket> findBySold(boolean sold) throws RemoteException;

    List<BigInteger> collectIdsByDeparturePoint(RidePoint point) throws RemoteException;

    List<BigInteger> collectIdsByAnyDeparturePoint(Collection<RidePoint> pointList) throws RemoteException;

    List<BigInteger> collectIdsByArrivalPoint(RidePoint point) throws RemoteException;

    List<BigInteger> collectIdsByAnyArrivalPoint(Collection<RidePoint> pointList) throws RemoteException;

    List<BigInteger> collectIdsBySeat(Integer seat) throws RemoteException;

    List<BigInteger> collectIdsBySeatRange(Integer seatLeft, boolean strictLeft,
            Integer seatRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsBySalesman(Salesman salesman) throws RemoteException;

    List<BigInteger> collectIdsByAnySalesman(Collection<Salesman> salesmenList) throws RemoteException;

    List<BigInteger> collectIdsBySaleDateRange(DateTime dateLeft, boolean strictLeft,
            DateTime dateRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByCustomerName(String custName) throws RemoteException;

    List<BigInteger> collectIdsByCustomerNameRegexp(String custNameRegexp) throws RemoteException;

    List<BigInteger> collectIdsByPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsBySold(boolean sold) throws RemoteException;
}
