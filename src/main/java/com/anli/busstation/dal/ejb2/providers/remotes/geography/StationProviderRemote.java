package com.anli.busstation.dal.ejb2.providers.remotes.geography;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.staff.Employee;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface StationProviderRemote extends BSEntityProviderRemote<Station> {

    Station pullEmployees(Station station) throws RemoteException;

    Station pullBuses(Station station) throws RemoteException;

    List<Station> findByName(String name) throws RemoteException;

    List<Station> findByNameRegexp(String regexpName) throws RemoteException;

    List<Station> findByLatitudeRange(BigDecimal leftLat, boolean strictLeft,
            BigDecimal rightLat, boolean strictRight) throws RemoteException;

    List<Station> findByLongitudeRange(BigDecimal leftLon, boolean strictLeft,
            BigDecimal rightLon, boolean strictRight) throws RemoteException;

    List<Station> findByEmployee(Employee employee) throws RemoteException;

    List<Station> findByAnyEmployee(Collection<Employee> employeeList) throws RemoteException;

    List<Station> findByBus(Bus bus) throws RemoteException;

    List<Station> findByAnyBus(Collection<Bus> busList) throws RemoteException;

    List<BigInteger> collectIdsByName(String name) throws RemoteException;

    List<BigInteger> collectIdsByNameRegexp(String regexpName) throws RemoteException;

    List<BigInteger> collectIdsByLatitudeRange(BigDecimal leftLat, boolean strictLeft,
            BigDecimal rightLat, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByLongitudeRange(BigDecimal leftLon, boolean strictLeft,
            BigDecimal rightLon, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByEmployee(Employee employee) throws RemoteException;

    List<BigInteger> collectIdsByAnyEmployee(Collection<Employee> employeeList) throws RemoteException;

    List<BigInteger> collectIdsByBus(Bus bus) throws RemoteException;

    List<BigInteger> collectIdsByAnyBus(Collection<Bus> busList) throws RemoteException;
}
