package db.databases.postgres.connection.constants;

import db.service.constants.ConnectionConstant;

public class PGConstants implements ConnectionConstant {
    private static final String CREATE_TABLE_IF_NOT_EXISTS = "CREATE TABLE IF NOT EXISTS";

    @Override
    public String getCreateTableIfNotExists() {
        return PGConstants.CREATE_TABLE_IF_NOT_EXISTS;
    }
}
