package com.anli.busstation.dal.ejb2.entities.vehicles;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;

public class TechnicalStateImpl extends BSEntityImpl implements TechnicalState {

    protected String description;
    protected Integer difficultyLevel;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    @Override
    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        TechnicalStateImpl tsComparee = (TechnicalStateImpl) comparee;
        return nullableEquals(this.description, tsComparee.description)
                && nullableEquals(this.difficultyLevel, tsComparee.difficultyLevel);
    }

    @Override
    public String toString() {
        return super.toString() + " description = " + description
                + " difficultyLevel = " + difficultyLevel;
    }
}
