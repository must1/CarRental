package car.rental;

import car.rental.model.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CarRentalOptionsTest {

    @Mock
    private CarRentalStorage carRentalStorageMock;
    private Client client;

    @Before
    public void setup() throws SQLException {
        CarRentalOptions carRentalOptions = new CarRentalOptions(carRentalStorageMock);
        client = new Client();

        carRentalOptions.createNewCustomer(client);

        List<Client> listOfClients = new ArrayList<Client>();
        listOfClients.add(client);
    }

    @Test
    public void createNewCustomer() throws SQLException {

        verify(carRentalStorageMock).addClient(client);

    }
}