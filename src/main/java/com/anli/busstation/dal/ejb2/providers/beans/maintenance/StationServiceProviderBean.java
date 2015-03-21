package com.anli.busstation.dal.ejb2.providers.beans.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.StationService;
import java.math.BigInteger;
import java.util.List;

public class StationServiceProviderBean extends AbstractTechnicalAssignmentProviderBean<StationService> {

    @Override
    protected String getEntityName() {
        return "StationService";
    }

    public List<StationService> findByDescriptionRegexp(String descriptionRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("description", descriptionRegexp);
    }

    public List<BigInteger> collectIdsByDescriptionRegexp(String descriptionRegexp) {
        return getEntityHandler().collectKeysByRegexp("description", descriptionRegexp);
    }
}
