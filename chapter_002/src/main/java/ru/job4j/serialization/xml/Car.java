package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Car {
    private final boolean electricCar;
    private final int maxSpeed;
    private final String model;
    private final Passenger passenger;
    private final String[] additions;

    public Car(boolean electricCar, int maxSpeed, String model, Passenger passenger, String[] additions) {
        this.electricCar = electricCar;
        this.maxSpeed = maxSpeed;
        this.model = model;
        this.passenger = passenger;
        this.additions = additions;
    }

    @Override
    public String toString() {
        return "Car{"
                + "electricCar=" + electricCar
                + ", maxSpeed=" + maxSpeed
                + ", model='" + model + '\''
                + ", passenger=" + passenger
                + ", additions=" + Arrays.toString(additions)
                + '}';
    }
}