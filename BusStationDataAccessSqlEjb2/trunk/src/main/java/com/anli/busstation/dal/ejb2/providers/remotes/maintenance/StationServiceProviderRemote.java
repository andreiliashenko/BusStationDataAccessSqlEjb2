package com.anli.busstation.dal.ejb2.providers.remotes.maintenance;

import com.anli.busstation.dal.interfaces.entities.maintenance.StationService;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface StationServiceProviderRemote extends GenericTechnicalAssignmentProviderRemote<StationService> {

    List<StationService> findByDescriptionRegexp(String descriptionRegexp) throws RemoteException;

    List<BigInteger> collectIdsByDescriptionRegexp(String descriptionRegexp) throws RemoteException;
}
