package db.service;

import db.service.constants.ConnectionConstant;

import java.sql.Connection;

public interface MyConnection {
    Class<? extends ConnectionConstant> getConstantsClass();

    void setConstantsClass(Class<? extends ConnectionConstant> constant);

    Connection getConnection();

    void setConnection(Connection connection);
}
