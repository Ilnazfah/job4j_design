package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
//        Mall mall = new Mall("TK", 500, false, new Manager("Ivan"), "Cosmetics", "Products");
//        final Gson gson = new GsonBuilder().create();
//        System.out.println(gson.toJson(mall));
//
//        final String mallJson =
//                "{"
//                        + "\"name\":\"TK\","
//                        + "\"parkingPlaces\":500,"
//                        + "\"rtcStore\":false,"
//                        + "\"manager\":"
//                        + "{"
//                        + "\"name\":\"Ivan\"},"
//                        + "\"goods\":[\"Cosmetics\""
//                        + ",\"Products\"]"
//                        + "}";
//        final Mall mallMod = gson.fromJson(mallJson, Mall.class);
//        System.out.println(mallMod);

        JSONObject jsonManager = new JSONObject("{\"name\":\"Ivan\"}");

        List<String> list = new ArrayList<>();
        list.add("Cosmetics");
        list.add("Products");
        JSONArray jsonGoods = new JSONArray(list);

        Mall mall = new Mall("TK", 500, false, new Manager("Ivan"), "Cosmetics", "Products");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", mall.getName());
        jsonObject.put("parkingPlaces", mall.getParkingPlaces());
        jsonObject.put("rtcStore", mall.isRtcStore());
        jsonObject.put("manager", jsonManager);
        jsonObject.put("goods", jsonGoods);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(mall).toString());
    }
}