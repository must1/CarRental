package car.rental;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        CarRentalEngine carRentalEngine = new CarRentalEngine();
        carRentalEngine.startCarRental();

    }
}
