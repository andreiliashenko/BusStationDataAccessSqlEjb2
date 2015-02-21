package com.anli.busstation.dal.ejb2.entities.maintenance;

import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.maintenance.BusRepairment;
import java.math.BigDecimal;

public class BusRepairmentImpl extends BusServiceImpl implements BusRepairment {

    protected BigDecimal expendablesPrice;

    @Override
    public BigDecimal getExpendablesPrice() {
        return expendablesPrice;
    }

    @Override
    public void setExpendablesPrice(BigDecimal expendablesPrice) {
        this.expendablesPrice = expendablesPrice;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!super.deepEquals(comparee)) {
            return false;
        }
        BusRepairmentImpl brComparee = (BusRepairmentImpl) comparee;
        return nullableEquals(this.expendablesPrice, brComparee.expendablesPrice);
    }

    @Override
    public String toString() {
        return super.toString() + " expendablesPrice = " + expendablesPrice;
    }
}
