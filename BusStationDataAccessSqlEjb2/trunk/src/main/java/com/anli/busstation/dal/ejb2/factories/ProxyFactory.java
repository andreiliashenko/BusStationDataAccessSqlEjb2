package com.anli.busstation.dal.ejb2.factories;

import com.anli.busstation.dal.ejb2.factories.Ejb2ProviderFactory;
import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.ejb2.proxy.RemoteExceptionHandler;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.interfaces.providers.BSEntityProvider;
import java.lang.reflect.Proxy;

public class ProxyFactory implements ProviderFactory {

    @Override
    public <I extends BSEntityProvider> I getProvider(Class<I> abstraction) {
        return getProxy(abstraction, getRemote(abstraction));
    }

    protected Ejb2ProviderFactory getRemoteFactory() {
        return new Ejb2ProviderFactory();
    }

    protected <I> BSEntityProviderRemote getRemote(Class<I> abstraction) {
        return getRemoteFactory().getProvider(abstraction);
    }

    protected <I extends BSEntityProvider> I getProxy(Class<I> abstraction, BSEntityProviderRemote remote) {
        return (I) Proxy.newProxyInstance(abstraction.getClassLoader(), new Class[]{abstraction},
                new RemoteExceptionHandler(remote));
    }
}
