package com.anli.busstation.dal.ejb2.providers.beans.vehicles;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.vehicles.GasLabel;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class GasLabelProviderBean extends AbstractBSProviderBean<GasLabel> {

    @Override
    protected String getEntityName() {
        return "GasLabel";
    }

    public List<GasLabel> findByName(String name) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("name", name);
    }

    public List<GasLabel> findByNameRegexp(String regexpName) {
        return getEntityHandler().selectEntitiesByRegexp("name", regexpName);
    }

    public List<GasLabel> findByPriceRange(BigDecimal priceLeft, boolean leftStrict,
            BigDecimal priceRight, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("price", priceLeft, leftStrict,
                priceRight, rightStrict);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String regexpName) {
        return getEntityHandler().collectKeysByRegexp("name", regexpName);
    }

    public List<BigInteger> collectIdsByPriceRange(BigDecimal priceLeft, boolean leftStrict,
            BigDecimal priceRight, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("price", priceLeft, leftStrict,
                priceRight, rightStrict);
    }
}
