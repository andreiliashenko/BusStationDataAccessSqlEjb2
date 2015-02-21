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

    public List<Ticket> findByDeparturePoint(RidePoint point) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("departurePoint", point);
    }

    public List<Ticket> findByAnyDeparturePoint(Collection<RidePoint> pointList) {
        return getEntityHandler().selectEntitiesByAny("departurePoint", pointList);
    }

    public List<Ticket> findByArrivalPoint(RidePoint point) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("arrivalPoint", point);
    }

    public List<Ticket> findByAnyArrivalPoint(Collection<RidePoint> pointList) {
        return getEntityHandler().selectEntitiesByAny("arrivalPoint", pointList);
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

    public List<Ticket> findByAnySalesman(Collection<Salesman> salesmenList) {
        return getEntityHandler().selectEntitiesByAny("salesman", salesmenList);
    }

    public List<Ticket> findBySaleDateRange(DateTime dateLeft, boolean strictLeft,
            DateTime dateRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("saleDate", dateLeft, strictLeft,
                dateRight, strictRight);
    }

    public List<Ticket> findByCustomerName(String custName) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("customerName", custName);
    }

    public List<Ticket> findByCustomerNameRegexp(String custNameRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("customerName", custNameRegexp);
    }

    public List<Ticket> findByPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("price", priceLeft, strictLeft,
                priceRight, strictRight);
    }

    public List<Ticket> findBySold(boolean sold) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("sold", sold);
    }

    public List<BigInteger> collectIdsByDeparturePoint(RidePoint point) {
        return getEntityHandler().collectKeysByEqualsOrContains("departurePoint", point);
    }

    public List<BigInteger> collectIdsByAnyDeparturePoint(Collection<RidePoint> pointList) {
        return getEntityHandler().collectKeysByAny("departurePoint", pointList);
    }

    public List<BigInteger> collectIdsByArrivalPoint(RidePoint point) {
        return getEntityHandler().collectKeysByEqualsOrContains("arrivalPoint", point);
    }

    public List<BigInteger> collectIdsByAnyArrivalPoint(Collection<RidePoint> pointList) {
        return getEntityHandler().collectKeysByAny("arrivalPoint", pointList);
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

    public List<BigInteger> collectIdsByAnySalesman(Collection<Salesman> salesmenList) {
        return getEntityHandler().collectKeysByAny("salesman", salesmenList);
    }

    public List<BigInteger> collectIdsBySaleDateRange(DateTime dateLeft, boolean strictLeft,
            DateTime dateRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("saleDate", dateLeft, strictLeft,
                dateRight, strictRight);
    }

    public List<BigInteger> collectIdsByCustomerName(String custName) {
        return getEntityHandler().collectKeysByEqualsOrContains("customerName", custName);
    }

    public List<BigInteger> collectIdsByCustomerNameRegexp(String custNameRegexp) {
        return getEntityHandler().collectKeysByRegexp("customerName", custNameRegexp);
    }

    public List<BigInteger> collectIdsByPriceRange(BigDecimal priceLeft, boolean strictLeft,
            BigDecimal priceRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("priceRange", priceLeft, strictLeft,
                priceRight, strictRight);
    }

    public List<BigInteger> collectIdsBySold(boolean sold) {
        return getEntityHandler().collectKeysByEqualsOrContains("sold", sold);
    }
}
