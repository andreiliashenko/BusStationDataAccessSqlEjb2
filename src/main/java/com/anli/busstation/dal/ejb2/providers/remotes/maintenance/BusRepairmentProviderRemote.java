package com.anli.busstation.dal.ejb2.providers.remotes.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.BusRepairment;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface BusRepairmentProviderRemote extends GenericBusServiceProviderRemote<BusRepairment> {

    List<BusRepairment> findByExpendablesPriceRange(BigDecimal exPriceLeft, boolean leftStrict,
            BigDecimal exPriceRight, boolean rightStrict) throws RemoteException;

    List<BigInteger> collectIdsByExpendablesPriceRange(BigDecimal exPriceLeft, boolean leftStrict,
            BigDecimal exPriceRight, boolean rightStrict) throws RemoteException;
}
