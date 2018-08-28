package car.rental.DB.CarRentalInterfaces;

import car.rental.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientStorageInterface {
    boolean addClient(Client client) throws SQLException;

    List<Client> getAllClients() throws SQLException;
}
