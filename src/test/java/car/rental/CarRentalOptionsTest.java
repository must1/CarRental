package car.rental;

import car.rental.model.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CarRentalOptionsTest {

    @Mock
    private CarRentalStorage carRentalStorageMock;
    private CarRentalOptions carRentalOptions;
    private Client client;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createNewCustomer() throws SQLException {
        carRentalOptions = new CarRentalOptions(carRentalStorageMock);
        client = new Client();
        carRentalOptions.createNewCustomer(client);

        verify(carRentalStorageMock).addClient(client);
    }
}