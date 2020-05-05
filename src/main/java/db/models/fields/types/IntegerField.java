package db.models.fields.types;

import db.models.fields.AbstractField;
import db.models.fields.properties.FieldProperties;
import db.models.fields.datatypes.GeneralFieldTypes;

public class IntegerField extends AbstractField {

    public IntegerField(String name) {
        super(name, GeneralFieldTypes.INT);
    }

    public IntegerField(String name, FieldProperties properties) {
        super(name, GeneralFieldTypes.INT, properties);
    }
}
