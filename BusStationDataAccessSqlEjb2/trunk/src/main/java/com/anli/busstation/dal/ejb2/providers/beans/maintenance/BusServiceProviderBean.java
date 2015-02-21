package com.anli.busstation.dal.ejb2.providers.beans.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.BusService;

public class BusServiceProviderBean extends AbstractBusServiceProviderBean<BusService> {

    @Override
    protected String getEntityName() {
        return "BusService";
    }

    @Override
    public BusService create() {
        return null;
    }

    
}
