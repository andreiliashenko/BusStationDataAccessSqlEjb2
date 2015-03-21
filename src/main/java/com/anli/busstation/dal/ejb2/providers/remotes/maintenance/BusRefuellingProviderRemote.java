package com.anli.busstation.dal.ejb2.providers.remotes.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.BusRefuelling;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface BusRefuellingProviderRemote extends GenericBusServiceProviderRemote<BusRefuelling> {

    List<BusRefuelling> findByVolumeRange(Integer volumeLeft, boolean leftStrict,
            Integer volumeRight, boolean rightStrict) throws RemoteException;

    List<BigInteger> collectIdsByVolumeRange(Integer volumeLeft, boolean leftStrict,
            Integer volumeRight, boolean rightStrict) throws RemoteException;
}
