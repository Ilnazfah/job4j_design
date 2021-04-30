package ru.job4j.tree;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

    public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertTrue(tree.findBy(6).isPresent());
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertFalse(tree.findBy(7).isPresent());
    }

        @Test
        public void whenMore3Children() {
            Tree<Integer> tree = new SimpleTree<>(1);
            tree.add(1, 2);
            tree.add(1, 3);
            tree.add(1, 4);
            tree.add(4, 5);
            tree.add(5, 6);
            Assert.assertFalse(tree.isBinary());
        }

        @Test
        public void whenAll2Children() {
            Tree<Integer> tree = new SimpleTree<>(1);
            tree.add(1, 2);
            tree.add(1, 3);
            tree.add(4, 5);
            tree.add(4, 6);
            Assert.assertTrue(tree.isBinary());
        }
}