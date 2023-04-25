package manager;

import orm.annotations.Column;
import orm.exceptions.ORMException;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class EntityManager<E> implements DbContext<E> {
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Id {

    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Entity {
        String name();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Column {
        String name();
    }

    @Override
    public boolean persist(E entity) {
        Field primaryKey = getId(entity.getClass());
        primaryKey.setAccessible(true);

        return doInsert(entity);
    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return find(table, null);
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        List<E> listEntities = new ArrayList<>();

        String tableName = getTableName(table);

        String query = String.format("SELECT * FROM %s%s;",
                tableName, (where == null || where.trim().isEmpty()) ? "" : " WHERE " + where);

        ResultSet resultSet;

        try {
            resultSet = this.connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            E entity = this.fillEntity(table, resultSet);

            listEntities.add(entity);
        }

        return listEntities;
    }


    @Override
    public E findFirst(Class<E> table) {
        return findFirst(table, null);
    }

    @Override
    public E findFirst(Class<E> table, String where) {
        String tableName = getTableName(table);

        String query = String.format("SELECT * FROM %s%s LIMIT 1;",
                tableName, (where == null || where.trim().isEmpty()) ? "" : " WHERE " + where);

        ResultSet resultSet;

        try {
            resultSet = this.connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (!resultSet.next()) {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.fillEntity(table, resultSet);
    }

    @Override
    public void doCreate(Class<E> entityClass) {
        String tableName = getTableName(entityClass);

        String query = String.format("CREATE TABLE %s ( id INT PRIMARY KEY AUTO_INCREMENT, %s);",
                tableName, getAllFieldsAndDataTypes(entityClass));

        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doAlter(E entity) {
        String tableName = getTableName(entity.getClass());

        String query = String.format("ALTER TABLE %s ADD COLUMN %s;",
                tableName, getNewFields(entity));

        try {
            connection.prepareStatement(query).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAllFieldsAndDataTypes(Class<E> entityClass) {
        StringBuilder out = new StringBuilder();

        Field[] fields = Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .toArray(Field[]::new);

        Arrays.stream(fields).forEach(f -> out.append(getNameAndDataTypeOfField(f)));

        return out.substring(0, out.length() - 1);
    }

    private String getTableName(Class<?> entity) {
        Entity annotation = entity.getAnnotation(Entity.class);

        if (annotation == null) {
            throw new ORMException("Provided class does not have entity annotation!");
        }

        return annotation.name();
    }

    private String getDbFields(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(f -> f.getAnnotation(Column.class) != null)
                .map(f -> f.getAnnotation(Column.class).name())
                .collect(Collectors.joining(", "));
    }

    private String getInsertValues(E entity) {
        Field[] declaredFields = entity.getClass().getDeclaredFields();

        List<String> result = new ArrayList<>();

        for (Field declaredField : declaredFields) {
            if (declaredField.getAnnotation(Column.class) == null) {
                continue;
            }

            declaredField.setAccessible(true);
            Object object;

            try {
                object = declaredField.get(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            result.add("\"" + object.toString() + "\"");
        }


        return String.join(", ", result);
    }
    private Field getId(Class<?> entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have a primary key!"));
    }

    private boolean doInsert(E entity) {
        String tableName = this.getTableName(entity.getClass());
        String fieldList = this.getDbFields(entity);
        String valueList;

        valueList = this.getInsertValues(entity);

        String query = String.format("INSERT INTO %s (%s) VALUES(%s);", tableName, fieldList, valueList);

        try {
            return this.connection.prepareStatement(query).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private E fillEntity(Class<E> table, ResultSet resultSet) {
        E entity;

        try {
            entity = table.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Field[] declaredFields = entity.getClass().getDeclaredFields();

        for (Field declaredField : declaredFields) {
            if (!declaredField.isAnnotationPresent(Column.class) &&
                    !declaredField.isAnnotationPresent(Id.class)) {
                continue;
            }

            Column columnAnnotation = declaredField.getAnnotation(Column.class);

            String fieldName = columnAnnotation == null ?
                    declaredField.getName() : columnAnnotation.name();

            String value;

            try {
                value = resultSet.getString(fieldName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            this.fillData(entity, declaredField, value);
        }

        return entity;
    }

    private void fillData(E entity, Field field, String value) {
        field.setAccessible(true);

        if (field.getType() == Long.class || field.getType() == long.class) {
            try {
                field.setLong(entity, Long.parseLong(value));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else if (field.getType() == Integer.class || field.getType() == int.class) {
            try {
                field.setInt(entity, Integer.parseInt(value));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else if (field.getType() == LocalDate.class) {
            try {
                field.set(entity, LocalDate.parse(value));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else if (field.getType() == String.class) {
            try {
                field.set(entity, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new ORMException("Unsupported type " + field.getType());
        }
    }

    private String getNameAndDataTypeOfField(Field field) {
        StringBuilder out = new StringBuilder();

        field.setAccessible(true);

        String fieldName = field.getName();

        out.append(String.format(" %s", fieldName));

        if (field.getType() == Long.class || field.getType() == long.class) {
            out.append(" LONG NOT NULL,"); //get long class field
        } else if (field.getType() == Integer.class || field.getType() == int.class) {
            out.append(" INT NOT NULL,"); //get int class field
        } else if (field.getType() == Double.class || field.getType() == double.class) {
            out.append(" DOUBLE NOT NULL,"); //get int class field
        } else if (field.getType() == String.class) {
            out.append(" VARCHAR(50) NOT NULL,"); //get int class field
        } else if (field.getType() == LocalDate.class) {
            out.append(" DATE NOT NULL,"); //get date class field
        } else {
            throw new ORMException("Unsupported type " + field.getType());
        }

        return out.toString();
    }

    private String getNewFields(E entity) {
        StringBuilder out = new StringBuilder();

        String tableName = getTableName(entity.getClass());

        Set<String> fields = getAllFieldsFromTable(tableName);

        Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .forEach(field -> {
                    String fieldName = field.getName();
                    if (!fields.contains(fieldName)) {
                        out.append(getNameAndDataTypeOfField(field));
                    }
                });

        return out.substring(0, out.length() - 2);
    }

    private Set<String> getAllFieldsFromTable(String tableName) {
        Set<String> allFields = new HashSet<>();

        String query = String.format("SELECT `COLUMN_NAME`" +
                " FROM `information_schema`.`COLUMNS` " +
                "WHERE `TABLE_SCHEMA` = 'test' " +
                "AND `COLUMN_NAME` != 'id' AND TABLE_NAME = '%s';", tableName);

        PreparedStatement statement;
        try {
            statement = connection
                    .prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                allFields.add(resultSet.getString(1));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return allFields;
    }
}