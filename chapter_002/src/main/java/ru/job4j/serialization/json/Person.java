package ru.job4j.serialization.json;

import ru.job4j.serialization.Contact;

import java.util.Arrays;

public class Person {
    private final String name;
    private final int age;
    private final boolean sex;
    private final Contact contact;
    private final String[] statuses;

    public Person(String name, int age, boolean sex, Contact contact, String... statuses) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", sex=" + sex
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}