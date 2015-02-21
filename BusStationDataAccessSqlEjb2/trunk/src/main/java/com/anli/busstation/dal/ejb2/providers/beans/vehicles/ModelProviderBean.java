package com.anli.busstation.dal.ejb2.providers.beans.vehicles;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.vehicles.GasLabel;
import com.anli.busstation.dal.interfaces.entities.vehicles.Model;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public class ModelProviderBean extends AbstractBSProviderBean<Model> {

    @Override
    protected String getEntityName() {
        return "Model";
    }

    public List<Model> findByName(String name) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("name", name);
    }

    public List<Model> findByNameRegexp(String nameRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("name", nameRegexp);
    }

    public List<Model> findBySeatsNumberRange(Integer seatsLeft, boolean strictLeft,
            Integer seatsRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("seatsNumber", seatsLeft, strictLeft,
                seatsRight, strictRight);
    }

    public List<Model> findByGasLabel(GasLabel label) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("gasLabel", label);
    }

    public List<Model> findByAnyGasLabel(Collection<GasLabel> labelList) {
        return getEntityHandler().selectEntitiesByAny("gasLabel", labelList);
    }

    public List<Model> findByGasRateRange(BigDecimal rateLeft, boolean strictLeft,
            BigDecimal rateRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("gasRate", rateLeft, strictLeft,
                rateRight, strictRight);
    }

    public List<Model> findByTankVolumeRange(Integer tvLeft, boolean strictLeft,
            Integer tvRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("tankVolume", tvLeft, strictLeft,
                tvRight, strictRight);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String nameRegexp) {
        return getEntityHandler().collectKeysByRegexp("name", nameRegexp);
    }

    public List<BigInteger> collectIdsBySeatsNumberRange(Integer seatsLeft, boolean strictLeft,
            Integer seatsRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("seatsNumber", seatsLeft, strictLeft,
                seatsRight, strictRight);
    }

    public List<BigInteger> collectIdsByGasLabel(GasLabel label) {
        return getEntityHandler().collectKeysByEqualsOrContains("gasLabel", label);
    }

    public List<BigInteger> collectIdsByAnyGasLabel(Collection<GasLabel> labelList) {
        return getEntityHandler().collectKeysByAny("gasLabel", labelList);
    }

    public List<BigInteger> collectIdsByGasRateRange(BigDecimal rateLeft, boolean strictLeft,
            BigDecimal rateRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("gasRate", rateLeft, strictLeft,
                rateRight, strictRight);
    }

    public List<BigInteger> collectIdsByTankVolumeRange(Integer tvLeft, boolean strictLeft,
            Integer tvRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("tankVolume", tvLeft, strictLeft,
                tvRight, strictRight);
    }
}
