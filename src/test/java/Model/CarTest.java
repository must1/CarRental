package Model;


import car.rental.model.Car;
import car.rental.model.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private static Car car = new Car();

    @Test
    void getBrand() {
        car.setBrand("Opel");
        assertEquals("Opel", car.getBrand());
    }

    @Test
    void getProductionYear() {
        car.setProductionYear("1998");
        assertEquals("1998", car.getProductionYear());
    }

    @Test
    void getEngineCapacity() {
        car.setEngineCapacity("2.0");
        assertEquals("2.0", car.getEngineCapacity());
    }

    @Test
    void getDayPrice() {
        car.setDayPrice(20);
        assertEquals(20, car.getDayPrice());
    }

    @Test
    void getAvailable() {
        car.setAvailable("1");
        assertEquals("1", car.getAvailable());
    }

    @Test
    void getClientNumber() {
        Client client = new Client();
        client.setClientNumber(22);
        assertEquals(22, client.getClientNumber());
    }


}