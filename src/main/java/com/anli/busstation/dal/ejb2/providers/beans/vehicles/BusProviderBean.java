package com.anli.busstation.dal.ejb2.providers.beans.vehicles;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import com.anli.busstation.dal.interfaces.entities.vehicles.Model;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public class BusProviderBean extends AbstractBSProviderBean<Bus> {

    @Override
    protected String getEntityName() {
        return "Bus";
    }

    public List<Bus> findByModel(Model model) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("model", model);
    }

    public List<Bus> findByAnyModel(Collection<Model> models) {
        return getEntityHandler().selectEntitiesByAny("model", models);
    }

    public List<Bus> findByState(TechnicalState state) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("state", state);
    }

    public List<Bus> findByAnyState(Collection<TechnicalState> states) {
        return getEntityHandler().selectEntitiesByAny("state", states);
    }

    public List<Bus> findByPlate(String plate) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("plate", plate);
    }

    public List<BigInteger> collectIdsByModel(Model model) {
        return getEntityHandler().collectKeysByEqualsOrContains("model", model);
    }

    public List<BigInteger> collectIdsByAnyModel(Collection<Model> models) {
        return getEntityHandler().collectKeysByAny("model", models);
    }

    public List<BigInteger> collectIdsByState(TechnicalState state) {
        return getEntityHandler().collectKeysByEqualsOrContains("state", state);
    }

    public List<BigInteger> collectIdsByAnyState(Collection<TechnicalState> states) {
        return getEntityHandler().collectKeysByAny("state", states);
    }

    public List<BigInteger> collectIdsByPlate(String plate) {
        return getEntityHandler().collectKeysByEqualsOrContains("plate", plate);
    }
}
