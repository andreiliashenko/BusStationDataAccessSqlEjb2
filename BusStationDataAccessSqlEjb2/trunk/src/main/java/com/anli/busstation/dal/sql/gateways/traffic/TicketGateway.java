package com.anli.busstation.dal.sql.gateways.traffic;

import com.anli.busstation.dal.ejb2.entities.traffic.TicketImpl;
import com.anli.busstation.dal.interfaces.entities.staff.Salesman;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.sql.gateways.BSEntityGateway;
import com.anli.simpleorm.handling.EntityBuilder;
import java.math.BigDecimal;
import org.joda.time.DateTime;

public class TicketGateway extends BSEntityGateway<TicketImpl> {

    protected static final String TICKET = "Ticket";
    protected static final String ARRIVAL_POINT = "arrivalPoint";
    protected static final String CUSTOMER_NAME = "customerName";
    protected static final String DEPARTURE_POINT = "departurePoint";
    protected static final String PRICE = "price";
    protected static final String SALE_DATE = "saleDate";
    protected static final String SALESMAN = "salesman";
    protected static final String SEAT = "seat";
    protected static final String SOLD = "sold";

    @Override
    public EntityBuilder<TicketImpl> getBuilder(String entityName) {
        if (TICKET.equals(entityName)) {
            return new TicketBuilder();
        }
        return null;
    }

    @Override
    public Object extractSingle(TicketImpl entity, String entityName, String fieldName) {
        if (TICKET.equals(entityName)) {
            if (ARRIVAL_POINT.equals(fieldName)) {
                return getId(entity.getArrivalPoint());
            }
            if (CUSTOMER_NAME.equals(fieldName)) {
                return entity.getCustomerName();
            }
            if (DEPARTURE_POINT.equals(fieldName)) {
                return getId(entity.getDeparturePoint());
            }
            if (PRICE.equals(fieldName)) {
                return entity.getPrice();
            }
            if (SALE_DATE.equals(fieldName)) {
                return entity.getSaleDate();
            }
            if (SALESMAN.equals(fieldName)) {
                return getId(entity.getSalesman());
            }
            if (SEAT.equals(fieldName)) {
                return entity.getSeat();
            }
            if (SOLD.equals(fieldName)) {
                return entity.isSold();
            }
        }
        return super.extractSingle(entity, entityName, fieldName);
    }

    @Override
    public Object extractFullReference(TicketImpl entity, String entityName, String fieldName) {
        if (TICKET.equals(entityName)) {
            if (ARRIVAL_POINT.equals(fieldName)) {
                return entity.getArrivalPoint();
            }
            if (DEPARTURE_POINT.equals(fieldName)) {
                return entity.getDeparturePoint();
            }
            if (SALESMAN.equals(fieldName)) {
                return entity.getSalesman();
            }
        }
        return super.extractFullReference(entity, entityName, fieldName);
    }

    protected class TicketBuilder extends BSEntityBuilder {

        @Override
        protected TicketImpl getNewInstance() {
            return new TicketImpl();
        }

        @Override
        protected String getEntityName() {
            return TICKET;
        }

        @Override
        public EntityBuilder setSingle(String entityName, String fieldName, Object fieldValue) {
            if (TICKET.equals(entityName)) {
                if (ARRIVAL_POINT.equals(fieldName)) {
                    getInstance().setArrivalPoint((RidePoint) fieldValue);
                    return this;
                }
                if (CUSTOMER_NAME.equals(fieldName)) {
                    getInstance().setCustomerName((String) fieldValue);
                    return this;
                }
                if (DEPARTURE_POINT.equals(fieldName)) {
                    getInstance().setDeparturePoint((RidePoint) fieldValue);
                    return this;
                }
                if (PRICE.equals(fieldName)) {
                    getInstance().setPrice((BigDecimal) fieldValue);
                    return this;
                }
                if (SALE_DATE.equals(fieldName)) {
                    getInstance().setSaleDate((DateTime) fieldValue);
                    return this;
                }
                if (SALESMAN.equals(fieldName)) {
                    getInstance().setSalesman((Salesman) fieldValue);
                    return this;
                }
                if (SEAT.equals(fieldName)) {
                    getInstance().setSeat((Integer) fieldValue);
                    return this;
                }
                if (SOLD.equals(fieldName)) {
                    getInstance().setSold((Boolean) fieldValue);
                    return this;
                }
            }
            return super.setSingle(entityName, fieldName, fieldValue);
        }
    }
}
