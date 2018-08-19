package car.rental;

import car.rental.DB.CarRentalSQLDatabase;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        CarRentalSQLDatabase storage = new CarRentalSQLDatabase();
        CarRentalOptions carRentalOptions = new CarRentalOptions(storage);
        CarRentalEngine carRentalEngine = new CarRentalEngine(carRentalOptions);
        carRentalEngine.startCarRental();

    }
}
