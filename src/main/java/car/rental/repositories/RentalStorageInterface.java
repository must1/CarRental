package car.rental.repositories;

import car.rental.model.Car;
import car.rental.model.CarRental;
import car.rental.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface RentalStorageInterface {
    List<CarRental> getClientRentals(Client client) throws SQLException;

    boolean rentCar(CarRental rentingACar) throws SQLException;

    boolean returnACar(Car car) throws SQLException;
}
