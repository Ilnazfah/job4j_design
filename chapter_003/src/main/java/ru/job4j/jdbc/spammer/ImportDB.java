package ru.job4j.jdbc.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private final Properties cfg;
    private final String dump;
    private Connection connection;

    public ImportDB(Properties cfg, String dump) throws Exception {
        this.cfg = cfg;
        this.dump = dump;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try {
            connection = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> load() throws Exception {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(l -> {
                String[] data = l.split(";");
                users.add(new User(data[0], data[1]));
            });
        }
        return users;
    }

    public void save(List<User> users) throws SQLException {
        for (User user : users) {
            try (PreparedStatement ps = connection.prepareStatement("insert into users(name, email) values (?, ?)")) {
                ps.setString(1, user.name);
                ps.setString(2, user.email);
                ps.execute();
            }
        }
    }

    private static class User {
        private final String name;
        private final String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}