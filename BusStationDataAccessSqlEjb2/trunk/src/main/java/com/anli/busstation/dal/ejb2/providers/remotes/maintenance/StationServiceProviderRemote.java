package com.anli.busstation.dal.ejb2.providers.remotes.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.StationService;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface StationServiceProviderRemote extends GenericTechnicalAssignmentProviderRemote<StationService> {

    List<StationService> findByDescriptionRegexp(String descrRegexp) throws RemoteException;

    List<BigInteger> collectIdsByDescriptionRegexp(String descrRegexp) throws RemoteException;
}
