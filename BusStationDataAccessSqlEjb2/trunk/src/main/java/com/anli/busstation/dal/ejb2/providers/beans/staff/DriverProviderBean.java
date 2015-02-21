package com.anli.busstation.dal.ejb2.providers.beans.staff;

import com.anli.busstation.dal.interfaces.entities.staff.Driver;
import com.anli.busstation.dal.interfaces.entities.staff.DriverSkill;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public class DriverProviderBean extends AbstractEmployeeProviderBean<Driver> {

    @Override
    protected String getEntityName() {
        return "Driver";
    }

    public List<Driver> findBySkill(DriverSkill skill) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("skill", skill);
    }

    public List<Driver> findByAnySkill(Collection<DriverSkill> skills) {
        return getEntityHandler().selectEntitiesByAny("skill", skills);
    }

    public List<BigInteger> collectIdsBySkill(DriverSkill skill) {
        return getEntityHandler().collectKeysByEqualsOrContains("skill", skill);
    }

    public List<BigInteger> collectIdsByAnySkill(Collection<DriverSkill> skills) {
        return getEntityHandler().collectKeysByAny("skill", skills);
    }
}
