package ru.job4j.jdbc.spammer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

public class ImportDBTest {
    private Properties properties;
    private Statement statement;
    private ImportDB db;
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        String path = Objects.requireNonNull(getClass().
                getClassLoader().getResource("spammer/app.properties")).getPath();
        Reader reader = new FileReader(path);
        properties = new Properties();
        properties.load(reader);
        String dump = Objects.requireNonNull(getClass().
                getClassLoader().getResource("spammer/dump.txt")).getPath();
        db = new ImportDB(this.properties, dump);
        connection = db.getConnection();
        statement = connection.createStatement();
        String sql = String.format("create table if not exists users (%s, %s, %s);",
                "id serial primary key",
                "name text UNIQUE",
                "email text UNIQUE"
        );
        statement.execute(sql);
    }

    @After
    public void tearDown() throws SQLException {
        String sql = "drop table if exists users;";
        statement.execute(sql);
    }

    @Test
    public void whenLoadAndSave() throws Exception {
        db.save(db.load());
    }
}