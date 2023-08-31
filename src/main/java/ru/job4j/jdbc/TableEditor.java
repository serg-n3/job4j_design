package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
            Class.forName("org.postgresql.Driver");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createTable(String tableName) {
        return String.format(
                    "CREATE TABLE IF NOT EXISTS %s();",
                    tableName
            );
    }

    public String dropTable(String tableName) {
        return String.format(
                    "DROP TABLE IF EXISTS %s",
                    tableName
            );
    }

    public String addColumn(String tableName, String columnName, String type) {
        return   String.format(
                    "ALTER TABLE %s ADD COLUMN %s %s",
                    tableName,
                    columnName,
                    type
            );
    }

    public String dropColumn(String tableName, String columnName) {
        return String.format(
                    "ALTER TABLE %s DROP COLUMN %s CASCADE",
                    tableName,
                    columnName
            );
    }

    public String renameColumn(String tableName, String columnName, String newColumnName) {
        return String.format(
                    "ALTER TABLE %s RENAME COLUMN %s TO %s",
                    tableName,
                    columnName,
                    newColumnName
            );
    }

    private void statementExecute(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        TableEditor tableEditor = new TableEditor(new Properties());
        tableEditor.statementExecute(tableEditor.dropTable("demo_table"));
        tableEditor.statementExecute(tableEditor.createTable("demo_table"));
        System.out.println(tableEditor.getTableScheme("demo_table"));
        tableEditor.statementExecute(tableEditor.addColumn("demo_table", "id", "SERIAL PRIMARY KEY"));
        tableEditor.statementExecute(tableEditor.addColumn("demo_table", "name", "TEXT"));
        System.out.println(tableEditor.getTableScheme("demo_table"));
        tableEditor.statementExecute(tableEditor.renameColumn("demo_table", "name", "new_name"));
        System.out.println(tableEditor.getTableScheme("demo_table"));
        tableEditor.statementExecute(tableEditor.dropColumn("demo_table", "new_name"));
        System.out.println(tableEditor.getTableScheme("demo_table"));
        tableEditor.statementExecute(tableEditor.dropTable("demo_table"));
        tableEditor.close();
    }
}