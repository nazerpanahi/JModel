package db.service.constants;

public interface ConnectionConstant {
    String NOT_NULL = "NOT NULL";
    String UNIQUE = "UNIQUE";
    String PRIMARY_KEY = "PRIMARY KEY";

    String getCreateTableIfNotExists();
}
