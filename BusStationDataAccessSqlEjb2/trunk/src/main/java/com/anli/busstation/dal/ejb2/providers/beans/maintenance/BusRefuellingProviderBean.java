package com.anli.busstation.dal.ejb2.providers.beans.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.BusRefuelling;
import java.math.BigInteger;
import java.util.List;

public class BusRefuellingProviderBean extends AbstractBusServiceProviderBean<BusRefuelling> {

    @Override
    protected String getEntityName() {
        return "BusRefuelling";
    }

    public List<BusRefuelling> findByVolumeRange(Integer volumeLeft, boolean leftStrict,
            Integer volumeRight, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("volume", volumeLeft, leftStrict,
                volumeRight, rightStrict);
    }

    public List<BigInteger> collectIdsByVolumeRange(Integer volumeLeft, boolean leftStrict,
            Integer volumeRight, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("volume", volumeLeft, leftStrict,
                volumeRight, rightStrict);
    }
}
