package com.anli.busstation.dal.ejb2.entities.staff;

import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.staff.Salesman;

public class SalesmanImpl extends EmployeeImpl implements Salesman {

    protected Integer totalSales;

    @Override
    public Integer getTotalSales() {
        return totalSales;
    }

    @Override
    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!super.deepEquals(comparee)) {
            return false;
        }
        SalesmanImpl salesComparee = (SalesmanImpl) comparee;
        return nullableEquals(this.totalSales, salesComparee.totalSales);
    }

    @Override
    public String toString() {
        return super.toString() + " totalSales = " + totalSales;
    }
}
