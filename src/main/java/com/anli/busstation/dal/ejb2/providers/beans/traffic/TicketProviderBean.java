package com.anli.busstation.dal.ejb2.providers.beans.traffic;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.staff.Salesman;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.entities.traffic.Ticket;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import org.joda.time.DateTime;

public class TicketProviderBean extends AbstractBSProviderBean<Ticket> {

    @Override
    protected String getEntityName() {
        return "Ticket";
    }

    public List<Ticket> findByDeparturePoint(RidePoint departurePoint) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("departurePoint", departurePoint);
    }

    public List<Ticket> findByAnyDeparturePoint(Collection<RidePoint> departurePoints) {
        return getEntityHandler().selectEntitiesByAny("departurePoint", departurePoints);
    }

    public List<Ticket> findByArrivalPoint(RidePoint arrivalPoint) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("arrivalPoint", arrivalPoint);
    }

    public List<Ticket> findByAnyArrivalPoint(Collection<RidePoint> arrivalPoints) {
        return getEntityHandler().selectEntitiesByAny("arrivalPoint", arrivalPoints);
    }

    public List<Ticket> findBySeat(Integer seat) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("seat", seat);
    }

    public List<Ticket> findBySeatRange(Integer seatLeft, boolean strictLeft,
            Integer seatRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("seat", seatLeft, strictLeft,
                seatRight, strictRight);
    }

    public List<Ticket> findBySalesman(Salesman salesman) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("salesman", salesman);
    }

    public List<Ticket> findByAnySalesman(Collection<Salesman> salesmen) {
        return getEntityHandler().selectEntitiesByAny("salesman", salesmen);
    }

    public List<Ticket> findBySaleDateRange(DateTime saleDateLeft, boolean strictLeft,
            DateTime saleDateRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("saleDate", saleDateLeft, strictLeft,
                saleDateRight, strictRight);
    }

    public List<Ticket> findByCustomerName(String customerName) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("customerName", customerName);
    }

    public List<Ticket> findByCustomerNameRegexp(String customerNameRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("customerName", customerNameRegexp);
    }

    public List<Ticket> findByPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("price", priceLeft, strictLeft,
                priceRight, strictRight);
    }

    public List<Ticket> findBySold(boolean sold) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("sold", sold);
    }

    public List<BigInteger> collectIdsByDeparturePoint(RidePoint departurePoint) {
        return getEntityHandler().collectKeysByEqualsOrContains("departurePoint", departurePoint);
    }

    public List<BigInteger> collectIdsByAnyDeparturePoint(Collection<RidePoint> departurePoints) {
        return getEntityHandler().collectKeysByAny("departurePoint", departurePoints);
    }

    public List<BigInteger> collectIdsByArrivalPoint(RidePoint arrivalPoint) {
        return getEntityHandler().collectKeysByEqualsOrContains("arrivalPoint", arrivalPoint);
    }

    public List<BigInteger> collectIdsByAnyArrivalPoint(Collection<RidePoint> arrivalPoints) {
        return getEntityHandler().collectKeysByAny("arrivalPoint", arrivalPoints);
    }

    public List<BigInteger> collectIdsBySeat(Integer seat) {
        return getEntityHandler().collectKeysByEqualsOrContains("seat", seat);
    }

    public List<BigInteger> collectIdsBySeatRange(Integer seatLeft, boolean strictLeft,
            Integer seatRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("seat", seatLeft, strictLeft,
                seatRight, strictRight);
    }

    public List<BigInteger> collectIdsBySalesman(Salesman salesman) {
        return getEntityHandler().collectKeysByEqualsOrContains("salesman", salesman);
    }

    public List<BigInteger> collectIdsByAnySalesman(Collection<Salesman> salesmen) {
        return getEntityHandler().collectKeysByAny("salesman", salesmen);
    }

    public List<BigInteger> collectIdsBySaleDateRange(DateTime saleDateLeft, boolean strictLeft,
            DateTime saleDateRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("saleDate", saleDateLeft, strictLeft,
                saleDateRight, strictRight);
    }

    public List<BigInteger> collectIdsByCustomerName(String customerName) {
        return getEntityHandler().collectKeysByEqualsOrContains("customerName", customerName);
    }

    public List<BigInteger> collectIdsByCustomerNameRegexp(String customerNameRegexp) {
        return getEntityHandler().collectKeysByRegexp("customerName", customerNameRegexp);
    }

    public List<BigInteger> collectIdsByPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("price", priceLeft, strictLeft,
                priceRight, strictRight);
    }

    public List<BigInteger> collectIdsBySold(boolean sold) {
        return getEntityHandler().collectKeysByEqualsOrContains("sold", sold);
    }
}
