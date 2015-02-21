package com.anli.busstation.dal.ejb2.providers.beans.geography;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.staff.Employee;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public class StationProviderBean extends AbstractBSProviderBean<Station> {

    @Override
    protected String getEntityName() {
        return "Station";
    }

    public Station pullEmployees(Station station) {
        getEntityHandler().pullCollection(station, "employees");
        return station;
    }

    public Station pullBuses(Station station) {
        getEntityHandler().pullCollection(station, "buses");
        return station;
    }

    public List<Station> findByName(String name) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("name", name);
    }

    public List<Station> findByNameRegexp(String regexpName) {
        return getEntityHandler().selectEntitiesByRegexp("name", regexpName);
    }

    public List<Station> findByLatitudeRange(BigDecimal leftLat, boolean strictLeft,
            BigDecimal rightLat, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("latitude", leftLat,
                strictLeft, rightLat, strictRight);
    }

    public List<Station> findByLongitudeRange(BigDecimal leftLon, boolean strictLeft,
            BigDecimal rightLon, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("longitude", leftLon,
                strictLeft, rightLon, strictRight);
    }

    public List<Station> findByEmployee(Employee employee) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("employees", employee);
    }

    public List<Station> findByAnyEmployee(Collection<Employee> employeeList) {
        return getEntityHandler().selectEntitiesByAny("employees", employeeList);
    }

    public List<Station> findByBus(Bus bus) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("buses", bus);
    }

    public List<Station> findByAnyBus(Collection<Bus> busList) {
        return getEntityHandler().selectEntitiesByAny("buses", busList);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String regexpName) {
        return getEntityHandler().collectKeysByRegexp("name", regexpName);
    }

    public List<BigInteger> collectIdsByLatitudeRange(BigDecimal leftLat, boolean strictLeft,
            BigDecimal rightLat, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("latitude", leftLat, strictLeft,
                rightLat, strictRight);
    }

    public List<BigInteger> collectIdsByLongitudeRange(BigDecimal leftLon, boolean strictLeft,
            BigDecimal rightLon, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("longitude", leftLon, strictLeft,
                rightLon, strictRight);
    }

    public List<BigInteger> collectIdsByEmployee(Employee employee) {
        return getEntityHandler().collectKeysByEqualsOrContains("employees", employee);
    }

    public List<BigInteger> collectIdsByAnyEmployee(Collection<Employee> employeeList) {
        return getEntityHandler().collectKeysByAny("employees", employeeList);
    }

    public List<BigInteger> collectIdsByBus(Bus bus) {
        return getEntityHandler().collectKeysByEqualsOrContains("buses", bus);
    }

    public List<BigInteger> collectIdsByAnyBus(Collection<Bus> busList) {
        return getEntityHandler().collectKeysByAny("buses", busList);
    }
}
