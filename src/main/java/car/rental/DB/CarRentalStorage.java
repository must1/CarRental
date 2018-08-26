package car.rental.DB;

import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.CarRental;

import java.sql.SQLException;
import java.util.List;

public interface CarRentalStorage {

    boolean addClient(Client client) throws SQLException;

    boolean addNewCar(Car car) throws SQLException;

    boolean rentACar(CarRental rentingACar) throws SQLException;

    boolean returnACar(Car car) throws SQLException;

    boolean makeCarUnavailable(Car car) throws SQLException;

    boolean makeCarAvailable(Car car) throws SQLException;

    List<Client> getAllCustomers() throws SQLException;

    List<CarRental> getRentedCars(Client client) throws SQLException;

    List<Car> getAllCars() throws SQLException;
}
