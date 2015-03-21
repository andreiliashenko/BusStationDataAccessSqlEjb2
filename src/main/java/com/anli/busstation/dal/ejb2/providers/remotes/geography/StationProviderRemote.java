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

    List<Station> findByNameRegexp(String nameRegexp) throws RemoteException;

    List<Station> findByLatitudeRange(BigDecimal latitudeLeft, boolean strictLeft,
            BigDecimal latitudeRight, boolean strictRight) throws RemoteException;

    List<Station> findByLongitudeRange(BigDecimal longitudeLeft, boolean strictLeft,
            BigDecimal longitudeRight, boolean strictRight) throws RemoteException;

    List<Station> findByEmployee(Employee employee) throws RemoteException;

    List<Station> findByAnyEmployee(Collection<Employee> employees) throws RemoteException;

    List<Station> findByBus(Bus bus) throws RemoteException;

    List<Station> findByAnyBus(Collection<Bus> buses) throws RemoteException;

    List<BigInteger> collectIdsByName(String name) throws RemoteException;

    List<BigInteger> collectIdsByNameRegexp(String nameRegexp) throws RemoteException;

    List<BigInteger> collectIdsByLatitudeRange(BigDecimal latitudeLeft, boolean strictLeft,
            BigDecimal latitudeRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByLongitudeRange(BigDecimal longitudeLeft, boolean strictLeft,
            BigDecimal longitudeRight, boolean strictRight) throws RemoteException;

    List<BigInteger> collectIdsByEmployee(Employee employee) throws RemoteException;

    List<BigInteger> collectIdsByAnyEmployee(Collection<Employee> employees) throws RemoteException;

    List<BigInteger> collectIdsByBus(Bus bus) throws RemoteException;

    List<BigInteger> collectIdsByAnyBus(Collection<Bus> buses) throws RemoteException;
}
