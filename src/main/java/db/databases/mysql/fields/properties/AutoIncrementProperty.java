package db.databases.mysql.fields.properties;

import db.models.fields.properties.FieldProperty;

import java.util.Objects;

public class AutoIncrementProperty implements FieldProperty {
    private String sql;
    @Override
    public String getSQL() {
        if (Objects.isNull(this.sql) || this.sql.isBlank() || this.sql.isEmpty()){
            this.sql = "auto_increment";
        }
        return this.sql;
    }

    @Override
    public String toString() {
        return this.getSQL();
    }
}
