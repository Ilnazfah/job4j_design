package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {
    private SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();

    @Test
    public void whenInsertElement() {
        simpleHashMap.insert(1, "Ilnaz1");
        simpleHashMap.insert(2, "Ilnaz2");
        int size = simpleHashMap.getSize();
        assertThat(size, is(2));
    }

    @Test
    public void whenInsertThenGet() {
        simpleHashMap.insert(1, "Ilnaz1");
        String value = simpleHashMap.get(1);
        assertThat(value, is("Ilnaz1"));
        simpleHashMap.insert(2, "Ilnaz2");
        value = simpleHashMap.get(2);
        assertThat(value, is("Ilnaz2"));
    }

    @Test
    public void whenDelete() {
        simpleHashMap.insert(1, "Ilnaz1");
        simpleHashMap.insert(2, "Ilnaz2");
        simpleHashMap.delete(1);
        assertThat(simpleHashMap.get(1), nullValue());
        assertThat(simpleHashMap.getSize(), is(1));
    }

    @Test
    public void whenIterate() {
        var iterator = simpleHashMap.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            i++;
        }
        assertThat(i, is(simpleHashMap.getSize()));
    }

    @Test
    public void checkLength() {
        simpleHashMap.insert(1, "1");
        simpleHashMap.insert(2, "2");
        simpleHashMap.insert(3, "3");
        System.out.println(simpleHashMap.getTableSize());
        simpleHashMap.insert(4, "4");
        simpleHashMap.insert(5, "5");
        simpleHashMap.insert(6, "6");
        simpleHashMap.insert(7, "7");
        simpleHashMap.insert(8, "8");
        simpleHashMap.insert(9, "9");
        simpleHashMap.insert(10, "10");
        simpleHashMap.insert(11, "11");
        simpleHashMap.insert(12, "12");
        simpleHashMap.insert(13, "13");
        simpleHashMap.insert(14, "14");
        simpleHashMap.insert(15, "15");
        simpleHashMap.insert(16, "16");
        simpleHashMap.insert(17, "17");
        System.out.println(simpleHashMap.getTableSize());
    }
}