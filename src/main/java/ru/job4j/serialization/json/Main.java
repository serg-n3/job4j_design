package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Friend friend = new Friend(false, 30, "Ivan", new Contact("11-111"),
                new String[]{"Petr", "Sergey"});


        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(friend));

        final String friendJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"name\":Ivan,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"otherFriends\":"
                        + "[\"Petr\",\"Sergey\"]"
                        + "}";
        final Friend friendMod = gson.fromJson(friendJson, Friend.class);
        System.out.println(friendMod);

        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Petr");
        list.add("Sergey");
        JSONArray jsonOtherFriends = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Friend friend1 = new Friend(false, 30, "Ivan", new Contact("11-111"),
                new String[]{"Petr", "Sergey"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", friend1.isHaveHome());
        jsonObject.put("age", friend1.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonOtherFriends);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(friend1).toString());
    }
}

