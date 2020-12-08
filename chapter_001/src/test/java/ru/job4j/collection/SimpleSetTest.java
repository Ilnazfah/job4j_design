package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.set.SimpleSet;

import java.util.*;

public class SimpleSetTest {

    @Test
    public void whenAddEqualValuesThenIt() {
        SimpleSet<String> array = new SimpleSet<>();
        Iterator<String> it = array.iterator();
        array.add("first");
        array.add("first");
        array.add("second");
        assertThat(it.next(), is("first"));
        assertThat(it.next(), is("second"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleSet<String> array = new SimpleSet<>();
        array.iterator().next();
    }
}