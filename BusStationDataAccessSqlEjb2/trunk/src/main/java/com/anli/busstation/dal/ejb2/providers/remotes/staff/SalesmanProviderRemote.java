package com.anli.busstation.dal.ejb2.providers.remotes.staff;

import com.anli.busstation.dal.interfaces.entities.staff.Salesman;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface SalesmanProviderRemote extends GenericEmployeeProviderRemote<Salesman> {

    List<Salesman> findByTotalSalesRange(Integer totalSalesLeft, boolean strictLeft,
            Integer totalSalesRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByTotalSalesRange(Integer totalSalesLeft, boolean strictLeft,
            Integer totalSalesRight, boolean strictRight) throws RemoteException;
}
