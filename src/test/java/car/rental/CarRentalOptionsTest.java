package car.rental;

import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.RentingACar;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarRentalOptionsTest {

    @Mock
    private CarRentalStorage carRentalStorageMock;
    private CarRentalOptions carRentalOptions;
    private Client client;
    private Car car;
    private RentingACar rentingACar;

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
        rentingACar = new RentingACar();
        carRentalOptions.rentACar(rentingACar);

        verify(carRentalStorageMock).rentACar(rentingACar);
    }

   /* @Test
    public void getAllCustomers() throws SQLException
    {
        client = new Client();
        List<Client> listOfClients = new ArrayList<Client>();
        listOfClients.add(client);
        when(carRentalStorageMock.getAllCustomers()).thenReturn(listOfClients);

        verify(carRentalStorageMock).getAllCustomers();
    }*/
}
