package com.anli.busstation.dal.ejb2.providers.beans.staff;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.staff.MechanicSkill;
import java.math.BigInteger;
import java.util.List;

public class MechanicSkillProviderBean extends AbstractBSProviderBean<MechanicSkill> {

    @Override
    protected String getEntityName() {
        return "MechanicSkill";
    }

    public List<MechanicSkill> findByName(String name) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("name", name);
    }

    public List<MechanicSkill> findByNameRegexp(String nameRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("name", nameRegexp);
    }

    public List<MechanicSkill> findByMaxDiffLevelRange(Integer mdlLeft, boolean leftStrict,
            Integer mdlRight, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("maxDiffLevel", mdlLeft, leftStrict,
                mdlRight, rightStrict);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String nameRegexp) {
        return getEntityHandler().collectKeysByRegexp("name", nameRegexp);
    }

    public List<BigInteger> collectIdsByMaxDiffLevelRange(Integer mdlLeft, boolean leftStrict,
            Integer mdlRight, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("maxDiffLevel", mdlLeft, leftStrict,
                mdlRight, rightStrict);
    }
}
