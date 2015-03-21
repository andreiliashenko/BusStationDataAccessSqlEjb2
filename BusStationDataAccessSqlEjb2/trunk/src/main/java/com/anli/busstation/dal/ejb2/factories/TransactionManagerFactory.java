package com.anli.busstation.dal.ejb2.factories;

import com.anli.configuration.Configurator;
import javax.transaction.TransactionManager;

public class TransactionManagerFactory extends AbstractLookupFactory {

    public TransactionManager getManager() {
        return lookup(Configurator.getTransationManagerJndiName(), TransactionManager.class);
    }
}
