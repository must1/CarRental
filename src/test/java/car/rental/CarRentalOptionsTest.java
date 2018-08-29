/*
package car.rental;

import car.rental.repositories.MySQLCarStorage;
import car.rental.repositories.MySQLClientStorage;
import car.rental.repositories.MySQLRentalStorage;
import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.CarRental;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarRentalOptionsTest {

    @Mock
    private MySQLRentalStorage mySQLRentalStorageMock;
    @Mock
    private MySQLCarStorage mySQLCarStorageMock;
    @Mock
    private MySQLClientStorage mySQLClientStorageMock;
    private CarRentalOptions carRentalOptions;
    private Client client;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        carRentalOptions = new CarRentalOptions(mySQLClientStorageMock, mySQLCarStorageMock, mySQLRentalStorageMock);
    }

    @Test
    public void getAllClients() throws SQLException {
        client = new Client();
        client.setClientNumber(1);
        client.setCity("California");
        client.setHouseNumber(2);
        client.setRentDate("20.02");
        client.setSurname("Green");
        client.setName("John");
        client.setPeselNumber(1111);
        client.setStreet("Green");
        List<Client> listOfClients = new ArrayList<Client>();
        listOfClients.add(client);

        when(mySQLClientStorageMock.getAllClients()).thenReturn(listOfClients);

        String actual = carRentalOptions.getFullInfoAboutClients();

        String expected = ("\nName: " + client.getName()
                + "\nSurname: " + client.getSurname()
                + "\nStreet: " + client.getStreet()
                + "\nHouse number: " + client.getHouseNumber()
                + "\nCity: " + client.getCity()
                + "\nPesel Number: " + client.getPeselNumber()
                + "\nRent Date: " + client.getRentDate()
                + "\nClient number: " + client.getClientNumber()
                + "\n-----------------");

        assertEquals(expected, actual);
    }

    @Test
    public void getFullInfoAboutCars() throws SQLException {
        Car car = new Car();
        car.setAvailable("1");
        car.setDayPrice(20);
        car.setEngineCapacity("2.0");
        car.setBrand("Mazda");
        car.setClientNumber(20);

        List<Car> listOfCars = new ArrayList<Car>();
        listOfCars.add(car);

        when(mySQLCarStorageMock.getAllCars()).thenReturn(listOfCars);

        String actual = carRentalOptions.getFullInfoAboutCars();

        String expected = ("\nBrand: " + car.getBrand()
                + "\nProdction Year: " + car.getProductionYear()
                + "\nEngine Capacity: " + car.getEngineCapacity()
                + "\nDay Price: " + car.getDayPrice()
                + "\nAvailable: " + car.getAvailable())
                + "\n-----------------";

        assertEquals(expected, actual);
    }

    @Test
    public void getRentedCars() throws SQLException {
        client = new Client();
        client.setClientNumber(20);
        CarRental rentingACar = new CarRental();
        rentingACar.setName("John");
        rentingACar.setRentDate("20.02");
        rentingACar.setSurname("Kowalski");
        rentingACar.setBrand("Mazda");

        List<CarRental> listOfRentedCars = new ArrayList<CarRental>();
        listOfRentedCars.add(rentingACar);

        when(mySQLRentalStorageMock.getClientRentals(client)).thenReturn(listOfRentedCars);

        String actual = carRentalOptions.getFullInfoAboutRentedCars(client);

        String expected = ("\nBrand: " + rentingACar.getBrand()
                + "\nName: " + rentingACar.getName()
                + "\nSurname: " + rentingACar.getSurname()
                + "\nRent Date: " + rentingACar.getRentDate()
                + "\n-----------------");

        assertEquals(expected, actual);
    }
}
*/
