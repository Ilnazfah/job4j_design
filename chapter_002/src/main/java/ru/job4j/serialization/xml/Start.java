package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Start {
    public static void main(String[] args) throws JAXBException {
        Car car = new Car(true,
                322,
                "TeslaModelS",
                new Passenger("driver", 63),
                "audiosystem", "climatecontrol");
        String xml = marshaller(car);
        unMarshaller(xml);

    }

    public static String marshaller(Car car) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    public static void unMarshaller(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Car rsl = (Car) unmarshaller.unmarshal(reader);
            System.out.println(rsl);
        }
    }
}