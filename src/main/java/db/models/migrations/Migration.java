package db.models.migrations;

import db.service.MyConnection;
import db.service.utils.ConnectionUtilities;
import db.models.BaseModel;
import db.models.fields.Field;
import db.models.migrations.exceptions.DatabaseAccessError;
import db.models.migrations.exceptions.InvalidModelClass;
import db.models.migrations.exceptions.InvalidModelFieldTypeException;
import db.models.migrations.exceptions.NoDefaultConstructorException;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Migration {
    private final Class<? extends BaseModel> model;
    private MyConnection connection;

    public Migration(Class<? extends BaseModel> model, MyConnection connection) {
        this.model = model;
        this.connection = connection;
    }

    public boolean migrate() throws SQLException {
        try {
            Object obj = this.model.getConstructor().newInstance();
            Object fields = this.model.getMethod("getFields").invoke(obj);
            if (! (fields instanceof List)){
                throw new ClassCastException();
            }
            List<Field> fieldList = (List)fields;
            Class<?> baseModel = Class.forName(this.model.getGenericSuperclass().getTypeName());
            String tableName = baseModel.getMethod("getTableName").invoke(obj).toString();
            String query = ConnectionUtilities.makeCreateTableQuery(tableName, fieldList, this.connection.getConstantsClass().getConstructor().newInstance());
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);
            return statement.execute();
        } catch (ClassCastException e) {
            throw new InvalidModelFieldTypeException(e);
        } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException e) {
            throw new InvalidModelClass(e);
        } catch (InstantiationException e) {
            throw new NoDefaultConstructorException(e);
        } catch (IllegalAccessException e) {
            throw new DatabaseAccessError(e);
        }
    }

}
