package car.model;

import car.rental.model.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private static Client client = new Client();

    @Test
    void getName() {
        client.setName("Piotr");
        assertEquals("Piotr",client.getName());
    }

    @Test
    void getSurname() {
        client.setSurname("Kowalski");
        assertEquals("Kowalski",client.getSurname());
    }

    @Test
    void getStreet() {
        client.setStreet("Pipi");
        assertEquals("Pipi",client.getStreet());
    }

    @Test
    void getHouseNumber() {
        client.setHouseNumber(2);
        assertEquals(2,client.getHouseNumber());
    }

    @Test
    void getCity() {
        client.setCity("Warszawa");
        assertEquals("Warszawa",client.getCity());
    }

    @Test
    void getClientNumber() {
        client.setClientNumber(22);
        assertEquals(22, client.getClientNumber());
    }


    @Test
    void getPeselNumber() {
        client.setPeselNumber(1010);
        assertEquals(1010,client.getPeselNumber());
    }

    @Test
    void getRentDate() {
        client.setRentDate("20.02.1991");
        assertEquals("20.02.1991",client.getRentDate());
    }
}