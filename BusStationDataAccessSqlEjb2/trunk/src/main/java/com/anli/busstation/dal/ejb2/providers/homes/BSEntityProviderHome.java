package com.anli.busstation.dal.ejb2.providers.homes;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import java.rmi.RemoteException;
import javax.ejb.EJBHome;

public interface BSEntityProviderHome<P extends BSEntityProviderRemote> extends EJBHome {

    P create() throws RemoteException;
}
