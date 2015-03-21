package com.anli.busstation.dal.ejb2.providers.beans.vehicles;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;
import java.math.BigInteger;
import java.util.List;

public class TechnicalStateProviderBean extends AbstractBSProviderBean<TechnicalState> {

    @Override
    protected String getEntityName() {
        return "TechnicalState";
    }

    public List<TechnicalState> findByDescriptionRegexp(String descriptionRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("description", descriptionRegexp);
    }

    public List<TechnicalState> findByDifficultyLevel(Integer difficultyLevel) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("difficultyLevel", difficultyLevel);
    }

    public List<TechnicalState> findByDifficultyLevelRange(Integer difficultyLevelLeft, boolean strictLeft,
            Integer difficultyLevelRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("difficultyLevel", difficultyLevelLeft, strictLeft,
                difficultyLevelRight, strictRight);
    }

    public List<BigInteger> collectIdsByDescriptionRegexp(String descriptionRegexp) {
        return getEntityHandler().collectKeysByRegexp("description", descriptionRegexp);
    }

    public List<BigInteger> collectIdsByDifficultyLevel(Integer difficultyLevel) {
        return getEntityHandler().collectKeysByEqualsOrContains("difficultyLevel", difficultyLevel);
    }

    public List<BigInteger> collectIdsByDifficultyLevelRange(Integer difficultyLevelLeft, boolean strictLeft,
            Integer difficultyLevelRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("difficultyLevel", difficultyLevelLeft, strictLeft,
                difficultyLevelRight, strictRight);
    }
}
