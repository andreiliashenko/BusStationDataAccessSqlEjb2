package com.anli.busstation.dal.ejb2.providers.remotes.geography;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.geography.Region;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface RegionProviderRemote extends BSEntityProviderRemote<Region> {

    Region pullStations(Region region) throws RemoteException;

    List<Region> findByName(String name) throws RemoteException;

    List<Region> findByNameRegexp(String nameRegexp) throws RemoteException;

    List<Region> findByCode(Integer code) throws RemoteException;

    List<Region> findByAnyCode(Collection<Integer> codes) throws RemoteException;

    List<Region> findByStation(Station station) throws RemoteException;

    List<Region> findByAnyStation(Collection<Station> stations) throws RemoteException;

    List<BigInteger> collectIdsByName(String name) throws RemoteException;

    List<BigInteger> collectIdsByNameRegexp(String nameRegexp) throws RemoteException;

    List<BigInteger> collectIdsByCode(Integer code) throws RemoteException;

    List<BigInteger> collectIdsByAnyCode(Collection<Integer> codes) throws RemoteException;

    List<BigInteger> collectIdsByStation(Station station) throws RemoteException;

    List<BigInteger> collectIdsByAnyStation(Collection<Station> stations) throws RemoteException;
}
