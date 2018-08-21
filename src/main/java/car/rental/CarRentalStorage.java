package car.rental;

import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.RentingACar;

import java.sql.SQLException;
import java.util.List;

public interface CarRentalStorage {

    void addClient(Client client) throws SQLException;

    void addNewCar(Car car) throws SQLException;

    void rentACar(RentingACar rentingACar) throws SQLException;

    void returnACar(Car car) throws SQLException;

    void makeCarUnavailable(Car car) throws SQLException;

    void makeCarAvailable(Car car) throws SQLException;

    List<Client> getAllCustomers() throws SQLException;

    List<RentingACar> getRentedCars(Client client) throws SQLException;

    List<Car> getAllCars() throws SQLException;
}
