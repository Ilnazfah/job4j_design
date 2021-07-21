package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean electricCar;
    @XmlAttribute
    private int maxSpeed;
    @XmlAttribute
    private String model;
    private Passenger passenger;
    @XmlElementWrapper(name = "additions")
    @XmlElement(name = "addition")
    private String[] additions;

    public Car() {
    }

    public Car(boolean electricCar, int maxSpeed, String model, Passenger passenger, String... additions) {
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