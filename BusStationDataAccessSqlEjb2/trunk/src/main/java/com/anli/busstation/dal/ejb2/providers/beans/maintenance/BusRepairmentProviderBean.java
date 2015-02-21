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

    public List<BusRepairment> findByExpendablesPriceRange(BigDecimal exPriceLeft, boolean leftStrict,
            BigDecimal exPriceRight, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("expendablesPrice", exPriceLeft, leftStrict,
                exPriceRight, rightStrict);
    }

    public List<BigInteger> collectIdsByExpendablesPriceRange(BigDecimal exPriceLeft, boolean leftStrict,
            BigDecimal exPriceRight, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("expendablesPrice", exPriceLeft, leftStrict,
                exPriceRight, rightStrict);
    }
}
