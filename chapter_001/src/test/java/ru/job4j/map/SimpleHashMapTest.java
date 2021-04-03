package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {
    private SimpleHashMap<String, String> map = new SimpleHashMap<>();

    @Test
    public void whenInsertElement() {
        map.insert("Ilnaz1", "Ilnaz1");
        map.insert("Ilnaz2", "Ilnaz2");
        int size = map.getSize();
        assertThat(size, is(2));
    }

    @Test
    public void whenInsertThenGet() {
        map.insert("Ilnaz1", "Ilnaz1");
        String value = map.get("Ilnaz1");
        assertThat(value, is("Ilnaz1"));
        map.insert("Ilnaz2", "Ilnaz2");
        value = map.get("Ilnaz2");
        assertThat(value, is("Ilnaz2"));
    }

    @Test
    public void whenDelete() {
        map.insert("Ilnaz1", "Ilnaz1");
        map.insert("Ilnaz2", "Ilnaz2");
        map.delete("Ilnaz1");
        assertThat(map.get("Ilnaz1"), nullValue());
        assertThat(map.getSize(), is(1));
    }

    @Test
    public void whenIterate() {
        var iterator = map.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            i++;
        }
        assertThat(i, is(map.getSize()));
    }

    @Test
    public void whenLenghtResize() {
        for (int i = 0; i < 50; i++) {
            map.insert("Ilnaz_" + i, "Ilnaz_" + i);
            if (i == 1) {
                System.out.println(map.get("Ilnaz_" + 1) + " : " + "Index = " + map.getIndex("Ilnaz_" + 1));
            }
        }
        System.out.println(map.get("Ilnaz_" + 1) + " : " + "Index = " + map.getIndex("Ilnaz_" + 1));
        for (String s : map) {
            System.out.println(s);
        }
    }
}