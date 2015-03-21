package com.anli.busstation.dal.ejb2.providers.beans.staff;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.staff.DriverSkill;
import java.math.BigInteger;
import java.util.List;

public class DriverSkillProviderBean extends AbstractBSProviderBean<DriverSkill> {

    @Override
    protected String getEntityName() {
        return "DriverSkill";
    }

    public List<DriverSkill> findByName(String name) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("name", name);
    }

    public List<DriverSkill> findByNameRegexp(String nameRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("name", nameRegexp);
    }

    public List<DriverSkill> findByMaxRideLengthRange(Integer maxRideLengthLeft, boolean strictLeft,
            Integer maxRideLengthRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("maxRideLength", maxRideLengthLeft, strictLeft,
                maxRideLengthRight, strictRight);
    }

    public List<DriverSkill> findByMaxPassengersRange(Integer maxPassengersLeft, boolean strictLeft,
            Integer maxPassengersRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("maxPassengers", maxPassengersLeft, strictLeft,
                maxPassengersRight, strictRight);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String nameRegexp) {
        return getEntityHandler().collectKeysByRegexp("name", nameRegexp);
    }

    public List<BigInteger> collectIdsByMaxRideLengthRange(Integer maxRideLengthLeft, boolean strictLeft,
            Integer maxRideLengthRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("maxRideLength", maxRideLengthLeft, strictLeft,
                maxRideLengthRight, strictRight);
    }

    public List<BigInteger> collectIdsByMaxPassengersRange(Integer maxPassengersLeft, boolean strictLeft,
            Integer maxPassengersRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("maxPassengers", maxPassengersLeft, strictLeft,
                maxPassengersRight, strictRight);
    }
}
