package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(l -> !l.startsWith("#"))
                    .forEach(l -> values.put(l.split("=")[0],
                            l.split("=").length > 1 ? l.split("=")[1] : null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("withoutcomment.properties"));
        System.out.println(new Config("withcomment.properties"));
    }
}