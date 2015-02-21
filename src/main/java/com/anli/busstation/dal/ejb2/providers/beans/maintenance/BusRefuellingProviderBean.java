package com.anli.busstation.dal.ejb2.providers.beans.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.BusRefuelling;
import java.math.BigInteger;
import java.util.List;

public class BusRefuellingProviderBean extends AbstractBusServiceProviderBean<BusRefuelling> {

    @Override
    protected String getEntityName() {
        return "BusRefuelling";
    }

    public List<BusRefuelling> findByVolumeRange(Integer gasVolumeLeft, boolean leftStrict,
            Integer gasVolumeRight, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("volume", gasVolumeLeft, leftStrict,
                gasVolumeRight, rightStrict);
    }

    public List<BigInteger> collectIdsByVolumeRange(Integer gasVolumeLeft, boolean leftStrict,
            Integer gasVolumeRight, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("volume", gasVolumeLeft, leftStrict,
                gasVolumeRight, rightStrict);
    }
}
