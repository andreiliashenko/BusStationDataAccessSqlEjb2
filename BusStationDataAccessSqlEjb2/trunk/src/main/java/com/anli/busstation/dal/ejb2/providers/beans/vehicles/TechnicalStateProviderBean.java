package com.anli.busstation.dal.ejb2.providers.beans.vehicles;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class TechnicalStateProviderBean extends AbstractBSProviderBean<TechnicalState> {

    @Override
    protected String getEntityName() {
        return "TechnicalState";
    }

    public List<TechnicalState> findByDescriptionRegexp(String descrRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("description", descrRegexp);
    }

    public List<TechnicalState> findByDifficultyLevel(Integer diffLevel) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("difficultyLevel", diffLevel);
    }

    public List<TechnicalState> findByDifficultyLevelRange(Integer dlLeft, boolean strictLeft,
            Integer dlRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("difficultyLevel", dlLeft, strictLeft,
                dlRight, strictRight);
    }

    public List<BigInteger> collectIdsByDescriptionRegexp(String descrRegexp) {
        return getEntityHandler().collectKeysByRegexp("description", descrRegexp);
    }

    public List<BigInteger> collectIdsByDifficultyLevel(Integer diffLevel) {
        return getEntityHandler().collectKeysByEqualsOrContains("difficultyLevel", diffLevel);
    }

    public List<BigInteger> collectIdsByDifficultyLevelRange(Integer dlLeft, boolean strictLeft,
            Integer dlRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("difficultyLevel", dlLeft, strictLeft,
                dlRight, strictRight);
    }
}
