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

    public List<DriverSkill> findByNameRegexp(String regexpName) {
        return getEntityHandler().selectEntitiesByRegexp("name", regexpName);
    }

    public List<DriverSkill> findByMaxRideLengthRange(Integer mrlLeft, boolean strictLeft,
            Integer mrlRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("maxRideLength", mrlLeft, strictLeft,
                mrlRight, strictRight);
    }

    public List<DriverSkill> findByMaxPassengersRange(Integer mpLeft, boolean strictLeft,
            Integer mpRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("maxPassengers", mpLeft, strictLeft,
                mpRight, strictRight);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String regexpName) {
        return getEntityHandler().collectKeysByRegexp("name", regexpName);
    }

    public List<BigInteger> collectIdsByMaxRideLengthRange(Integer mrlLeft, boolean strictLeft,
            Integer mrlRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("maxRideLength", mrlLeft, strictLeft,
                mrlRight, strictRight);
    }

    public List<BigInteger> collectIdsByMaxPassengersRange(Integer mpLeft, boolean strictLeft,
            Integer mpRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("maxPassengers", mpLeft, strictLeft,
                mpRight, strictRight);
    }
}
