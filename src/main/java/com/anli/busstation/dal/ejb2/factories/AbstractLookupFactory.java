package com.anli.busstation.dal.ejb2.factories;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLookupFactory {
    
    private static final Logger LOG = LoggerFactory.getLogger(AbstractLookupFactory.class);
    
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
            LOG.error("Could not lookup resource", namingException);
            return null;
        }
    }
    
    protected <T> T lookup(Class<T> clazz) {
        return lookup(clazz.getCanonicalName(), clazz);
    }
}
