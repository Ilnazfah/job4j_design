package ru.job4j.serialization.json;

import java.util.Arrays;

public class Mall {
    private final String name;
    private final int parkingPlaces;
    private final boolean rtcStore;
    private final Manager manager;
    private final String[] goods;

    public Mall(String name, int parkingPlaces, boolean rtcStore, Manager manager, String... goods) {
        this.name = name;
        this.parkingPlaces = parkingPlaces;
        this.rtcStore = rtcStore;
        this.manager = manager;
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Mall{"
                + "name='" + name + '\''
                + ", parkingPlaces=" + parkingPlaces
                + ", rtcStore=" + rtcStore
                + ", store=" + manager
                + ", goods=" + Arrays.toString(goods)
                + '}';
    }
}