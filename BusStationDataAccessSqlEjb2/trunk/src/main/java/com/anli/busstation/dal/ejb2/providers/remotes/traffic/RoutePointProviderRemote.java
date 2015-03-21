package com.anli.busstation.dal.ejb2.providers.remotes.traffic;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface RoutePointProviderRemote extends BSEntityProviderRemote<RoutePoint> {

    List<RoutePoint> findByStation(Station station) throws RemoteException;

    List<RoutePoint> findByAnyStation(Collection<Station> stations) throws RemoteException;

    List<BigInteger> collectIdsByStation(Station station) throws RemoteException;

    List<BigInteger> collectIdsByAnyStation(Collection<Station> stations) throws RemoteException;
}
