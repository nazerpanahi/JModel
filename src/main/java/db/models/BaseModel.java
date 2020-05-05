package db.models;

import db.models.fields.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class BaseModel {
    protected String tableName;
    private List<Field> fields;

    protected BaseModel(String tableName, List<Field> fields) {
        this.fields = fields;
        this.tableName = tableName;
    }

    protected BaseModel(String tableName, Field... fields) {
        this.tableName = tableName;
        this.fields = new ArrayList<>();
        this.fields.addAll(Arrays.asList(fields));
    }

    public String getTableName() {
        return this.tableName;
    }

    public void addField(Field field) {
        this.fields.add(field);
    }

    public void addAllFields(Collection<Field> fields) {
        this.fields.addAll(fields);
    }

    public void addAllFields(Field... fields) {
        this.fields.addAll(Arrays.asList(fields));
    }

    public List<Field> getFields() {
        return this.fields;
    }
}
