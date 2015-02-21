package com.anli.busstation.dal.ejb2.entities.maintenance;

import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.maintenance.StationService;

public class StationServiceImpl extends TechnicalAssignmentImpl implements StationService {

    protected String description;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!super.deepEquals(comparee)) {
            return false;
        }
        StationServiceImpl ssComparee = (StationServiceImpl) comparee;
        return nullableEquals(this.description, ssComparee.description);
    }

    @Override
    public String toString() {
        return super.toString() + " description = " + description;
    }
}
