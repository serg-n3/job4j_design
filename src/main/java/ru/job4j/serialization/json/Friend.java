package ru.job4j.serialization.json;

import java.util.Arrays;

public class Friend {
    private final boolean haveHome;
    private final int age;
    private final String name;
    private final Contact contact;
    private final String[] otherFriends;

    public Friend(boolean haveHome, int age, String name, Contact contact, String[] otherFriends) {
        this.haveHome = haveHome;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.otherFriends = otherFriends;
    }

    @Override
    public String toString() {
        return "Person{"
                + "haveHome=" + haveHome
                + ", age=" + age
                + ", name=" + name
                + ", contact=" + contact
                + ", otherFriends=" + Arrays.toString(otherFriends)
                + '}';
    }
}
