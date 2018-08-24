package car.rental.data.getters;

import car.rental.model.Car;
import car.rental.model.Client;
<<<<<<< HEAD
import car.rental.model.RentingACar;
=======
import car.rental.model.CarRental;
>>>>>>> da8ecb03fcd3a9a2ae74e4dbae27733708c205cc
import org.junit.jupiter.api.Test;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.*;
class ClientDataGetterTest {

    private ClientDataGetter clientDataGetter = new ClientDataGetter();

    @Test
    void createClient() {
<<<<<<< HEAD
        Scanner scanner = new Scanner("Peter\nParker\nCity\n1\nGreen\n1234\n20.02");
=======
        Scanner scanner = new Scanner("Peter\nParker\nCity\nGreen\n20.02\n1\n1234");
>>>>>>> da8ecb03fcd3a9a2ae74e4dbae27733708c205cc
        Client client = clientDataGetter.createClient(scanner);

        assertNotNull(client);

        assertEquals("Peter", client.getName());
        assertEquals("Parker", client.getSurname());
        assertEquals("City", client.getCity());
<<<<<<< HEAD
        assertEquals(1, client.getHouseNumber());
        assertEquals("Green", client.getStreet());
        assertEquals(1234, client.getPeselNumber());
        assertEquals("20.02", client.getRentDate());
=======
        assertEquals("Green", client.getStreet());
        assertEquals("20.02", client.getRentDate());
        assertEquals(1, client.getHouseNumber());
        assertEquals(1234, client.getPeselNumber());
>>>>>>> da8ecb03fcd3a9a2ae74e4dbae27733708c205cc
    }

    @Test
    void rentACar() {
        Scanner scanner = new Scanner("Mazda\nPeter\nParker\n20.02\n1234");
<<<<<<< HEAD
        RentingACar rentingACar = clientDataGetter.rentACar(scanner);

        assertNotNull(rentingACar);

        assertEquals("Mazda", rentingACar.getBrand());
        assertEquals("Peter", rentingACar.getName());
        assertEquals("Parker", rentingACar.getSurname());
        assertEquals("20.02", rentingACar.getRentDate());
        assertEquals(1234, rentingACar.getClientNumber());
=======
        CarRental carRental = clientDataGetter.rentACar(scanner);

        assertNotNull(carRental);

        assertEquals("Mazda", carRental.getBrand());
        assertEquals("Peter", carRental.getName());
        assertEquals("Parker", carRental.getSurname());
        assertEquals("20.02", carRental.getRentDate());
        assertEquals(1234, carRental.getClientNumber());
>>>>>>> da8ecb03fcd3a9a2ae74e4dbae27733708c205cc
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