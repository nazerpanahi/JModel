package db.models.fields.properties;

import db.service.constants.ConnectionConstant;
import db.models.fields.ChoiceKey;
import db.models.fields.exceptions.ValueTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NUPProperty implements FieldProperty {
    public static final FieldProperties NN_PROPERTY;
    public static final FieldProperties UN_PROPERTY;
    public static final FieldProperties PK_PROPERTY;
    public static final FieldProperties NUP_PROPERTY;
    public static final int NOT_NULL_VALUE;
    public static final int UNIQUE_VALUE;
    public static final int PK_VALUE;

    protected List<String> choices;
    private String sql;

    static {
        NN_PROPERTY = new FieldProperties(new NUPProperty(4));
        UN_PROPERTY = new FieldProperties(new NUPProperty(2));
        PK_PROPERTY = new FieldProperties(new NUPProperty(1));
        NUP_PROPERTY = new FieldProperties(new NUPProperty(7));

        NOT_NULL_VALUE =4;
        UNIQUE_VALUE=2;
        PK_VALUE=1;
    }

    {
        choices = new ArrayList<>();
    }

    public NUPProperty() {
    }

    public NUPProperty(Map<String, Object> choices) {
        Objects.requireNonNull(choices);
        choices.forEach(this::prepare);
    }

    public NUPProperty(int nup) {
        int numberOfFields = 3;
        int topLimit = ((int) Math.pow(2, numberOfFields)) - 1;
        while (nup > 0 && nup <= topLimit) {
            if (nup >= 4) {
                addProperty(ConnectionConstant.NOT_NULL);
                nup -= 4;
            } else if (nup >= 2) {
                addProperty(ConnectionConstant.UNIQUE);
                nup -= 2;
            } else {
                addProperty(ConnectionConstant.PRIMARY_KEY);
                nup -= 1;
            }
        }
    }

    public NUPProperty(String code) {
        Objects.requireNonNull(code);
        parse(code);
    }

    private void prepare(String k, Object v) {
        switch (k) {
            case ChoiceKey.NULL: {
                boolean notNull = !toBoolean(v);
                addChoicesIf(notNull, ConnectionConstant.NOT_NULL);
                break;
            }
            case ChoiceKey.UNIQUE: {
                boolean unique = toBoolean(v);
                addChoicesIf(unique, ConnectionConstant.UNIQUE);
                break;
            }
            case ChoiceKey.PRIMARY_KEY: {
                boolean pk = toBoolean(v);
                addChoicesIf(pk, ConnectionConstant.PRIMARY_KEY);
                break;
            }
        }
    }

    private void parse(String code) {
        String[] props = code.split(",");
        for (String prop : props) {
            switch (prop.trim()) {
                case "nn": {
                    addChoicesIf(true, ConnectionConstant.NOT_NULL);
                    break;
                }
                case "u": {
                    addChoicesIf(true, ConnectionConstant.UNIQUE);
                    break;
                }
                case "p": {
                    addChoicesIf(true, ConnectionConstant.PRIMARY_KEY);
                    break;
                }
            }
        }
    }

    @Override
    public String getSQL() {
        if (Objects.isNull(this.sql) || this.sql.isBlank() || this.sql.isEmpty()) {
            this.sql = String.join(" ", this.choices);
        }
        return this.sql;
    }

    private static boolean toBoolean(Object v) {
        if (!(v instanceof Boolean)) {
            throw new ValueTypeException();
        }
        return (Boolean) v;
    }

    private void addChoicesIf(Boolean condition, String connectionConst) {
        if (condition) {
            addProperty(connectionConst);
        }
    }

    private void addProperty(String connectionConst) {
        this.choices.add(connectionConst);
    }
}
