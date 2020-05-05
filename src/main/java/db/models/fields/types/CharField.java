package db.models.fields.types;

import db.models.fields.AbstractField;
import db.models.fields.properties.FieldProperties;
import db.models.fields.datatypes.GeneralFieldTypes;

public class CharField extends AbstractField {
    private int maxLength;

    public CharField(String name, int maxLength) {
        super(name, GeneralFieldTypes.VARCHAR);
        setMaxLength(maxLength);
    }

    public CharField(String name, int maxLength, FieldProperties properties) {
        super(name, GeneralFieldTypes.VARCHAR, properties);
        setMaxLength(maxLength);
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String getFieldName() {
        return this.type.toString() + "(" + this.maxLength + ")";
    }
}
