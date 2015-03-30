package com.anli.busstation.dal.ejb2.providers.remotes.staff;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.staff.Employee;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;
import org.joda.time.DateTime;

public interface GenericEmployeeProviderRemote<I extends Employee> extends BSEntityProviderRemote<I> {

    List<I> findByName(String name) throws RemoteException;

    List<I> findByNameRegexp(String nameRegexp) throws RemoteException;

    List<I> findBySalaryRange(BigDecimal salaryLeft, boolean strictLeft,
            BigDecimal salaryRight, boolean strictRight) throws RemoteException;

    List<I> findByHiringDateRange(DateTime hiringDateLeft, boolean strictLeft,
            DateTime hiringDateRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByName(String name) throws RemoteException;

    List<BigInteger> collectIdsByNameRegexp(String nameRegexp) throws RemoteException;

    List<BigInteger> collectIdsBySalaryRange(BigDecimal salaryLeft, boolean strictLeft,
            BigDecimal salaryRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByHiringDateRange(DateTime hiringDateLeft, boolean strictLeft,
            DateTime hiringDateRight, boolean strictRight) throws RemoteException;
}
