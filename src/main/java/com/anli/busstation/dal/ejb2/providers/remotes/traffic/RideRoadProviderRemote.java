package com.anli.busstation.dal.ejb2.providers.remotes.traffic;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.geography.Road;
import com.anli.busstation.dal.interfaces.entities.staff.Driver;
import com.anli.busstation.dal.interfaces.entities.traffic.RideRoad;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface RideRoadProviderRemote extends BSEntityProviderRemote<RideRoad> {

    List<RideRoad> findByRoad(Road road) throws RemoteException;

    List<RideRoad> findByAnyRoad(Collection<Road> roads) throws RemoteException;

    List<RideRoad> findByDriver(Driver driver) throws RemoteException;

    List<RideRoad> findByAnyDriver(Collection<Driver> drivers) throws RemoteException;

    List<BigInteger> collectIdsByRoad(Road road) throws RemoteException;

    List<BigInteger> collectIdsByAnyRoad(Collection<Road> roads) throws RemoteException;

    List<BigInteger> collectIdsByDriver(Driver driver) throws RemoteException;

    List<BigInteger> collectIdsByAnyDriver(Collection<Driver> drivers) throws RemoteException;
}
