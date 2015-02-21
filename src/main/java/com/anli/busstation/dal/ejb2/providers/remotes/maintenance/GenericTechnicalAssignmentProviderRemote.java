package com.anli.busstation.dal.ejb2.providers.remotes.maintenance;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.maintenance.TechnicalAssignment;
import com.anli.busstation.dal.interfaces.entities.staff.Mechanic;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import org.joda.time.DateTime;

public interface GenericTechnicalAssignmentProviderRemote<I extends TechnicalAssignment> extends BSEntityProviderRemote<I> {

    List<I> findByMechanic(Mechanic mechanic) throws RemoteException;

    List<I> findByAnyMechanic(Collection<Mechanic> mechList) throws RemoteException;

    List<I> findByBeginTimeRange(DateTime leftBT, boolean strictLeft,
            DateTime rightBT, boolean strictRight) throws RemoteException;

    List<I> findByEndTimeRange(DateTime leftET, boolean strictLeft,
            DateTime rightET, boolean strictRight) throws RemoteException;

    List<I> findByServiceCostRange(BigDecimal leftCost, boolean strictLeft,
            BigDecimal rightCost, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByMechanic(Mechanic mechanic) throws RemoteException;

    List<BigInteger> collectIdsByAnyMechanic(Collection<Mechanic> mechList) throws RemoteException;

    List<BigInteger> collectIdsByBeginTimeRange(DateTime leftBT, boolean strictLeft,
            DateTime rightBT, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByEndTimeRange(DateTime leftET, boolean strictLeft,
            DateTime rightET, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByServiceCostRange(BigDecimal leftCost, boolean strictLeft,
            BigDecimal rightCost, boolean strictRight) throws RemoteException;
}
