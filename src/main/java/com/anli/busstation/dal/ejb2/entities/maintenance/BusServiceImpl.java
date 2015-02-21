package com.anli.busstation.dal.ejb2.entities.maintenance;

import com.anli.busstation.dal.ejb2.entities.vehicles.BusImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import com.anli.busstation.dal.interfaces.entities.maintenance.BusService;

public abstract class BusServiceImpl extends TechnicalAssignmentImpl implements BusService {

    protected BusImpl bus;

    @Override
    public Bus getBus() {
        return bus;
    }

    @Override
    public void setBus(Bus bus) {
        this.bus = (BusImpl) bus;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!super.deepEquals(comparee)) {
            return false;
        }
        BusServiceImpl bsComparee = (BusServiceImpl) comparee;
        return nullableDeepEquals(this.bus, bsComparee.bus);
    }

    @Override
    public String toString() {
        return super.toString() + " bus = {" + bus + "}";
    }
}
