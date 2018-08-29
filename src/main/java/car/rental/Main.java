package car.rental;

import car.rental.repositories.MySQLCarStorage;
import car.rental.repositories.MySQLClientStorage;
import car.rental.repositories.MySQLRentalStorage;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        MySQLClientStorage mySQLClientStorage = new MySQLClientStorage();
        MySQLCarStorage mySQLCarStorage = new MySQLCarStorage();
        MySQLRentalStorage mySQLRentalStorage = new MySQLRentalStorage();
        CarRentalEngine carRentalEngine = new CarRentalEngine(mySQLClientStorage, mySQLCarStorage, mySQLRentalStorage);
        carRentalEngine.startCarRental();
    }
}
