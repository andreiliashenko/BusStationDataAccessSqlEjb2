package com.anli.busstation.dal.ejb2.entities.maintenance;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.ejb2.entities.staff.MechanicImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.staff.Mechanic;
import com.anli.busstation.dal.interfaces.entities.maintenance.TechnicalAssignment;
import java.math.BigDecimal;
import org.joda.time.DateTime;

public abstract class TechnicalAssignmentImpl extends BSEntityImpl implements TechnicalAssignment {

    protected MechanicImpl mechanic;
    protected DateTime beginTime;
    protected DateTime endTime;
    protected BigDecimal serviceCost;

    @Override
    public Mechanic getMechanic() {
        return mechanic;
    }

    @Override
    public void setMechanic(Mechanic mechanic) {
        this.mechanic = (MechanicImpl) mechanic;
    }

    @Override
    public DateTime getBeginTime() {
        return beginTime;
    }

    @Override
    public void setBeginTime(DateTime beginTime) {
        this.beginTime = beginTime;
    }

    @Override
    public DateTime getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public BigDecimal getServiceCost() {
        return serviceCost;
    }

    @Override
    public void setServiceCost(BigDecimal serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        TechnicalAssignmentImpl taComparee = (TechnicalAssignmentImpl) comparee;
        return nullableDeepEquals(this.mechanic, taComparee.mechanic)
                && nullableEquals(this.beginTime, taComparee.beginTime)
                && nullableEquals(this.endTime, taComparee.endTime)
                && nullableEquals(this.serviceCost, taComparee.serviceCost);
    }

    @Override
    public String toString() {
        return super.toString() + " mechanic = {" + mechanic + "} beginTime = "
                + beginTime + " endTime = " + endTime + " serviceCost = " + serviceCost;
    }
}
