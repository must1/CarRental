package car.rental.repositories;

import car.rental.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class MySQLCarStorage implements CarStorageInterface {
    private Connection connection;

    public MySQLCarStorage() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalcar?autoReconnect=true&serverTimezone=" + TimeZone.getDefault().getID(), "root", "9234355q");
    }

    @Override
    public List<Car> getAllCars() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM car");
        ResultSet result = preparedStatement.executeQuery();
        List<Car> cars = new ArrayList<Car>();
        while (result.next()) {
            Car car = new Car();
            car.setBrand(result.getString("brand"));
            car.setEngineCapacity(result.getString("engineCapacity"));
            car.setProductionYear(result.getString("engineCapacity"));
            car.setDayPrice(result.getInt("dayPrice"));
            car.setAvailable(result.getString("available"));

            cars.add(car);
        }
        return cars;
    }

    @Override
    public boolean addNewCar(Car car) throws SQLException {
        if (car == null)
            return false;

        PreparedStatement preparedStatement = connection.prepareStatement("insert into car" + "(brand, productionYear, engineCapacity,dayPrice,available)" + "values(?,?,?,?,?)");

        preparedStatement.setString(1, car.getBrand());
        preparedStatement.setString(2, car.getProductionYear());
        preparedStatement.setString(3, car.getEngineCapacity());
        preparedStatement.setInt(4, car.getDayPrice());
        preparedStatement.setString(5, car.getAvailable());

        preparedStatement.executeUpdate();

        return true;
    }

    private boolean doesCarExist(Car car) throws SQLException {
        int count = 0;

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(0) FROM car WHERE brand=? AND productionYear=? ");
        preparedStatement.setString(1, car.getBrand());
        preparedStatement.setString(2, car.getProductionYear());
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            count = result.getInt(1);
        }

        return count < 1;
    }


    @Override
    public boolean makeCarUnavailable(Car car) throws SQLException {
        if (doesCarExist(car))
            return false;

        PreparedStatement preparedStatement = connection.prepareStatement("update car " + " set available='0'" + " where brand=? AND productionYear=?");
        preparedStatement.setString(1, car.getBrand());
        preparedStatement.setString(2, car.getProductionYear());
        preparedStatement.executeUpdate();

        return true;
    }

    @Override
    public boolean makeCarAvailable(Car car) throws SQLException {
        if (doesCarExist(car))
            return false;

        PreparedStatement preparedStatement = connection.prepareStatement("update car " + " set available='1'" + " where brand=? AND productionYear=?");
        preparedStatement.setString(1, car.getBrand());
        preparedStatement.setString(2, car.getProductionYear());
        preparedStatement.executeUpdate();

        return true;
    }
}
