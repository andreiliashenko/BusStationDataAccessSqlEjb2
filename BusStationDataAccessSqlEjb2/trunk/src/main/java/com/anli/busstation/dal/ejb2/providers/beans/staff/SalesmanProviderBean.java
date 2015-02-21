package com.anli.busstation.dal.ejb2.providers.beans.staff;

import com.anli.busstation.dal.interfaces.entities.staff.Salesman;
import java.math.BigInteger;
import java.util.List;

public class SalesmanProviderBean extends AbstractEmployeeProviderBean<Salesman> {

    @Override
    protected String getEntityName() {
        return "Salesman";
    }

    public List<Salesman> findByTotalSalesRange(Integer leftSales, boolean strictLeft,
            Integer rightSales, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("totalSales", leftSales, strictLeft,
                rightSales, strictRight);
    }

    public List<BigInteger> collectIdsByTotalSalesRange(Integer leftSales, boolean strictLeft,
            Integer rightSales, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("totalSales", leftSales, strictLeft,
                rightSales, strictRight);
    }
}
