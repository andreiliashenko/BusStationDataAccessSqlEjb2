package com.anli.busstation.dal.sql.configuration.definitions;

import com.anli.simpleorm.definitions.CollectionDefinition;
import com.anli.simpleorm.definitions.EntityDefinition;
import com.anli.simpleorm.definitions.FieldDefinition;
import com.anli.simpleorm.definitions.ListDefinition;
import com.anli.simpleorm.definitions.PrimitiveDefinition;
import com.anli.simpleorm.definitions.PrimitiveType;
import com.anli.simpleorm.definitions.ReferenceDefinition;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class EntityDefinitionBuilder {

    protected EntityDefinition definition;

    public EntityDefinitionBuilder() {
    }

    public EntityDefinitionBuilder create(String name, String table) {
        definition = new EntityDefinition(name);
        definition.setTable(table);
        return this;
    }

    public EntityDefinitionBuilder addPrimaryKey(String column) {
        FieldDefinition primaryKey = getId(column);
        definition.addSingleField(primaryKey);
        definition.setPrimaryKeyName(primaryKey.getName());
        return this;
    }

    public EntityDefinitionBuilder setParent(EntityDefinition parent) {
        parent.addChildrenEntity(definition);
        return this;
    }

    public EntityDefinitionBuilder addIntegerField(String name, String column) {
        definition.addSingleField(getIntegerField(name, column));
        return this;
    }

    public EntityDefinitionBuilder addBigDecimalField(String name, String column) {
        definition.addSingleField(getBigDecimalField(name, column));
        return this;
    }

    public EntityDefinitionBuilder addDateTimeField(String name, String column) {
        definition.addSingleField(getDateTimeField(name, column));
        return this;
    }

    public EntityDefinitionBuilder addStringField(String name, String column) {
        definition.addSingleField(getStringField(name, column));
        return this;
    }

    public EntityDefinitionBuilder addReferenceField(String name, String column, EntityDefinition fieldDef) {
        definition.addSingleField(getReferenceField(name, column, fieldDef));
        return this;
    }

    public EntityDefinitionBuilder addBooleanField(String name, String column) {
        definition.addSingleField(getBooleanField(name, column));
        return this;
    }

    public EntityDefinitionBuilder addListField(String name, EntityDefinition fieldDef,
            String foreignKey, String orderColumn) {
        definition.addCollectionField(getListField(name, fieldDef, foreignKey, orderColumn));
        return this;
    }

    public EntityDefinition build() {
        return definition;
    }

    protected FieldDefinition getId(String column) {
        return new PrimitiveDefinition("id", BigInteger.class, column, PrimitiveType.REFERENCE);
    }

    protected FieldDefinition getIntegerField(String name, String column) {
        return new PrimitiveDefinition(name, Integer.class, column, PrimitiveType.NUMERIC);
    }

    protected FieldDefinition getBigDecimalField(String name, String column) {
        return new PrimitiveDefinition(name, BigDecimal.class, column, PrimitiveType.NUMERIC);
    }

    protected FieldDefinition getDateTimeField(String name, String column) {
        return new PrimitiveDefinition(name, DateTime.class, column, PrimitiveType.DATE);
    }

    protected FieldDefinition getBooleanField(String name, String column) {
        return new PrimitiveDefinition(name, Boolean.class, column, PrimitiveType.BOOLEAN);
    }

    protected FieldDefinition getStringField(String name, String column) {
        return new PrimitiveDefinition(name, String.class, column, PrimitiveType.STRING);
    }

    protected CollectionDefinition getListField(String name, EntityDefinition fieldDef,
            String foreignKey, String orderColumn) {
        return new ListDefinition(name, BigInteger.class, foreignKey, fieldDef, orderColumn);
    }

    protected ReferenceDefinition getReferenceField(String name, String column, EntityDefinition fieldDef) {
        return new ReferenceDefinition(name, BigInteger.class, column, fieldDef);
    }
}
