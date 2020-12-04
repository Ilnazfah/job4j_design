package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.set.SimpleSet;

import java.util.*;

public class SimpleSetTest {

    @Test
    public void whenAddThenIt() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleSet<String> array = new SimpleSet<>();
        array.iterator().next();
    }
}