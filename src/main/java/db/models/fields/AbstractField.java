package db.models.fields;

import db.models.fields.datatypes.FieldType;
import db.models.fields.properties.FieldProperties;

import java.util.List;
import java.util.Objects;

public abstract class AbstractField implements Field {

    protected String name;
    protected FieldType type;
    protected String sql;
    protected FieldProperties properties;

    protected AbstractField(String name, FieldType type, FieldProperties properties) {
        this.name = name;
        this.type = type;
        properties = Objects.requireNonNullElse(properties, new FieldProperties());
        this.properties = properties;
    }

    protected AbstractField(String name, FieldType type) {
        this(name, type, new FieldProperties());
    }

    @Override
    public String getSQL() {
        if (Objects.isNull(sql) || sql.isBlank() || sql.isEmpty()) {
            this.sql = String.join(" ", this.name, getFieldName(), this.properties.getSQL());
        }
        return this.sql;
    }

    @Override
    public String getFieldName() {
        return this.type.toString();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractField)) return false;
        AbstractField that = (AbstractField) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
