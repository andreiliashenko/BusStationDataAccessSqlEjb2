package com.anli.busstation.dal.ejb2.providers.remotes.vehicles;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface TechnicalStateProviderRemote extends BSEntityProviderRemote<TechnicalState> {

    List<TechnicalState> findByDescriptionRegexp(String descriptionRegexp) throws RemoteException;

    List<TechnicalState> findByDifficultyLevel(Integer difficultyLevel) throws RemoteException;

    List<TechnicalState> findByDifficultyLevelRange(Integer difficultyLevelLeft, boolean strictLeft,
            Integer diffictultyLevelRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByDescriptionRegexp(String descriptionRegexp) throws RemoteException;

    List<BigInteger> collectIdsByDifficultyLevel(Integer difficultyLevel) throws RemoteException;

    List<BigInteger> collectIdsByDifficultyLevelRange(Integer difficultyLevelLeft, boolean strictLeft,
            Integer difficultyLevelRight, boolean strictRight) throws RemoteException;
}
