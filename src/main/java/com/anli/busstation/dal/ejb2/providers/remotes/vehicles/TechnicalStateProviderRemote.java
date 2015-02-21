package com.anli.busstation.dal.ejb2.providers.remotes.vehicles;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface TechnicalStateProviderRemote extends BSEntityProviderRemote<TechnicalState> {

    List<TechnicalState> findByDescriptionRegexp(String descrRegexp) throws RemoteException;

    List<TechnicalState> findByDifficultyLevel(Integer diffLevel) throws RemoteException;

    List<TechnicalState> findByDifficultyLevelRange(Integer dLLeft, boolean strictLeft,
            Integer dLRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByDescriptionRegexp(String descrRegexp) throws RemoteException;

    List<BigInteger> collectIdsByDifficultyLevel(Integer diffLevel) throws RemoteException;

    List<BigInteger> collectIdsByDifficultyLevelRange(Integer dLLeft, boolean strictLeft,
            Integer dLRight, boolean strictRight) throws RemoteException;
}
