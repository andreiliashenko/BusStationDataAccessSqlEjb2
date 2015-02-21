package com.anli.busstation.dal.ejb2.providers.beans.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.StationService;
import java.math.BigInteger;
import java.util.List;

public class StationServiceProviderBean extends AbstractTechnicalAssignmentProviderBean<StationService> {

    @Override
    protected String getEntityName() {
        return "StationService";
    }

    public List<StationService> findByDescriptionRegexp(String descrRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("description", descrRegexp);
    }

    public List<BigInteger> collectIdsByDescriptionRegexp(String descrRegexp) {
        return getEntityHandler().collectKeysByRegexp("description", descrRegexp);
    }
}
