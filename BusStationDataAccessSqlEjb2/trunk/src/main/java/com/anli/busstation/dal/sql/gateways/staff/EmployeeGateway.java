package com.anli.busstation.dal.sql.gateways.staff;

import com.anli.busstation.dal.ejb2.entities.staff.DriverImpl;
import com.anli.busstation.dal.ejb2.entities.staff.EmployeeImpl;
import com.anli.busstation.dal.ejb2.entities.staff.MechanicImpl;
import com.anli.busstation.dal.ejb2.entities.staff.SalesmanImpl;
import com.anli.simpleorm.handling.EntityGateway;
import com.anli.simpleorm.handling.SuperEntityGateway;
import java.util.HashMap;

public class EmployeeGateway extends SuperEntityGateway<EmployeeImpl> {

    public EmployeeGateway(MechanicGateway mechanicGateway, DriverGateway driverGateway,
            SalesmanGateway salesmanGateway) {
        super(new HashMap<Class<? extends EmployeeImpl>, EntityGateway<? extends EmployeeImpl>>());
        mapping.put(MechanicImpl.class, mechanicGateway);
        mapping.put(DriverImpl.class, driverGateway);
        mapping.put(SalesmanImpl.class, salesmanGateway);
    }
}
