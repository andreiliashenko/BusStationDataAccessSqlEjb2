package com.anli.busstation.dal.sql.configuration;

import com.anli.busstation.dal.sql.gateways.geography.RegionGateway;
import com.anli.busstation.dal.sql.gateways.geography.RoadGateway;
import com.anli.busstation.dal.sql.gateways.geography.StationGateway;
import com.anli.busstation.dal.sql.gateways.maintenance.BusRefuellingGateway;
import com.anli.busstation.dal.sql.gateways.maintenance.BusRepairmentGateway;
import com.anli.busstation.dal.sql.gateways.maintenance.BusServiceGateway;
import com.anli.busstation.dal.sql.gateways.maintenance.StationServiceGateway;
import com.anli.busstation.dal.sql.gateways.maintenance.TechnicalAssignmentGateway;
import com.anli.busstation.dal.sql.gateways.staff.DriverGateway;
import com.anli.busstation.dal.sql.gateways.staff.DriverSkillGateway;
import com.anli.busstation.dal.sql.gateways.staff.EmployeeGateway;
import com.anli.busstation.dal.sql.gateways.staff.MechanicGateway;
import com.anli.busstation.dal.sql.gateways.staff.MechanicSkillGateway;
import com.anli.busstation.dal.sql.gateways.staff.SalesmanGateway;
import com.anli.busstation.dal.sql.gateways.traffic.RideGateway;
import com.anli.busstation.dal.sql.gateways.traffic.RidePointGateway;
import com.anli.busstation.dal.sql.gateways.traffic.RideRoadGateway;
import com.anli.busstation.dal.sql.gateways.traffic.RouteGateway;
import com.anli.busstation.dal.sql.gateways.traffic.RoutePointGateway;
import com.anli.busstation.dal.sql.gateways.traffic.TicketGateway;
import com.anli.busstation.dal.sql.gateways.vehicles.BusGateway;
import com.anli.busstation.dal.sql.gateways.vehicles.GasLabelGateway;
import com.anli.busstation.dal.sql.gateways.vehicles.ModelGateway;
import com.anli.busstation.dal.sql.gateways.vehicles.TechnicalStateGateway;
import com.anli.simpleorm.handling.EntityGateway;
import java.util.HashMap;
import java.util.Map;

public class EntityGatewayConfiguration {

    protected final Map<String, EntityGateway> gateways;
    protected boolean built;

    public EntityGatewayConfiguration() {
        this.gateways = new HashMap<>();
        built = false;
    }

    protected void buildConfig() {
        gateways.put("Bus", new BusGateway());
        gateways.put("GasLabel", new GasLabelGateway());
        gateways.put("Model", new ModelGateway());
        gateways.put("TechnicalState", new TechnicalStateGateway());

        gateways.put("DriverSkill", new DriverSkillGateway());
        gateways.put("MechanicSkill", new MechanicSkillGateway());
        MechanicGateway mechanic = new MechanicGateway();
        DriverGateway driver = new DriverGateway();
        SalesmanGateway salesman = new SalesmanGateway();
        gateways.put("Mechanic", mechanic);
        gateways.put("Driver", driver);
        gateways.put("Salesman", salesman);
        gateways.put("Employee", new EmployeeGateway(mechanic, driver, salesman));

        gateways.put("Region", new RegionGateway());
        gateways.put("Road", new RoadGateway());
        gateways.put("Station", new StationGateway());
        BusRepairmentGateway busRepairment = new BusRepairmentGateway();
        BusRefuellingGateway busRefuelling = new BusRefuellingGateway();
        BusServiceGateway busService = new BusServiceGateway(busRefuelling, busRepairment);
        StationServiceGateway stationService = new StationServiceGateway();
        gateways.put("BusRepairment", busRepairment);
        gateways.put("BusRefuelling", busRefuelling);
        gateways.put("BusService", busService);
        gateways.put("StationService", stationService);
        gateways.put("TechnicalAssignment", new TechnicalAssignmentGateway(busService, stationService));

        gateways.put("Ride", new RideGateway());
        gateways.put("RidePoint", new RidePointGateway());
        gateways.put("RideRoad", new RideRoadGateway());
        gateways.put("Route", new RouteGateway());
        gateways.put("RoutePoint", new RoutePointGateway());
        gateways.put("Ticket", new TicketGateway());
    }

    public <Entity> EntityGateway<Entity> getGateway(String entityName) {
        if (!built) {
            buildConfig();
            built = true;
        }
        return gateways.get(entityName);
    }
}
