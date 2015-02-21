package com.anli.busstation.dal.ejb2.providers.remotes.vehicles;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.vehicles.GasLabel;
import com.anli.busstation.dal.interfaces.entities.vehicles.Model;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface ModelProviderRemote extends BSEntityProviderRemote<Model> {

    List<Model> findByName(String name) throws RemoteException;

    List<Model> findByNameRegexp(String nameRegexp) throws RemoteException;

    List<Model> findBySeatsNumberRange(Integer seatsLeft, boolean strictLeft,
            Integer seatsRight, boolean strictRight) throws RemoteException;

    List<Model> findByTankVolumeRange(Integer tvLeft, boolean strictLeft,
            Integer tvRight, boolean strictRight) throws RemoteException;

    List<Model> findByGasLabel(GasLabel label) throws RemoteException;

    List<Model> findByAnyGasLabel(Collection<GasLabel> labelList) throws RemoteException;

    List<Model> findByGasRateRange(BigDecimal rateLeft, boolean strictLeft,
            BigDecimal rateRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByName(String name) throws RemoteException;

    List<BigInteger> collectIdsByNameRegexp(String nameRegexp) throws RemoteException;

    List<BigInteger> collectIdsBySeatsNumberRange(Integer seatsLeft, boolean strictLeft,
            Integer seatsRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByGasLabel(GasLabel label) throws RemoteException;

    List<BigInteger> collectIdsByAnyGasLabel(Collection<GasLabel> labelList) throws RemoteException;

    List<BigInteger> collectIdsByGasRateRange(BigDecimal rateLeft, boolean strictLeft,
            BigDecimal rateRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByTankVolumeRange(Integer tvLeft, boolean strictLeft,
            Integer tvRight, boolean strictRight) throws RemoteException;
}
