package com.anli.busstation.dal.ejb2.entities.vehicles;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.vehicles.GasLabel;
import java.math.BigDecimal;

public class GasLabelImpl extends BSEntityImpl implements GasLabel {

    protected String name;
    protected BigDecimal price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        GasLabelImpl glComparee = (GasLabelImpl) comparee;
        return nullableEquals(this.name, glComparee.name)
                && nullableEquals(this.price, glComparee.price);
    }

    @Override
    public String toString() {
        return super.toString() + " name = " + name
                + " price = " + price;
    }
}
