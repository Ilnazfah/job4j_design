package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "passenger")
public class Passenger {
    @XmlAttribute
    private String passengerType;
    @XmlAttribute
    private int weight;

    public Passenger() {
    }

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