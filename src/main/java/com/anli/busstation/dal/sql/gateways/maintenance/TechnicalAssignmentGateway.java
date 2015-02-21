package com.anli.busstation.dal.sql.gateways.maintenance;

import com.anli.busstation.dal.ejb2.entities.maintenance.BusServiceImpl;
import com.anli.busstation.dal.ejb2.entities.maintenance.StationServiceImpl;
import com.anli.busstation.dal.ejb2.entities.maintenance.TechnicalAssignmentImpl;
import com.anli.simpleorm.handling.EntityGateway;
import com.anli.simpleorm.handling.SuperEntityGateway;
import java.util.HashMap;

public class TechnicalAssignmentGateway extends SuperEntityGateway<TechnicalAssignmentImpl> {

    public TechnicalAssignmentGateway(BusServiceGateway busService, StationServiceGateway stationService) {
        super(new HashMap<Class<? extends TechnicalAssignmentImpl>, EntityGateway<? extends TechnicalAssignmentImpl>>());
        mapping.put(BusServiceImpl.class, busService);
        mapping.put(StationServiceImpl.class, stationService);
    }
}
