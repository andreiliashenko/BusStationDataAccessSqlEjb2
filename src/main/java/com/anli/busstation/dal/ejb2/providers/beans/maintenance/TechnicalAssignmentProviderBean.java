package com.anli.busstation.dal.ejb2.providers.beans.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.TechnicalAssignment;

public class TechnicalAssignmentProviderBean
        extends AbstractTechnicalAssignmentProviderBean<TechnicalAssignment> {

    @Override
    protected String getEntityName() {
        return "TechnicalAssignment";
    }

    @Override
    public TechnicalAssignment create() {
        return null;
    }
}
