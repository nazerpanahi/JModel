
# JModel : Simple ORM for java

## Prerequisites
* JavaSE 11 or later
* maven

## Description
This is a very simple ORM for using models in java like hibernate.
It simply allows you to make models and migrate them. Read the example
to know how to work with.

## Introduction

### Models
For creating models you should have a class that extends from BaseModel class
(`db.models.BaseModel`).

Each model has some fields.You pass all the fields in the constructor of
`BaseModel` or you can pass them by using `addField` or `AddAllFields` methods.

### Fields
Each Models has some fields. You can access all fields in
`db.models.fields`. Each Field class is inherited from `Field`
Interface and `AbstractField` class. For creating a new customize Field you
should extend `AbstractField` class. This is a superclass for all fields that
implements `Field` Interface. Each Field has name, type, and some properties.

Some general Fields are in `db.models.fields.types`. These are fields that are
common in all databases. For some fields that are specific for a database you
can find database in `db.models.databases` and then choose the specific field
type.

### Properties
Each Field has some properties. You can use some general properties that are
in `db.models.fields.properties` package or use a specific property in the
`db.databases` package.

### Migration
After creating the models, use the Migration class to create tables in the
database.

## Example
### Make models
* Make user model class in different ways:
1. Using FieldProperties constructors
    ```java
    public static class UserModel extends BaseModel {
        public UserModel() {
            super("users");

            // just for see how to use FieldProperties class constructors
            HashMap<String, Object> choices = new HashMap<>();
            choices.put(ChoiceKey.NULL, false);
            choices.put(ChoiceKey.UNIQUE, true);

            FieldProperties pkProps = new FieldProperties(
                                            new NUPProperty("nn, u, p")
                                        );
            FieldProperties nnProps = new FieldProperties(new NUPProperty(4));
            FieldProperties nnuProps = new FieldProperties(
                                            new NUPProperty(choices)
                                        );
            this.addAllFields(
                    new IntegerField("id", pkProps),
                    new CharField("first_name", 80, nnProps),
                    new CharField("last_name", 80, nnProps),
                    new CharField("national_id", 10, nnuProps)
            );
        }
    }
    ```
2. Using helper classes

    ```java
    public static class UserModel extends BaseModel {
        public UserModel() {
            super("users");

            this.addAllFields(
                    new IntegerField("id", NUPProperty.PK_PROPERTY),
                    new CharField("first_name", 80, NUPProperty.NN_PROPERTY),
                    new CharField("last_name", 80, NUPProperty.NN_PROPERTY),
                    new CharField("national_id", 10)
            );
        }
    }
    ```
