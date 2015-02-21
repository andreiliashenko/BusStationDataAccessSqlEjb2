package com.anli.busstation.dal.ejb2.factories;

import com.anli.busstation.dal.ejb2.exceptions.LookupError;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public abstract class AbstractLookupFactory {

    protected Context getContext() throws NamingException {
        return new InitialContext();
    }

    protected <T> T lookupRemote(Class<T> clazz) {

        Object lookedUp = lookup(clazz.getCanonicalName(), Object.class);
        return (T) PortableRemoteObject.narrow(lookedUp, clazz);
    }

    protected <T> T lookup(String name, Class<T> clazz) {
        try {
            Context ic = getContext();
            return (T) ic.lookup(name);
        } catch (NamingException namingException) {
            throw new LookupError(namingException);
        }
    }
}
