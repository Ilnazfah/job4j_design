package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./../withoutcomment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("name#"), is("Ilnaz"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./../withcomment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("name#"), is("Ilnaz"));
        assertThat(config.value("#some comment"), isEmptyOrNullString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenIllegalArgumentException() {
        String path = "./../nullkeyorvalue.properties";
        Config config = new Config(path);
        config.load();
    }
}