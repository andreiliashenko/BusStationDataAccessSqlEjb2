package com.anli.busstation.dal.sql.gateways.maintenance;

import com.anli.busstation.dal.ejb2.entities.maintenance.BusRefuellingImpl;
import com.anli.busstation.dal.ejb2.entities.maintenance.BusRepairmentImpl;
import com.anli.busstation.dal.ejb2.entities.maintenance.BusServiceImpl;
import com.anli.simpleorm.handling.EntityGateway;
import com.anli.simpleorm.handling.SuperEntityGateway;
import java.util.HashMap;

public class BusServiceGateway extends SuperEntityGateway<BusServiceImpl> {

    public BusServiceGateway(BusRefuellingGateway busRefuelling, BusRepairmentGateway busRepairment) {
        super(new HashMap<Class<? extends BusServiceImpl>, EntityGateway<? extends BusServiceImpl>>());
        mapping.put(BusRefuellingImpl.class, busRefuelling);
        mapping.put(BusRepairmentImpl.class, busRepairment);
    }
}
