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

    public List<Model> findBySeatsNumberRange(Integer seatsNumberLeft, boolean strictLeft,
            Integer seatsNumberRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("seatsNumber", seatsNumberLeft, strictLeft,
                seatsNumberRight, strictRight);
    }

    public List<Model> findByGasLabel(GasLabel gasLabel) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("gasLabel", gasLabel);
    }

    public List<Model> findByAnyGasLabel(Collection<GasLabel> gasLabels) {
        return getEntityHandler().selectEntitiesByAny("gasLabel", gasLabels);
    }

    public List<Model> findByGasRateRange(BigDecimal gasRateLeft, boolean strictLeft,
            BigDecimal gasRateRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("gasRate", gasRateLeft, strictLeft,
                gasRateRight, strictRight);
    }

    public List<Model> findByTankVolumeRange(Integer tankVolumeLeft, boolean strictLeft,
            Integer tankVolumeRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("tankVolume", tankVolumeLeft, strictLeft,
                tankVolumeRight, strictRight);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String nameRegexp) {
        return getEntityHandler().collectKeysByRegexp("name", nameRegexp);
    }

    public List<BigInteger> collectIdsBySeatsNumberRange(Integer seatsNumberLeft, boolean strictLeft,
            Integer seatsNumberRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("seatsNumber", seatsNumberLeft, strictLeft,
                seatsNumberRight, strictRight);
    }

    public List<BigInteger> collectIdsByGasLabel(GasLabel gasLabel) {
        return getEntityHandler().collectKeysByEqualsOrContains("gasLabel", gasLabel);
    }

    public List<BigInteger> collectIdsByAnyGasLabel(Collection<GasLabel> gasLabels) {
        return getEntityHandler().collectKeysByAny("gasLabel", gasLabels);
    }

    public List<BigInteger> collectIdsByGasRateRange(BigDecimal gasRateLeft, boolean strictLeft,
            BigDecimal gasRateRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("gasRate", gasRateLeft, strictLeft,
                gasRateRight, strictRight);
    }

    public List<BigInteger> collectIdsByTankVolumeRange(Integer tankVolumeLeft, boolean strictLeft,
            Integer tankVolumeRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("tankVolume", tankVolumeLeft, strictLeft,
                tankVolumeRight, strictRight);
    }
}
