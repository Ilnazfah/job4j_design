package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    private Statement statement;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) throws SQLException {
        String sql = String.format(
                "create table if not exists %s (%s, %s);",
                tableName,
                "id serial primary key",
                "name varchar(255)"
            );
        statement.execute(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = String.format(
                "drop table if exists %s;",
                tableName
        );
        statement.execute(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = String.format(
                "alter table %s add column %s %s;",
                tableName,
                columnName,
                type
        );
        statement.execute(sql);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format(
                "alter table %s drop column %s;",
                tableName,
                columnName
        );
        statement.execute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String sql = String.format(
                "alter table %s rename column %s to %s;",
                tableName,
                columnName,
                newColumnName
        );
        statement.execute(sql);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
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

    public Connection getConnection() {
        return connection;
    }
}