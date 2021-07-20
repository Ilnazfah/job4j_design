package ru.job4j.serialization.xml;

public class Passenger {
    private final String passengerType;
    private final int weight;

    public Passenger(String passengerType, int weight) {
        this.passengerType = passengerType;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Passenger{"
                + "passengerType='" + passengerType + '\''
                + ", weight=" + weight
                + '}';
    }
}