package com.anli.busstation.dal.ejb2.providers.remotes.vehicles;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.entities.vehicles.GasLabel;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

public interface GasLabelProviderRemote extends BSEntityProviderRemote<GasLabel> {

    List<GasLabel> findByName(String name) throws RemoteException;

    List<GasLabel> findByNameRegexp(String regexpName) throws RemoteException;

    List<GasLabel> findByPriceRange(BigDecimal priceLeft, boolean leftStrict,
            BigDecimal priceRight, boolean rightStrict) throws RemoteException;

    List<BigInteger> collectIdsByName(String name) throws RemoteException;

    List<BigInteger> collectIdsByNameRegexp(String regexpName) throws RemoteException;

    List<BigInteger> collectIdsByPriceRange(BigDecimal priceLeft, boolean leftStrict,
            BigDecimal priceRight, boolean rightStrict) throws RemoteException;
}
