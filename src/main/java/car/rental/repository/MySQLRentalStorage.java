package car.rental.repository;

import car.rental.model.Car;
import car.rental.model.CarRental;
import car.rental.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class MySQLRentalStorage implements RentalStorageInterface {

    private Connection connection;

    public MySQLRentalStorage() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalcar?autoReconnect=true&serverTimezone=" + TimeZone.getDefault().getID(), "root", "9234355q");
    }

    @Override
    public List<CarRental> getClientRentals(Client client) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM rentcar WHERE clientNumber=?");
        preparedStatement.setInt(1, client.getClientNumber());
        ResultSet result = preparedStatement.executeQuery();

        List<CarRental> rentedCars = new ArrayList<CarRental>();
        while (result.next()) {
            CarRental rentingACar = new CarRental();
            rentingACar.setBrand(result.getString("brand"));
            rentingACar.setSurname(result.getString("surname"));
            rentingACar.setRentDate(result.getString("rentDate"));
            rentingACar.setName(result.getString("name"));

            rentedCars.add(rentingACar);
        }
        return rentedCars;
    }

    @Override
    public boolean rentACar(CarRental rentingACar) throws SQLException {
        int count = 0;
        boolean isAvailable = true;

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(0) FROM car WHERE available='1' AND brand=?");
        preparedStatement.setString(1, rentingACar.getBrand());
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            count = result.getInt(1);
        }
        if (count < 1)
            isAvailable = false;

        if (!isAvailable)
            return false;

        preparedStatement = connection.prepareStatement("insert into rentcar" + "(brand,namee,surname,rentDate,clientNumber)" + "values(?,?,?,?,?)");
        preparedStatement.setString(1, rentingACar.getBrand());
        preparedStatement.setString(2, rentingACar.getName());
        preparedStatement.setString(3, rentingACar.getSurname());
        preparedStatement.setString(4, rentingACar.getRentDate());
        preparedStatement.setInt(5, rentingACar.getClientNumber());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("update car " + " set available='0'" + " where brand= ? ");
        preparedStatement.setString(1, rentingACar.getBrand());
        preparedStatement.executeUpdate();

        return true;
    }

    @Override
    public boolean returnACar(Car car) throws SQLException {
        if (car == null)
            return false;

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE from rentcar WHERE brand=? AND clientNumber=?");
        preparedStatement.setString(1, car.getBrand());
        preparedStatement.setInt(2, car.getClientNumber());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("update car " + " set available='1'" + " where brand=?");
        preparedStatement.setString(1, car.getBrand());
        preparedStatement.executeUpdate();
        return true;
    }
}
