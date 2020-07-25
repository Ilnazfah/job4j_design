package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = mem.indexOf(id);
        if (index >= 0) {
            mem.set(index, model);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        int index  = mem.indexOf(id);
        if (index >= 0) {
            mem.remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T findById(String id) {
        int index = mem.indexOf(id);
        //return this.mem.get(index);
        return mem.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}