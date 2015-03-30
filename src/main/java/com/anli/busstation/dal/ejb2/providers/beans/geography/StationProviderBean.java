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
        return pullCollection(station, "employees");
    }

    public Station pullBuses(Station station) {
        return pullCollection(station, "buses");
    }

    public List<Station> findByName(String name) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("name", name);
    }

    public List<Station> findByNameRegexp(String nameRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("name", nameRegexp);
    }

    public List<Station> findByLatitudeRange(BigDecimal latitudeLeft, boolean strictLeft,
            BigDecimal latitudeRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("latitude", latitudeLeft,
                strictLeft, latitudeRight, strictRight);
    }

    public List<Station> findByLongitudeRange(BigDecimal longitudeLeft, boolean strictLeft,
            BigDecimal longitudeRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("longitude", longitudeLeft,
                strictLeft, longitudeRight, strictRight);
    }

    public List<Station> findByEmployee(Employee employee) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("employees", employee);
    }

    public List<Station> findByAnyEmployee(Collection<Employee> employees) {
        return getEntityHandler().selectEntitiesByAny("employees", employees);
    }

    public List<Station> findByBus(Bus bus) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("buses", bus);
    }

    public List<Station> findByAnyBus(Collection<Bus> buses) {
        return getEntityHandler().selectEntitiesByAny("buses", buses);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String nameRegexp) {
        return getEntityHandler().collectKeysByRegexp("name", nameRegexp);
    }

    public List<BigInteger> collectIdsByLatitudeRange(BigDecimal latitudeLeft, boolean strictLeft,
            BigDecimal latitudeRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("latitude", latitudeLeft, strictLeft,
                latitudeRight, strictRight);
    }

    public List<BigInteger> collectIdsByLongitudeRange(BigDecimal longitudeLeft, boolean strictLeft,
            BigDecimal longitudeRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("longitude", longitudeLeft, strictLeft,
                longitudeRight, strictRight);
    }

    public List<BigInteger> collectIdsByEmployee(Employee employee) {
        return getEntityHandler().collectKeysByEqualsOrContains("employees", employee);
    }

    public List<BigInteger> collectIdsByAnyEmployee(Collection<Employee> employees) {
        return getEntityHandler().collectKeysByAny("employees", employees);
    }

    public List<BigInteger> collectIdsByBus(Bus bus) {
        return getEntityHandler().collectKeysByEqualsOrContains("buses", bus);
    }

    public List<BigInteger> collectIdsByAnyBus(Collection<Bus> buses) {
        return getEntityHandler().collectKeysByAny("buses", buses);
    }
}
