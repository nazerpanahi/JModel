package db.models.fields.properties;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FieldProperties {
    private List<FieldProperty> properties;
    private String sql;

    public FieldProperties() {
        this.properties = new LinkedList<>();
    }

    public FieldProperties(List<FieldProperty> properties) {
        this.properties = properties;
    }

    public FieldProperties(FieldProperty... property) {
        this.properties = Arrays.asList(property);
    }

    public String getSQL() {
        if (Objects.isNull(this.sql) || this.sql.isBlank() || this.sql.isEmpty()) {
            List<String> propsSql = new LinkedList<>();
            this.properties.forEach((e) -> {
                propsSql.add(e.getSQL());
            });
            this.sql = String.join(" ", propsSql);
        }
        return this.sql;
    }

    @Override
    public String toString() {
        return this.getSQL();
    }
}
