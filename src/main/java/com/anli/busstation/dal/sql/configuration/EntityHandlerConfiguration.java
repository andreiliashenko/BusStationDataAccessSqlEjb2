package com.anli.busstation.dal.sql.configuration;

import com.anli.busstation.dal.sql.transformation.BigIntegerTransformer;
import com.anli.busstation.dal.sql.transformation.DateTimeTransformer;
import com.anli.busstation.dal.sql.transformation.BooleanTransformer;
import com.anli.busstation.dal.ejb2.factories.DataSourceFactory;
import com.anli.simpleorm.handling.EntityHandler;
import com.anli.simpleorm.handling.EntityHandlerFactory;
import com.anli.simpleorm.queries.MySqlQueryBuilder;
import com.anli.sqlexecution.execution.SqlExecutor;
import com.anli.sqlexecution.transformation.MapBasedTransformerFactory;
import com.anli.sqlexecution.transformation.SqlTransformer;
import com.anli.sqlexecution.transformation.TransformerFactory;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.joda.time.DateTime;

public class EntityHandlerConfiguration implements EntityHandlerFactory {

    private static final EntityHandlerConfiguration instance = new EntityHandlerConfiguration();

    public static EntityHandlerConfiguration getInstance() {
        return instance;
    }

    protected final TransformerFactory transformerFactory;
    protected final EntityDefinitionConfiguration definitionConfig;
    protected final EntityGatewayConfiguration gatewayConfig;
    protected final MySqlQueryBuilder queryBuilder;
    protected final SqlExecutor executor;

    protected final Map<String, EntityHandler> handlers;

    private EntityHandlerConfiguration() {
        transformerFactory = getTransformerFactory();
        definitionConfig = new EntityDefinitionConfiguration();
        gatewayConfig = new EntityGatewayConfiguration();
        queryBuilder = new MySqlQueryBuilder();
        executor = new SqlExecutor(new DataSourceFactory().getDataSource(), transformerFactory);
        handlers = new HashMap<>();
    }

    private TransformerFactory getTransformerFactory() {
        Map<Class, SqlTransformer> transformers = new HashMap<>();
        transformers.put(BigInteger.class, new BigIntegerTransformer());
        transformers.put(Boolean.class, new BooleanTransformer());
        transformers.put(DateTime.class, new DateTimeTransformer());
        return new MapBasedTransformerFactory(transformers);
    }

    @Override
    public <Entity> EntityHandler<Entity> getHandler(String entityName) {
        EntityHandler<Entity> handler = handlers.get(entityName);
        if (handler != null) {
            return handler;
        }
        synchronized (this) {
            handler = handlers.get(entityName);
            if (handler == null) {
                handler = new EntityHandler<>(definitionConfig.getDefinition(entityName),
                        queryBuilder, gatewayConfig.<Entity>getGateway(entityName), this, executor);
                handlers.put(entityName, handler);
            }
        }
        return handler;
    }
}
