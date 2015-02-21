package com.anli.busstation.dal.sql.configuration;

import com.anli.busstation.dal.ejb2.factories.DataSourceFactory;
import com.anli.busstation.dal.ejb2.factories.TransactionManagerFactory;
import com.anli.busstation.dal.sql.idgeneration.IdGenerator;
import com.anli.busstation.dal.sql.idgeneration.TableIdGenerator;
import com.anli.busstation.dal.sql.transformation.BigIntegerTransformer;
import com.anli.busstation.dal.sql.transformation.BooleanTransformer;
import com.anli.busstation.dal.sql.transformation.DateTimeTransformer;
import com.anli.sqlexecution.execution.SqlExecutor;
import com.anli.sqlexecution.transformation.MapBasedTransformerFactory;
import com.anli.sqlexecution.transformation.SqlTransformer;
import com.anli.sqlexecution.transformation.TransformerFactory;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import org.joda.time.DateTime;

public class ConfigurationHolder {

    private static final EntityDefinitionConfiguration definitionConfig
            = new EntityDefinitionConfiguration();
    private static final EntityGatewayConfiguration gatewayConfig
            = new EntityGatewayConfiguration();
    private static final SqlExecutor executor = new SqlExecutor(getDataSource(), getTransformerFactory());
    private static final EntityHandlerConfiguration handlerConfig
            = new EntityHandlerConfiguration(definitionConfig, gatewayConfig, executor);
    private static final IdGenerator idGenerator = new TableIdGenerator(executor, getTransactionManager());

    private static TransformerFactory getTransformerFactory() {
        Map<Class, SqlTransformer> transformers = new HashMap<>();
        transformers.put(BigInteger.class, new BigIntegerTransformer());
        transformers.put(Boolean.class, new BooleanTransformer());
        transformers.put(DateTime.class, new DateTimeTransformer());
        return new MapBasedTransformerFactory(transformers);
    }

    private static DataSource getDataSource() {
        return new DataSourceFactory().getDataSource();
    }

    private static TransactionManager getTransactionManager() {
        return new TransactionManagerFactory().getManager();
    }

    public static EntityHandlerConfiguration getHandlerConfiguration() {
        return handlerConfig;
    }

    public static IdGenerator getIdGenerator() {
        return idGenerator;
    }
}
