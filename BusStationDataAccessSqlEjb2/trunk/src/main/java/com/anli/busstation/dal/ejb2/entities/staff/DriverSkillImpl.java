package com.anli.busstation.dal.ejb2.entities.staff;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.staff.DriverSkill;

public class DriverSkillImpl extends BSEntityImpl implements DriverSkill {

    protected String name;
    protected Integer maxRideLength;
    protected Integer maxPassengers;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getMaxRideLength() {
        return maxRideLength;
    }

    @Override
    public void setMaxRideLength(Integer maxRideLength) {
        this.maxRideLength = maxRideLength;
    }

    @Override
    public Integer getMaxPassengers() {
        return maxPassengers;
    }

    @Override
    public void setMaxPassengers(Integer maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        DriverSkillImpl dsComparee = (DriverSkillImpl) comparee;
        return nullableEquals(this.name, dsComparee.name)
                && nullableEquals(this.maxPassengers, dsComparee.maxPassengers)
                && nullableEquals(this.maxRideLength, dsComparee.maxRideLength);
    }

    @Override
    public String toString() {
        return super.toString() + " name = " + name + " maxPassengers = "
                + maxPassengers + " maxRideLength = " + maxRideLength;
    }
}
