package car.rental.data.getters;

import car.rental.model.Car;
import car.rental.model.Client;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class WorkerDataGetterTest {

    private WorkerDataGetter workerDataGetter = new WorkerDataGetter();

    @Test
    void createCar() {
        Scanner scanner = new Scanner("Mazda\n20\n2.0\n1999\n1");
        Car car = workerDataGetter.createCar(scanner);

        assertNotNull(car);

        assertEquals("Mazda",car.getBrand());
        assertEquals(20,car.getDayPrice());
        assertEquals("1999",car.getProductionYear());
        assertEquals("2.0",car.getEngineCapacity());
        assertEquals("1",car.getAvailable());
    }

    @Test
    void makeCarUnavailable() {

        Scanner scanner = new Scanner("Mazda\n1999");
        Car car = workerDataGetter.makeCarUnavailable(scanner);

        assertNotNull(car);

        assertEquals("Mazda",car.getBrand());
        assertEquals("1999",car.getProductionYear());
    }

    @Test
    void makeCarAavailable() {
        Scanner scanner = new Scanner("Mazda\n1998");
        Car car = workerDataGetter.makeCarAavailable(scanner);

        assertNotNull(car);

        assertEquals("Mazda",car.getBrand());
        assertEquals("1998",car.getProductionYear());
    }
}