package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = mem.indexOf(findById(id));
        if (index >= 0) {
            mem.set(index, model);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        int index  = mem.indexOf(findById(id));
        if (index >=  0) {
            mem.remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T t : mem) {
            if (t.getId().equals(id)) {
                result = t;
            }
        }
        return result;
    }
}