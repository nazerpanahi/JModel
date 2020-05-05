package db.databases.postgres.connection;

import db.service.DBConnection;
import db.service.MyConnection;
import db.service.constants.ConnectionConstant;
import db.databases.postgres.connection.constants.PGConstants;

import java.sql.Connection;
import java.sql.SQLException;

public class PGConnection implements MyConnection {
    private Connection connection;
    private Class<? extends ConnectionConstant> constantClass;

    {
        constantClass = PGConstants.class;
    }

    public PGConnection(Connection connection) {
        this.connection = connection;
    }

    public PGConnection(Connection connection, Class<? extends ConnectionConstant> constantClass) {
        this.connection = connection;
        this.constantClass = constantClass;
    }

    public PGConnection(String user, String password) throws SQLException, ClassNotFoundException {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql:";
        this.connection = DBConnection.getConnection(driver, url, user, password);
    }

    @Override
    public Class<? extends ConnectionConstant> getConstantsClass() {
        return this.constantClass;
    }

    @Override
    public void setConstantsClass(Class<? extends ConnectionConstant> constant) {
        this.constantClass = constant;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
