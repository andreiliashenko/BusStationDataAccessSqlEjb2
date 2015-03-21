package com.anli.busstation.dal.ejb2.providers.beans.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.BusRepairment;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class BusRepairmentProviderBean extends AbstractBusServiceProviderBean<BusRepairment> {

    @Override
    protected String getEntityName() {
        return "BusRepairment";
    }

    public List<BusRepairment> findByExpendablesPriceRange(BigDecimal expendablesPriceLeft, boolean leftStrict,
            BigDecimal expendablesPriceRight, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("expendablesPrice", expendablesPriceLeft, leftStrict,
                expendablesPriceRight, rightStrict);
    }

    public List<BigInteger> collectIdsByExpendablesPriceRange(BigDecimal expendablesPriceLeft, boolean leftStrict,
            BigDecimal expendablesPriceRight, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("expendablesPrice", expendablesPriceLeft, leftStrict,
                expendablesPriceRight, rightStrict);
    }
}
