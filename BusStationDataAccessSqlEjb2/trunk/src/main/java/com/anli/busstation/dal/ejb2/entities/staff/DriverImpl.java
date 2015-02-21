package com.anli.busstation.dal.ejb2.entities.staff;

import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.staff.Driver;
import com.anli.busstation.dal.interfaces.entities.staff.DriverSkill;

public class DriverImpl extends EmployeeImpl implements Driver {

    protected DriverSkillImpl skill;

    @Override
    public DriverSkill getSkill() {
        return skill;
    }

    @Override
    public void setSkill(DriverSkill skill) {
        this.skill = (DriverSkillImpl) skill;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!super.deepEquals(comparee)) {
            return false;
        }
        DriverImpl drComparee = (DriverImpl) comparee;
        return nullableDeepEquals(this.skill, drComparee.skill);
    }

    @Override
    public String toString() {
        return super.toString() + " skill = {" + skill + "}";
    }
}
