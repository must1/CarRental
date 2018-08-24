package car.rental.data.getters;

import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.CarRental;
import org.junit.jupiter.api.Test;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.*;
class ClientDataGetterTest {

    private ClientDataGetter clientDataGetter = new ClientDataGetter();

    @Test
    void createClient() {
        Scanner scanner = new Scanner("Peter\nParker\nCity\nGreen\n20.02\n1\n1234");
        Client client = clientDataGetter.createClient(scanner);

        assertNotNull(client);

        assertEquals("Peter", client.getName());
        assertEquals("Parker", client.getSurname());
        assertEquals("City", client.getCity());
        assertEquals("Green", client.getStreet());
        assertEquals("20.02", client.getRentDate());
        assertEquals(1, client.getHouseNumber());
        assertEquals(1234, client.getPeselNumber());
    }

    @Test
    void rentACar() {
        Scanner scanner = new Scanner("Mazda\nPeter\nParker\n20.02\n1234");
        CarRental carRental = clientDataGetter.rentACar(scanner);

        assertNotNull(carRental);

        assertEquals("Mazda", carRental.getBrand());
        assertEquals("Peter", carRental.getName());
        assertEquals("Parker", carRental.getSurname());
        assertEquals("20.02", carRental.getRentDate());
        assertEquals(1234, carRental.getClientNumber());
    }

    @Test
    void returnACar() {
        Scanner scanner = new Scanner("Mazda\n12");
        Car car = clientDataGetter.returnACar(scanner);

        assertNotNull(car);

        assertEquals("Mazda", car.getBrand());
        assertEquals(12, car.getClientNumber());
    }


    @Test
    void populateTableRent() {
        Scanner scanner = new Scanner("12");
        Client client = clientDataGetter.populateTableRent(scanner);

        assertNotNull(client);

        assertEquals(12, client.getClientNumber());
    }


}