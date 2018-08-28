package car.rental.DB.CarRentalInterfaces;

import car.rental.model.Car;
import car.rental.model.CarRental;

import java.sql.SQLException;
import java.util.List;

public interface CarStorageInterface {
    List<Car> getAllCars() throws SQLException;

    boolean addNewCar(Car car) throws SQLException;

    boolean makeCarUnavailable(Car car) throws SQLException;

    boolean makeCarAvailable(Car car) throws SQLException;
}
