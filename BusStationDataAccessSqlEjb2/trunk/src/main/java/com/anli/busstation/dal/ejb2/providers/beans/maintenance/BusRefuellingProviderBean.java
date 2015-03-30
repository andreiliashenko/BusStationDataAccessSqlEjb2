package com.anli.busstation.dal.ejb2.providers.beans.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.BusRefuelling;
import java.math.BigInteger;
import java.util.List;

public class BusRefuellingProviderBean extends AbstractBusServiceProviderBean<BusRefuelling> {

    @Override
    protected String getEntityName() {
        return "BusRefuelling";
    }

    public List<BusRefuelling> findByVolumeRange(Integer volumeLeft, boolean strictLeft,
            Integer volumeRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("volume", volumeLeft, strictLeft,
                volumeRight, strictRight);
    }

    public List<BigInteger> collectIdsByVolumeRange(Integer volumeLeft, boolean strictLeft,
            Integer volumeRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("volume", volumeLeft, strictLeft,
                volumeRight, strictRight);
    }
}
