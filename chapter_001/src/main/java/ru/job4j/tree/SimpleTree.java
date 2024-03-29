package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(child).isPresent()) {
            return false;
        } else if (findBy(parent).isPresent()) {
            Node<E> node = new Node<>(child);
            root.getChildren().add(node);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl;
        Predicate<Node<E>> predicate = val -> val.getValue().equals(value);
        rsl = findByPredicate(predicate);
        return rsl;
    }

    public boolean isBinary() {
        Predicate<Node<E>> predicate = child -> !child.getChildren().isEmpty() && child.getChildren().size() > 2;
        return findByPredicate(predicate).isEmpty();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}