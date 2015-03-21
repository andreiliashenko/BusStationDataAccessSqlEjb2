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

    List<I> findByAnyMechanic(Collection<Mechanic> mechanics) throws RemoteException;

    List<I> findByBeginTimeRange(DateTime beginTimeLeft, boolean strictLeft,
            DateTime beginTimeRight, boolean strictRight) throws RemoteException;

    List<I> findByEndTimeRange(DateTime endTimeLeft, boolean strictLeft,
            DateTime endTimeRight, boolean strictRight) throws RemoteException;

    List<I> findByServiceCostRange(BigDecimal serviceCostLeft, boolean strictLeft,
            BigDecimal serviceCostRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByMechanic(Mechanic mechanic) throws RemoteException;

    List<BigInteger> collectIdsByAnyMechanic(Collection<Mechanic> mechanics) throws RemoteException;

    List<BigInteger> collectIdsByBeginTimeRange(DateTime beginTimeLeft, boolean strictLeft,
            DateTime beginTimeRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByEndTimeRange(DateTime endTimeLeft, boolean strictLeft,
            DateTime endTimeRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByServiceCostRange(BigDecimal serviceCostLeft, boolean strictLeft,
            BigDecimal serviceCostRight, boolean strictRight) throws RemoteException;
}
