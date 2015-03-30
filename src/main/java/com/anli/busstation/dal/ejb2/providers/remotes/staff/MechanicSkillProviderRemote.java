package com.anli.busstation.dal.ejb2.providers.remotes.staff;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.staff.MechanicSkill;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface MechanicSkillProviderRemote extends BSEntityProviderRemote<MechanicSkill> {

    List<MechanicSkill> findByName(String name) throws RemoteException;

    List<MechanicSkill> findByNameRegexp(String nameRegexp) throws RemoteException;

    List<MechanicSkill> findByMaxDiffLevelRange(Integer maxDiffLevelLeft, boolean strictLeft,
            Integer maxDiffLevelRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByName(String name) throws RemoteException;

    List<BigInteger> collectIdsByNameRegexp(String nameRegexp) throws RemoteException;

    List<BigInteger> collectIdsByMaxDiffLevelRange(Integer maxDiffLevelLeft, boolean strictLeft,
            Integer maxDiffLevelRight, boolean strictRight) throws RemoteException;
}
