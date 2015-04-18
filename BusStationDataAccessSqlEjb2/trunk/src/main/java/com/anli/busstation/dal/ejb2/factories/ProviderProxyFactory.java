package com.anli.busstation.dal.ejb2.factories;

import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.ejb2.proxy.EjbExceptionHandler;
import com.anli.busstation.dal.exceptions.ConsistencyException;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.interfaces.providers.BSEntityProvider;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Collections;

public class ProviderProxyFactory implements ProviderFactory {

    protected final ProviderRemoteFactory remoteFactory;
    protected final Collection<Class<? extends Throwable>> manageableExceptions;

    public ProviderProxyFactory() {
        this.remoteFactory = new ProviderRemoteFactory();
        this.manageableExceptions = Collections
                .<Class<? extends Throwable>>singletonList(ConsistencyException.class);
    }

    @Override
    public <I extends BSEntityProvider> I getProvider(Class<I> abstraction) {
        return getProxy(abstraction, getRemote(abstraction));
    }

    protected <I extends BSEntityProvider> BSEntityProviderRemote getRemote(Class<I> abstraction) {
        return remoteFactory.getProvider(abstraction);
    }

    protected <I extends BSEntityProvider> I getProxy(Class<I> abstraction, BSEntityProviderRemote remote) {
        return (I) Proxy.newProxyInstance(abstraction.getClassLoader(), new Class[]{abstraction},
                new EjbExceptionHandler(remote, manageableExceptions));
    }
}
