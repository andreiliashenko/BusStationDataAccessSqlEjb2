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

    List<Model> findBySeatsNumberRange(Integer seatsNumberLeft, boolean strictLeft,
            Integer seatsNumberRight, boolean strictRight) throws RemoteException;

    List<Model> findByTankVolumeRange(Integer tankVolumeLeft, boolean strictLeft,
            Integer tankVolumeRight, boolean strictRight) throws RemoteException;

    List<Model> findByGasLabel(GasLabel gasLabel) throws RemoteException;

    List<Model> findByAnyGasLabel(Collection<GasLabel> gasLabels) throws RemoteException;

    List<Model> findByGasRateRange(BigDecimal gasRateLeft, boolean strictLeft,
            BigDecimal gasRateRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByName(String name) throws RemoteException;

    List<BigInteger> collectIdsByNameRegexp(String nameRegexp) throws RemoteException;

    List<BigInteger> collectIdsBySeatsNumberRange(Integer seatsNumberLeft, boolean strictLeft,
            Integer seatsNumberRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByGasLabel(GasLabel gasLabel) throws RemoteException;

    List<BigInteger> collectIdsByAnyGasLabel(Collection<GasLabel> gasLabels) throws RemoteException;

    List<BigInteger> collectIdsByGasRateRange(BigDecimal gasRateLeft, boolean strictLeft,
            BigDecimal gasRateRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByTankVolumeRange(Integer tankVolumeLeft, boolean strictLeft,
            Integer tankVolumeRight, boolean strictRight) throws RemoteException;
}
