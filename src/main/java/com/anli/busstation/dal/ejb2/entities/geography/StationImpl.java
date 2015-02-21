package com.anli.busstation.dal.ejb2.entities.geography;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.ejb2.entities.vehicles.BusImpl;
import com.anli.busstation.dal.ejb2.entities.staff.EmployeeImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import com.anli.busstation.dal.interfaces.entities.staff.Employee;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import java.math.BigDecimal;
import java.util.List;

public class StationImpl extends BSEntityImpl implements Station {

    protected String name;
    protected BigDecimal latitude;
    protected BigDecimal longitude;
    protected List<EmployeeImpl> employees;
    protected List<BusImpl> buses;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getLatitude() {
        return latitude;
    }

    @Override
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public BigDecimal getLongitude() {
        return longitude;
    }

    @Override
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public List<Employee> getEmployees() {
        return (List) employees;
    }

    public void setEmployees(List<EmployeeImpl> employees) {
        this.employees = employees;
    }

    @Override
    public List<Bus> getBuses() {
        return (List) buses;
    }

    public void setBuses(List<BusImpl> buses) {
        this.buses = buses;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        StationImpl stationComparee = (StationImpl) comparee;
        return nullableEquals(this.name, stationComparee.name)
                && nullableEquals(this.latitude, stationComparee.latitude)
                && nullableEquals(this.longitude, stationComparee.longitude)
                && nullableListDeepEquals((List) this.employees, (List) stationComparee.employees)
                && nullableListDeepEquals((List) this.buses, (List) stationComparee.buses);
    }

    @Override
    public String toString() {
        return super.toString() + " name = " + name
                + " latitude = " + latitude + " longitude = " + longitude
                + " employees = " + employees + " buses = " + buses;
    }
}
