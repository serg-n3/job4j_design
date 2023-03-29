package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        byte byt = 1;
        short shor = 100;
        int in = 7777777;
        long lon = 8L;
        double doubl = 3.14;
        float floa = 3.14f;
        char cha = 'u';
        boolean boolea = true;
        LOG.debug("Primitive: byte - {}, short - {}, int - {}, long - {},"
                        + " double - {}, float - {}, char - {}, boolean - {}", byt, shor, in,
                lon, doubl, floa, cha, boolea);
    }
}
