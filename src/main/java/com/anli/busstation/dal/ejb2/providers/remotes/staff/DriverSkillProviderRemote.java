package com.anli.busstation.dal.ejb2.providers.remotes.staff;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.staff.DriverSkill;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface DriverSkillProviderRemote extends BSEntityProviderRemote<DriverSkill> {

    List<DriverSkill> findByName(String name) throws RemoteException;

    List<DriverSkill> findByNameRegexp(String regexpName) throws RemoteException;

    List<DriverSkill> findByMaxRideLengthRange(Integer mRLLeft, boolean strictLeft,
            Integer mRLRight, boolean strictRight) throws RemoteException;

    List<DriverSkill> findByMaxPassengersRange(Integer maxPLeft, boolean strictLeft,
            Integer maxPRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByName(String name) throws RemoteException;

    List<BigInteger> collectIdsByNameRegexp(String regexpName) throws RemoteException;

    List<BigInteger> collectIdsByMaxRideLengthRange(Integer mRLLeft, boolean strictLeft,
            Integer mRLRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByMaxPassengersRange(Integer maxPLeft, boolean strictLeft,
            Integer maxPRight, boolean strictRight) throws RemoteException;
}
