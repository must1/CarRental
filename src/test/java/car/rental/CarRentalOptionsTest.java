package car.rental;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarRentalOptionsTest {

    @Mock
    private CarRentalStorage carRentalStorageMock;
    private CarRentalOptions carRentalOptions;
    private Client client;
    private Car car;
    private CarRental rentingACar;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        carRentalOptions = new CarRentalOptions(carRentalStorageMock);
    }

    @Test
    public void createNewCustomer() throws SQLException {
        client = new Client();
        carRentalOptions.createNewCustomer(client);

        verify(carRentalStorageMock).addClient(client);
    }

    @Test
    public void returnACar() throws SQLException {
        car = new Car();
        carRentalOptions.returnACar(car);

        verify(carRentalStorageMock).returnACar(car);
    }


    @Test
    public void createNewCar() throws SQLException {
        car = new Car();
        carRentalOptions.createNewCar(car);

        verify(carRentalStorageMock).addNewCar(car);
    }


    @Test
    public void makeCarUnavailable() throws SQLException {
        car = new Car();

        carRentalOptions.makeCarUnavailable(car);
        verify(carRentalStorageMock).makeCarUnavailable(car);
    }

    @Test
    public void makeCarAvailable() throws SQLException {
        car = new Car();

        carRentalOptions.makeCarAvailable(car);
        verify(carRentalStorageMock).makeCarAvailable(car);
    }

    @Test
    public void rentACar() throws SQLException {
        rentingACar = new CarRental();
        carRentalOptions.rentACar(rentingACar);

        verify(carRentalStorageMock).rentACar(rentingACar);
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

        when(carRentalStorageMock.getAllCustomers()).thenReturn(listOfClients);

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
        car = new Car();
        car.setAvailable("1");
        car.setDayPrice(20);
        car.setEngineCapacity("2.0");
        car.setBrand("Mazda");
        car.setClientNumber(20);

        List<Car> listOfCars = new ArrayList<Car>();
        listOfCars.add(car);

        when(carRentalStorageMock.getAllCars()).thenReturn(listOfCars);

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
        rentingACar = new CarRental();
        rentingACar.setName("John");
        rentingACar.setRentDate("20.02");
        rentingACar.setSurname("Kowalski");
        rentingACar.setBrand("Mazda");

        List<CarRental> listOfRentedCars = new ArrayList<CarRental>();
        listOfRentedCars.add(rentingACar);

        when(carRentalStorageMock.getRentedCars(client)).thenReturn(listOfRentedCars);

        String actual = carRentalOptions.getFullInfoAboutRentedCars(client);

        String expected = ("\nBrand: " + rentingACar.getBrand()
                + "\nName: " + rentingACar.getName()
                + "\nSurname: " + rentingACar.getSurname()
                + "\nRent Date: " + rentingACar.getRentDate()
                + "\n-----------------");

        assertEquals(expected, actual);
    }
}
