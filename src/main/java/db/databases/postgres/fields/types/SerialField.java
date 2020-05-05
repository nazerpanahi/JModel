package db.databases.postgres.fields.types;

import db.models.fields.AbstractField;
import db.models.fields.properties.FieldProperties;
import db.databases.postgres.fields.datatypes.PostgresFieldType;

public class SerialField extends AbstractField {
    protected SerialField(String name, FieldProperties properties) {
        super(name, PostgresFieldType.SERIAL, properties);
    }

    protected SerialField(String name) {
        super(name, PostgresFieldType.SERIAL);
    }
}
