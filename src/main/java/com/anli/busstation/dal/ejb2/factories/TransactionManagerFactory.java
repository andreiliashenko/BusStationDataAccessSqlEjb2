package com.anli.busstation.dal.ejb2.factories;

import javax.transaction.TransactionManager;

public class TransactionManagerFactory extends AbstractLookupFactory {

    public TransactionManager getManager() {
        return lookup("java:appserver/TransactionManager", TransactionManager.class);
    }
}
