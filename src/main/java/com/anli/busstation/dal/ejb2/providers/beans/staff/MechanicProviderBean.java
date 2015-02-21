package com.anli.busstation.dal.ejb2.providers.beans.staff;

import com.anli.busstation.dal.interfaces.entities.staff.Mechanic;
import com.anli.busstation.dal.interfaces.entities.staff.MechanicSkill;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public class MechanicProviderBean extends AbstractEmployeeProviderBean<Mechanic> {

    @Override
    protected String getEntityName() {
        return "Mechanic";
    }

    public List<Mechanic> findBySkill(MechanicSkill skill) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("skill", skill);
    }

    public List<Mechanic> findByAnySkill(Collection<MechanicSkill> skills) {
        return getEntityHandler().selectEntitiesByAny("skill", skills);
    }

    public List<BigInteger> collectIdsBySkill(MechanicSkill skill) {
        return getEntityHandler().collectKeysByEqualsOrContains("skill", skill);
    }

    public List<BigInteger> collectIdsByAnySkill(Collection<MechanicSkill> skills) {
        return getEntityHandler().collectKeysByAny("skill", skills);
    }
}
