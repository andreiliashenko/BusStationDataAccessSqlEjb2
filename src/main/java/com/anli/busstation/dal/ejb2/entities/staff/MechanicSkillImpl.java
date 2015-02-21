package com.anli.busstation.dal.ejb2.entities.staff;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.staff.MechanicSkill;

public class MechanicSkillImpl extends BSEntityImpl implements MechanicSkill {

    protected String name;
    protected Integer maxDiffLevel;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getMaxDiffLevel() {
        return maxDiffLevel;
    }

    @Override
    public void setMaxDiffLevel(Integer maxDiffLevel) {
        this.maxDiffLevel = maxDiffLevel;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        MechanicSkillImpl msComparee = (MechanicSkillImpl) comparee;
        return nullableEquals(this.name, msComparee.name)
                && nullableEquals(this.maxDiffLevel, msComparee.maxDiffLevel);
    }

    @Override
    public String toString() {
        return super.toString() + " name = " + name
                + " maxDiffLevel = " + maxDiffLevel;
    }
}
