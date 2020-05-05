package db.service.utils;

import db.models.fields.Field;
import db.service.constants.ConnectionConstant;

import java.util.List;

public class ConnectionUtilities {
    public static String makeCreateTableQuery(String tableName, List<Field> fields, ConnectionConstant constant) {
        StringBuilder builder = new StringBuilder(constant.getCreateTableIfNotExists());
        builder.append(" ").append(tableName).append(" (");
        int size = fields.size();
        Field f;
        for (int i = 0; i < size - 1; i++) {
            f = fields.get(i);
            builder.append(f.getSQL()).append(", ");
        }
        builder.append(fields.get(size - 1).getSQL());
        return builder.append(");").toString();
    }
}
