package com.anli.busstation.dal.ejb2.providers.remotes.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.BusService;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface GenericBusServiceProviderRemote<I extends BusService> extends GenericTechnicalAssignmentProviderRemote<I> {

    List<I> findByBus(Bus bus) throws RemoteException;

    List<I> findByAnyBus(Collection<Bus> buses) throws RemoteException;

    List<BigInteger> collectIdsByBus(Bus bus) throws RemoteException;

    List<BigInteger> collectIdsByAnyBus(Collection<Bus> buses) throws RemoteException;
}
