package com.anli.busstation.dal.sql.configuration;

import com.anli.simpleorm.definitions.EntityDefinition;
import com.anli.simpleorm.handling.EntityGateway;
import com.anli.simpleorm.handling.EntityHandler;
import com.anli.simpleorm.handling.EntityHandlerFactory;
import com.anli.simpleorm.queries.MySqlQueryBuilder;
import com.anli.sqlexecution.execution.SqlExecutor;
import java.util.HashMap;
import java.util.Map;

public class EntityHandlerConfiguration implements EntityHandlerFactory {

    protected final EntityDefinitionConfiguration definitionConfig;
    protected final EntityGatewayConfiguration gatewayConfig;
    protected final MySqlQueryBuilder queryBuilder;
    protected final SqlExecutor executor;

    protected final Map<String, EntityHandler> handlers;

    public EntityHandlerConfiguration(EntityDefinitionConfiguration definitionConfig,
            EntityGatewayConfiguration gatewayConfig, SqlExecutor executor) {
        this.definitionConfig = definitionConfig;
        this.gatewayConfig = gatewayConfig;
        this.queryBuilder = getQueryBuilder();
        this.executor = executor;
        handlers = new HashMap<>();
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
                handler = getNewEntityHandler(definitionConfig.getDefinition(entityName),
                        queryBuilder, gatewayConfig.<Entity>getGateway(entityName), this, executor);
                handlers.put(entityName, handler);
            }
        }
        return handler;
    }

    private <Entity> EntityHandler<Entity> getNewEntityHandler(EntityDefinition definition,
            MySqlQueryBuilder builder, EntityGateway<Entity> gateway,
            EntityHandlerFactory factory, SqlExecutor executor) {
        return new EntityHandler<>(definition, builder, gateway, factory, executor);
    }

    private MySqlQueryBuilder getQueryBuilder() {
        return new MySqlQueryBuilder();
    }
}
