package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Ilnaz Fahriev";
        int age = 29;
        byte b = 7;
        short s = 77;
        int i = 777;
        long l = 777L;
        boolean bl = true;
        char c = 55;
        LOG.debug("User info name : {}, age : {}", name, age);
        LOG.debug("b : {}, s : {}, i : {}, l : {}, bl : {}, c : {}", b, s, i, l, bl, c);
    }
}