package CarRental;

import car.rental.CarRentalOptions;
import car.rental.CarRentalStorage;
import car.rental.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class CarRentalOptionsTest {

    @Mock
    CarRentalStorage carRentalStorageMock;

    @Test
    void createNewCustomer() throws SQLException {
        carRentalStorageMock = mock(CarRentalStorage.class);
        CarRentalOptions carRentalOptions = new CarRentalOptions(carRentalStorageMock);
        Client client = new Client();

        List<Client> listOfClients = new ArrayList<Client>();
        listOfClients.add(client);
        when(carRentalStorageMock.getAllCustomers()).thenReturn(listOfClients);

        carRentalOptions.createNewCustomer(client);

        verify(carRentalStorageMock).addClient(client);

        assertTrue(carRentalStorageMock.getAllCustomers().contains(client));
    }
}