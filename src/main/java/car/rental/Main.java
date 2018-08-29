package car.rental;

import car.rental.repository.MySQLCarStorage;
import car.rental.repository.MySQLClientStorage;
import car.rental.repository.MySQLRentalStorage;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        MySQLClientStorage mySQLClientStorage = new MySQLClientStorage();
        MySQLCarStorage mySQLCarStorage = new MySQLCarStorage();
        MySQLRentalStorage mySQLRentalStorage = new MySQLRentalStorage();
        CarRentalOptions carRentalOptions = new CarRentalOptions(mySQLClientStorage, mySQLCarStorage, mySQLRentalStorage);
        CarRentalEngine carRentalEngine = new CarRentalEngine(carRentalOptions);
        carRentalEngine.startCarRental();
    }
}
