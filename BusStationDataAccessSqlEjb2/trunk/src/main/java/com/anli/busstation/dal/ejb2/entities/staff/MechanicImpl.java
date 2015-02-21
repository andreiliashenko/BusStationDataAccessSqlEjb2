package com.anli.busstation.dal.ejb2.entities.staff;

import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.staff.Mechanic;
import com.anli.busstation.dal.interfaces.entities.staff.MechanicSkill;

public class MechanicImpl extends EmployeeImpl implements Mechanic {

    protected MechanicSkillImpl skill;

    @Override
    public MechanicSkill getSkill() {
        return skill;
    }

    @Override
    public void setSkill(MechanicSkill skill) {
        this.skill = (MechanicSkillImpl) skill;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!super.deepEquals(comparee)) {
            return false;
        }
        MechanicImpl mechComparee = (MechanicImpl) comparee;
        return nullableDeepEquals(this.skill, mechComparee.skill);
    }

    @Override
    public String toString() {
        return super.toString() + " skill = {" + skill + "}";
    }
}
