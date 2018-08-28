package car.rental;

import car.rental.DB.MySQLCarStorage;
import car.rental.DB.MySQLClientStorage;
import car.rental.DB.MySQLRentalStorage;

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
