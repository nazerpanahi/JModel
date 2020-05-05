package db.models.migrations;

import db.service.MyConnection;
import db.models.BaseModel;

import java.sql.SQLException;
import java.util.Collection;

public class Migrations {
    private final Class<? extends BaseModel>[] models;
    private Migration[] migrations;
    private MyConnection connection;

    public Migrations(Class<? extends BaseModel>[] models, MyConnection connection) {
        this.models = models;
        this.connection = connection;
    }

    public Migrations(Collection<Class<? extends BaseModel>> models, MyConnection connection){
        this(models.toArray(new Class[0]), connection);
    }

    public void makeMigrations(){
        if (this.migrations==null){
            this.migrations = new Migration[this.models.length];
            for (int i = 0; i < this.models.length; i++) {
                this.migrations[i] = new Migration(this.models[i], this.connection);
            }
        }
    }

    public void migrateAll() throws SQLException {
        for (Migration migration : this.migrations) {
            migration.migrate();
        }
    }
}
