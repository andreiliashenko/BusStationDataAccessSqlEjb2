package com.anli.busstation.dal.ejb2.providers.remotes.vehicles;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import com.anli.busstation.dal.interfaces.entities.vehicles.Model;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

public interface BusProviderRemote extends BSEntityProviderRemote<Bus> {

    List<Bus> findByModel(Model model) throws RemoteException;

    List<Bus> findByAnyModel(Collection<Model> models) throws RemoteException;

    List<Bus> findByState(TechnicalState state) throws RemoteException;

    List<Bus> findByAnyState(Collection<TechnicalState> states) throws RemoteException;

    List<Bus> findByPlate(String plate) throws RemoteException;

    List<BigInteger> collectIdsByModel(Model model) throws RemoteException;

    List<BigInteger> collectIdsByAnyModel(Collection<Model> models) throws RemoteException;

    List<BigInteger> collectIdsByState(TechnicalState state) throws RemoteException;

    List<BigInteger> collectIdsByAnyState(Collection<TechnicalState> states) throws RemoteException;

    List<BigInteger> collectIdsByPlate(String plate) throws RemoteException;
}
