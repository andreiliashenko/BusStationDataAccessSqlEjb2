package com.anli.busstation.dal.ejb2.providers.remotes;

import com.anli.busstation.dal.interfaces.entities.BSEntity;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.EJBObject;

public interface BSEntityProviderRemote<I extends BSEntity> extends EJBObject {

    I create() throws RemoteException;

    I save(I entity) throws RemoteException;

    void remove(I entity) throws RemoteException;

    I findById(BigInteger id) throws RemoteException;

    List<I> findAll() throws RemoteException;

    List<BigInteger> collectIdsAll() throws RemoteException;
}
