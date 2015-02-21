package com.anli.busstation.dal.ejb2.entities.traffic;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.ejb2.entities.staff.SalesmanImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.entities.staff.Salesman;
import com.anli.busstation.dal.interfaces.entities.traffic.Ticket;
import java.math.BigDecimal;
import org.joda.time.DateTime;

public class TicketImpl extends BSEntityImpl implements Ticket {

    protected RidePointImpl departurePoint;
    protected RidePointImpl arrivalPoint;
    protected Integer seat;
    protected SalesmanImpl salesman;
    protected DateTime saleDate;
    protected String customerName;
    protected BigDecimal price;
    protected boolean sold;

    @Override
    public RidePoint getDeparturePoint() {
        return departurePoint;
    }

    @Override
    public void setDeparturePoint(RidePoint departurePoint) {
        this.departurePoint = (RidePointImpl) departurePoint;
    }

    @Override
    public RidePoint getArrivalPoint() {
        return arrivalPoint;
    }

    @Override
    public void setArrivalPoint(RidePoint arrivalPoint) {
        this.arrivalPoint = (RidePointImpl) arrivalPoint;
    }

    @Override
    public Integer getSeat() {
        return seat;
    }

    @Override
    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    @Override
    public Salesman getSalesman() {
        return salesman;
    }

    @Override
    public void setSalesman(Salesman salesman) {
        this.salesman = (SalesmanImpl) salesman;
    }

    @Override
    public DateTime getSaleDate() {
        return saleDate;
    }

    @Override
    public void setSaleDate(DateTime saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean isSold() {
        return sold;
    }

    @Override
    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        TicketImpl ticketComparee = (TicketImpl) comparee;
        return nullableDeepEquals(this.arrivalPoint, ticketComparee.arrivalPoint)
                && nullableDeepEquals(this.departurePoint, ticketComparee.departurePoint)
                && nullableDeepEquals(this.salesman, ticketComparee.salesman)
                && nullableEquals(this.customerName, ticketComparee.customerName)
                && nullableEquals(this.saleDate, ticketComparee.saleDate)
                && nullableEquals(this.seat, ticketComparee.seat)
                && nullableEquals(this.price, ticketComparee.price)
                && this.sold == ticketComparee.sold;
    }

    @Override
    public String toString() {
        return super.toString() + " arrivalPoint = {" + arrivalPoint + "} departurePoint = "
                + departurePoint + "} salesman = {" + salesman + "} customerName = " + customerName
                + " saleDate = " + saleDate + " seat = " + seat + " price = " + price + " sold = " + sold;
    }
}
