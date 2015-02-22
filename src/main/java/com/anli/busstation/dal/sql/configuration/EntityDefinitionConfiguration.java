package com.anli.busstation.dal.sql.configuration;

import com.anli.busstation.dal.sql.definitions.EntityDefinitionBuilder;
import com.anli.simpleorm.definitions.EntityDefinition;
import com.anli.simpleorm.queries.named.NamedQuery;
import java.util.HashMap;
import java.util.Map;

public class EntityDefinitionConfiguration {

    protected Map<String, EntityDefinition> definitions;
    protected boolean built;

    public EntityDefinitionConfiguration() {
        definitions = new HashMap<>();
        built = false;
    }

    public EntityDefinition getDefinition(String entityName) {
        if (!built) {
            buildConfig();
            built = true;
        }
        return definitions.get(entityName);
    }

    protected EntityDefinition store(EntityDefinition definition) {
        definitions.put(definition.getName(), definition);
        return definition;
    }

    protected void buildConfig() {
        EntityDefinition technicalState = store(getTechnicalStateDefinition());
        EntityDefinition gasLabel = store(getGasLabelDefinition());
        EntityDefinition model = store(getModelDefinition(gasLabel));
        EntityDefinition bus = store(getBusDefinition(model, technicalState));

        EntityDefinition driverSkill = store(getDriverSkillDefinition());
        EntityDefinition mechanicSkill = store(getMechanicSkillDefinition());
        EntityDefinition employee = store(getEmployeeDefinition());
        EntityDefinition driver = store(getDriverDefinition(employee, driverSkill));
        EntityDefinition mechanic = store(getMechanicDefinition(employee, mechanicSkill));
        EntityDefinition salesman = store(getSalesmanDefinition(employee));

        EntityDefinition technicalAssignment = store(getTechnicalAssignmentDefinition(mechanic));
        store(getStationServiceDefinition(technicalAssignment));
        EntityDefinition busService = store(getBusServiceDefinition(technicalAssignment, bus));
        store(getBusRefuellingDefinition(busService));
        store(getBusRepairmentDefinition(busService));

        EntityDefinition station = store(getStationDefinition(employee, bus));
        EntityDefinition road = store(getRoadDefinition(station));
        store(getRegionDefinition(station));

        EntityDefinition routePoint = store(getRoutePointDefinition(station));
        EntityDefinition ridePoint = store(getRidePointDefinition(routePoint));
        EntityDefinition rideRoad = store(getRideRoadDefinition(road, driver));
        EntityDefinition ticket = store(getTicketDefinition(ridePoint, salesman));
        EntityDefinition ride = store(getRideDefinition(bus, ridePoint, rideRoad, ticket));
        store(getRouteDefinition(routePoint, ride));

    }

    protected EntityDefinition getTechnicalStateDefinition() {
        return getBuilder().create("TechnicalState", "technical_states")
                .addPrimaryKey("state_id")
                .addStringField("description", "description")
                .addIntegerField("difficultyLevel", "difficulty_level").build();
    }

    protected EntityDefinition getGasLabelDefinition() {
        return getBuilder().create("GasLabel", "gas_labels").addPrimaryKey("label_id")
                .addStringField("name", "name").addBigDecimalField("price", "price").build();
    }

    protected EntityDefinition getModelDefinition(EntityDefinition gasLabel) {
        return getBuilder().create("Model", "models").addPrimaryKey("model_id")
                .addStringField("name", "name").addIntegerField("seatsNumber", "seats_number")
                .addIntegerField("tankVolume", "tank_volume")
                .addReferenceField("gasLabel", "gas_label", gasLabel)
                .addBigDecimalField("gasRate", "gas_rate").build();
    }

    protected EntityDefinition getBusDefinition(EntityDefinition model, EntityDefinition technicalState) {
        return getBuilder().create("Bus", "buses").addPrimaryKey("bus_id")
                .addReferenceField("model", "model", model)
                .addReferenceField("state", "state", technicalState)
                .addStringField("plate", "plate").build();
    }

    protected EntityDefinition getDriverSkillDefinition() {
        return getBuilder().create("DriverSkill", "driver_skills").addPrimaryKey("skill_id")
                .addStringField("name", "name").addIntegerField("maxRideLength", "max_ride_length")
                .addIntegerField("maxPassengers", "max_passengers").build();
    }

    protected EntityDefinition getMechanicSkillDefinition() {
        return getBuilder().create("MechanicSkill", "mechanic_skills").addPrimaryKey("skill_id")
                .addStringField("name", "name").addIntegerField("maxDiffLevel", "max_diff_level").build();
    }

    protected EntityDefinition getEmployeeDefinition() {
        return getBuilder().create("Employee", "employees").addPrimaryKey("employee_id")
                .addStringField("name", "name").addBigDecimalField("salary", "salary")
                .addDateTimeField("hiringDate", "hiring_date").build();
    }

    protected EntityDefinition getDriverDefinition(EntityDefinition employee, EntityDefinition skill) {
        return getBuilder().create("Driver", "drivers").setParent(employee).addPrimaryKey("employee_id")
                .addReferenceField("skill", "skill", skill).build();
    }

    protected EntityDefinition getMechanicDefinition(EntityDefinition employee, EntityDefinition skill) {
        return getBuilder().create("Mechanic", "mechanics").setParent(employee).addPrimaryKey("employee_id")
                .addReferenceField("skill", "skill", skill).build();
    }

    protected EntityDefinition getSalesmanDefinition(EntityDefinition employee) {
        return getBuilder().create("Salesman", "salesmen").setParent(employee)
                .addPrimaryKey("employee_id").addIntegerField("totalSales", "total_sales").build();
    }

    protected EntityDefinition getTechnicalAssignmentDefinition(EntityDefinition mechanic) {
        return getBuilder().create("TechnicalAssignment", "technical_assignments")
                .addPrimaryKey("assignment_id").addReferenceField("mechanic", "mechanic", mechanic)
                .addDateTimeField("beginTime", "begin_time").addDateTimeField("endTime", "end_time")
                .addBigDecimalField("serviceCost", "service_cost").build();
    }

    protected EntityDefinition getStationServiceDefinition(EntityDefinition technicalAssignment) {
        return getBuilder().create("StationService", "station_services")
                .setParent(technicalAssignment).addPrimaryKey("assignment_id")
                .addStringField("description", "description").build();
    }

    protected EntityDefinition getBusServiceDefinition(EntityDefinition technicalAssignment, EntityDefinition bus) {
        return getBuilder().create("BusService", "bus_services").setParent(technicalAssignment)
                .addPrimaryKey("assignment_id").addReferenceField("bus", "bus", bus).build();
    }

    protected EntityDefinition getBusRefuellingDefinition(EntityDefinition busService) {
        return getBuilder().create("BusRefuelling", "bus_refuellings").setParent(busService)
                .addPrimaryKey("assignment_id").addIntegerField("volume", "gas_volume").build();
    }

    protected EntityDefinition getBusRepairmentDefinition(EntityDefinition busService) {
        return getBuilder().create("BusRepairment", "bus_repairments").setParent(busService)
                .addPrimaryKey("assignment_id").addBigDecimalField("expendablesPrice", "expendables_price").build();
    }

    protected EntityDefinition getStationDefinition(EntityDefinition employee, EntityDefinition bus) {
        return getBuilder().create("Station", "stations").addPrimaryKey("station_id")
                .addStringField("name", "name").addBigDecimalField("latitude", "latitude")
                .addBigDecimalField("longitude", "longitude")
                .addListField("employees", employee, "station", "station_order")
                .addListField("buses", bus, "station", "station_order").build();
    }

    protected EntityDefinition getRoadDefinition(EntityDefinition station) {
        return getBuilder().create("Road", "roads").addPrimaryKey("road_id")
                .addReferenceField("aStation", "a_station", station)
                .addReferenceField("zStation", "z_station", station)
                .addIntegerField("length", "length").addBigDecimalField("ridePrice", "ride_price")
                .addNamedQuery("byStation", "", "where road.a_station = ? or road.z_station = ?")
                .addNamedQuery("byAnyStation", "", "where road.a_station in (" 
                        + NamedQuery.getListMacro() + ") or road.z_station in ("
                        + NamedQuery.getListMacro() + ")").build();
    }

    protected EntityDefinition getRegionDefinition(EntityDefinition station) {
        return getBuilder().create("Region", "regions").addPrimaryKey("region_id")
                .addStringField("name", "name").addIntegerField("code", "num_code")
                .addListField("stations", station, "region", "region_order").build();
    }

    protected EntityDefinition getRoutePointDefinition(EntityDefinition station) {
        return getBuilder().create("RoutePoint", "route_points").addPrimaryKey("route_point_id")
                .addReferenceField("station", "station", station).build();
    }

    protected EntityDefinition getRidePointDefinition(EntityDefinition routePoint) {
        return getBuilder().create("RidePoint", "ride_points").addPrimaryKey("ride_point_id")
                .addReferenceField("routePoint", "route_point", routePoint)
                .addDateTimeField("arrivalTime", "arrival_time")
                .addDateTimeField("departureTime", "departure_time").build();
    }

    protected EntityDefinition getRideRoadDefinition(EntityDefinition road, EntityDefinition driver) {
        return getBuilder().create("RideRoad", "ride_roads").addPrimaryKey("ride_road_id")
                .addReferenceField("road", "road", road).addReferenceField("driver", "driver", driver).build();
    }

    protected EntityDefinition getTicketDefinition(EntityDefinition ridePoint, EntityDefinition salesman) {
        return getBuilder().create("Ticket", "tickets").addPrimaryKey("ticket_id")
                .addReferenceField("departurePoint", "departure_point", ridePoint)
                .addReferenceField("arrivalPoint", "arrival_point", ridePoint)
                .addIntegerField("seat", "seat").addReferenceField("salesman", "salesman", salesman)
                .addDateTimeField("saleDate", "sale_date").addStringField("customerName", "customer_name")
                .addBigDecimalField("price", "price").addBooleanField("sold", "is_sold").build();
    }

    protected EntityDefinition getRideDefinition(EntityDefinition bus, EntityDefinition ridePoint,
            EntityDefinition rideRoad, EntityDefinition ticket) {
        return getBuilder().create("Ride", "rides").addPrimaryKey("ride_id")
                .addReferenceField("bus", "bus", bus)
                .addListField("ridePoints", ridePoint, "ride", "ride_order")
                .addListField("rideRoads", rideRoad, "ride", "ride_order")
                .addListField("tickets", ticket, "ride", "ride_order").build();
    }

    protected EntityDefinition getRouteDefinition(EntityDefinition routePoint, EntityDefinition ride) {
        return getBuilder().create("Route", "routes").addPrimaryKey("route_id")
                .addStringField("numCode", "num_code").addBigDecimalField("ticketPrice", "ticket_price")
                .addListField("routePoints", routePoint, "route", "route_order")
                .addListField("rides", ride, "route", "route_order").build();
    }

    protected EntityDefinitionBuilder getBuilder() {
        return new EntityDefinitionBuilder();
    }
}
