package com.anli.busstation.dal.ejb2.providers.beans.staff;

import com.anli.busstation.dal.interfaces.entities.staff.Salesman;
import java.math.BigInteger;
import java.util.List;

public class SalesmanProviderBean extends AbstractEmployeeProviderBean<Salesman> {

    @Override
    protected String getEntityName() {
        return "Salesman";
    }

    public List<Salesman> findByTotalSalesRange(Integer totalSalesLeft, boolean strictLeft,
            Integer totalSalesRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("totalSales", totalSalesLeft, strictLeft,
                totalSalesRight, strictRight);
    }

    public List<BigInteger> collectIdsByTotalSalesRange(Integer totalSalesLeft, boolean strictLeft,
            Integer totalSalesRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("totalSales", totalSalesLeft, strictLeft,
                totalSalesRight, strictRight);
    }
}
