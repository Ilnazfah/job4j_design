package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Start {
    public static void main(String[] args) {
        Mall mall = new Mall("TK", 500, false, new Manager("Ivan"), "Cosmetics", "Products");
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(mall));

        final String mallJson =
                "{"
                        + "\"name\":\"TK\","
                        + "\"parkingPlaces\":500,"
                        + "\"rtcStore\":false,"
                        + "\"manager\":"
                        + "{"
                        + "\"name\":\"Ivan\"},"
                        + "\"goods\":[\"Cosmetics\""
                        + ",\"Products\"]"
                        + "}";
        final Mall mallMod = gson.fromJson(mallJson, Mall.class);
        System.out.println(mallMod);
    }
}