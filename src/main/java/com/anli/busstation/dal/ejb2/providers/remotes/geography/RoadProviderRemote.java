package com.anli.busstation.dal.ejb2.providers.remotes.geography;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.geography.Road;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface RoadProviderRemote extends BSEntityProviderRemote<Road> {

    List<Road> findByAStation(Station aStation) throws RemoteException;

    List<Road> findByAnyAStation(Collection<Station> aStationList) throws RemoteException;

    List<Road> findByZStation(Station zStation) throws RemoteException;

    List<Road> findByAnyZStation(Collection<Station> zStationList) throws RemoteException;

    List<Road> findByStation(Station station) throws RemoteException;

    List<Road> findByAnyStation(Collection<Station> stationList) throws RemoteException;

    List<Road> findByLengthRange(Integer lengthLeft, boolean strictLeft,
            Integer lengthRight, boolean strictRight) throws RemoteException;

    List<Road> findByRidePriceRange(BigDecimal rPriceLeft, boolean strictLeft,
            BigDecimal rPriceRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByAStation(Station aStation) throws RemoteException;

    List<BigInteger> collectIdsByAnyAStation(Collection<Station> aStationList) throws RemoteException;

    List<BigInteger> collectIdsByZStation(Station zStation) throws RemoteException;

    List<BigInteger> collectIdsByAnyZStation(Collection<Station> zStationList) throws RemoteException;

    List<BigInteger> collectIdsByStation(Station station) throws RemoteException;

    List<BigInteger> collectIdsByAnyStation(Collection<Station> stationList) throws RemoteException;

    List<BigInteger> collectIdsByLengthRange(Integer lengthLeft, boolean strictLeft,
            Integer lengthRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByRidePriceRange(BigDecimal rPriceLeft, boolean strictLeft,
            BigDecimal rPriceRight, boolean strictRight) throws RemoteException;
}
