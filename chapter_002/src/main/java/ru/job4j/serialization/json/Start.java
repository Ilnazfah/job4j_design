package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.serialization.Contact;

public class Start {
    public static void main(String[] args) {
        Person person1 = new Person("ILnaz", 29, false, new Contact(111111, "+7-937-111-11-11"), "Has a cat", "not Married");
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person1));

        final String personJson =
                "{"
                        + "\"name\":\"ILnaz\","
                        + "\"age\":29,"
                        + "\"sex\":false,"
                        + "\"contact\":"
                        + "{"
                        + "\"zipCode\":111111,"
                        + "\"phone\":\"+7-937-111-11-11\""
                        + "},"
                        + "\"statuses\":[\"Has a cat\","
                        + "\"not Married\"]"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}