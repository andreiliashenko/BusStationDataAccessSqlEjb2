package com.anli.busstation.dal.ejb2.entities.traffic;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.ejb2.entities.staff.DriverImpl;
import com.anli.busstation.dal.ejb2.entities.geography.RoadImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.staff.Driver;
import com.anli.busstation.dal.interfaces.entities.traffic.RideRoad;
import com.anli.busstation.dal.interfaces.entities.geography.Road;

public class RideRoadImpl extends BSEntityImpl implements RideRoad {

    protected RoadImpl road;
    protected DriverImpl driver;

    @Override
    public Road getRoad() {
        return road;
    }

    @Override
    public void setRoad(Road road) {
        this.road = (RoadImpl) road;
    }

    @Override
    public Driver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(Driver driver) {
        this.driver = (DriverImpl) driver;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        RideRoadImpl rrComparee = (RideRoadImpl) comparee;
        return nullableDeepEquals(this.driver, rrComparee.driver)
                && nullableDeepEquals(this.road, rrComparee.road);
    }

    @Override
    public String toString() {
        return super.toString() + " driver = {" + driver
                + "} road = {" + road + "}";
    }
}
