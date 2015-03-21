package com.anli.busstation.dal.ejb2.providers.remotes.staff;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.staff.DriverSkill;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface DriverSkillProviderRemote extends BSEntityProviderRemote<DriverSkill> {

    List<DriverSkill> findByName(String name) throws RemoteException;

    List<DriverSkill> findByNameRegexp(String nameRegexp) throws RemoteException;

    List<DriverSkill> findByMaxRideLengthRange(Integer maxRideLengthLeft, boolean strictLeft,
            Integer maxRideLengthRight, boolean strictRight) throws RemoteException;

    List<DriverSkill> findByMaxPassengersRange(Integer maxPassengersLeft, boolean strictLeft,
            Integer maxPassengersRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByName(String name) throws RemoteException;

    List<BigInteger> collectIdsByNameRegexp(String nameRegexp) throws RemoteException;

    List<BigInteger> collectIdsByMaxRideLengthRange(Integer maxRideLengthLeft, boolean strictLeft,
            Integer maxRideLengthRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByMaxPassengersRange(Integer maxPassengersLeft, boolean strictLeft,
            Integer maxPassengersRight, boolean strictRight) throws RemoteException;
}
