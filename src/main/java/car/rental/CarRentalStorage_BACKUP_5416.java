package car.rental;

import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.CarRental;

import java.sql.SQLException;
import java.util.List;

public interface CarRentalStorage {

    void addClient(Client client) throws SQLException;

    void addNewCar(Car car) throws SQLException;

    void rentACar(CarRental rentingACar) throws SQLException;

    void returnACar(Car car) throws SQLException;

    void makeCarUnavailable(Car car) throws SQLException;

    void makeCarAvailable(Car car) throws SQLException;

    List<Client> getAllCustomers() throws SQLException;

<<<<<<< HEAD
    List<RentingACar> getRentedCars(Client client) throws SQLException;
=======
    List<CarRental> getRentedCars(Client client) throws SQLException;
>>>>>>> da8ecb03fcd3a9a2ae74e4dbae27733708c205cc

    List<Car> getAllCars() throws SQLException;
}