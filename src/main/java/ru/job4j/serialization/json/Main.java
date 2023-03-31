package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Friend person = new Friend(false, 30, "Ivan", new Contact("11-111"),
                new String[] {"Petr", "Sergey"});


        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

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
    }
}
