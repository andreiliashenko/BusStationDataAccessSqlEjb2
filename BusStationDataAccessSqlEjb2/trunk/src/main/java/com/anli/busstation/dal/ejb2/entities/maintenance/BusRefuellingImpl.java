package com.anli.busstation.dal.ejb2.entities.maintenance;

import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.maintenance.BusRefuelling;

public class BusRefuellingImpl extends BusServiceImpl implements BusRefuelling {

    protected Integer volume;

    @Override
    public Integer getVolume() {
        return volume;
    }

    @Override
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!super.deepEquals(comparee)) {
            return false;
        }
        BusRefuellingImpl brComparee = (BusRefuellingImpl) comparee;
        return nullableEquals(this.volume, brComparee.volume);
    }

    @Override
    public String toString() {
        return super.toString() + " volume = " + volume;
    }
}
