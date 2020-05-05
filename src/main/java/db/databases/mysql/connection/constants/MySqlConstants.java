package db.databases.mysql.connection.constants;

import db.service.constants.ConnectionConstant;

public class MySqlConstants implements ConnectionConstant {
    private static final String CREATE_TABLE_IF_NOT_EXISTS = "CREATE TABLE IF NOT EXISTS";

    @Override
    public String getCreateTableIfNotExists() {
        return MySqlConstants.CREATE_TABLE_IF_NOT_EXISTS;
    }
}
