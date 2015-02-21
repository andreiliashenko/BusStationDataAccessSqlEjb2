package com.anli.busstation.dal.ejb2.factories;

import com.anli.configuration.Configurator;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceFactory extends AbstractLookupFactory {

    protected static final String DB_GROUP = "db";
    protected static final String CONNECTION_POOL_PROPERTY = "connection_pool";

    protected String dataSourceName;

    public DataSourceFactory() {
        dataSourceName = Configurator.getConfig(DB_GROUP).getProperty(CONNECTION_POOL_PROPERTY);
    }

    public DataSource getDataSource() {
        return lookup(dataSourceName, DataSource.class);
    }
}
