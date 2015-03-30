package com.anli.busstation.dal.ejb2.providers.remotes.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.BusRepairment;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface BusRepairmentProviderRemote extends GenericBusServiceProviderRemote<BusRepairment> {

    List<BusRepairment> findByExpendablesPriceRange(BigDecimal expendablesPriceLeft, boolean strictLeft,
            BigDecimal expendablesPriceRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByExpendablesPriceRange(BigDecimal expendablesPriceLeft, boolean strictLeft,
            BigDecimal expendablesPriceRight, boolean strictRight) throws RemoteException;
}
