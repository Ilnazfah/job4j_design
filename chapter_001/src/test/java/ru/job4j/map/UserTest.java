package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    @Test
    public void whenNoOverrideEqualsAndHashCode() {
        User user1 = new User("Java", 0, new GregorianCalendar(1995, 05, 23));
        User user2 = new User("Java", 0, new GregorianCalendar(1995, 05, 23));
        Object o = new Object();
        Map<User, Object> users = new HashMap<>();
        users.put(user1, o);
        users.put(user2, o);
        for (Map.Entry<User, Object> m : users.entrySet()) {
            System.out.println(m);
        }
    }
}