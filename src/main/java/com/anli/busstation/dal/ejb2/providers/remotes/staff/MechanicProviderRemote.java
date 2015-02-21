package com.anli.busstation.dal.ejb2.providers.remotes.staff;

import com.anli.busstation.dal.interfaces.entities.staff.Mechanic;
import com.anli.busstation.dal.interfaces.entities.staff.MechanicSkill;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface MechanicProviderRemote extends GenericEmployeeProviderRemote<Mechanic> {

    List<Mechanic> findBySkill(MechanicSkill skill) throws RemoteException;

    List<Mechanic> findByAnySkill(Collection<MechanicSkill> skills) throws RemoteException;

    List<BigInteger> collectIdsBySkill(MechanicSkill skill) throws RemoteException;

    List<BigInteger> collectIdsByAnySkill(Collection<MechanicSkill> skills) throws RemoteException;
}
