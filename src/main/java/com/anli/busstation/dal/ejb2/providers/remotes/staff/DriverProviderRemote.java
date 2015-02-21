package com.anli.busstation.dal.ejb2.providers.remotes.staff;

import com.anli.busstation.dal.interfaces.entities.staff.Driver;
import com.anli.busstation.dal.interfaces.entities.staff.DriverSkill;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface DriverProviderRemote extends GenericEmployeeProviderRemote<Driver> {

    List<Driver> findBySkill(DriverSkill skill) throws RemoteException;

    List<Driver> findByAnySkill(Collection<DriverSkill> skills) throws RemoteException;

    List<BigInteger> collectIdsBySkill(DriverSkill skill) throws RemoteException;

    List<BigInteger> collectIdsByAnySkill(Collection<DriverSkill> skills) throws RemoteException;
}
