package car.rental.db;

import car.rental.CarRentalStorage;
import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.RentingACar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class CarRentalSQLDatabase implements CarRentalStorage {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    public CarRentalSQLDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalcar?autoReconnect=true&serverTimezone=" + TimeZone.getDefault().getID(), "root", "9234355q");
        statement = connection.createStatement();
    }

    @Override
    public void addClient(Client client) throws SQLException {
        preparedStatement = connection.prepareStatement("insert into client" + "(namee, surname, street,houseNumber,city,peselNumber,rentDate, clientNumber)" + "values(?,?,?,?,?,?,?,?)");

        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getSurname());
        preparedStatement.setString(3, client.getStreet());
        preparedStatement.setInt(4, client.getHouseNumber());
        preparedStatement.setString(5, client.getCity());
        preparedStatement.setLong(6, client.getPeselNumber());
        preparedStatement.setString(7, client.getRentDate());
        preparedStatement.setInt(8, client.getClientNumber());

        preparedStatement.executeUpdate();
    }


    @Override
    public void addNewCar(Car car) throws SQLException {
        preparedStatement = connection.prepareStatement("insert into car" + "(brand, productionYear, engineCapacity,dayPrice,available)" + "values(?,?,?,?,?)");

        preparedStatement.setString(1, car.getBrand());
        preparedStatement.setString(2, car.getProductionYear());
        preparedStatement.setString(3, car.getEngineCapacity());
        preparedStatement.setInt(4, car.getDayPrice());
        preparedStatement.setString(5, car.getAvailable());

        preparedStatement.executeUpdate();

    }

    @Override
    public void rentACar(RentingACar rentingACar) throws SQLException {
        int count = 0;
        boolean isAvailable = true;
        {
            preparedStatement = connection.prepareStatement("SELECT COUNT(0) FROM car WHERE available='1' AND brand=?");
            preparedStatement.setString(1, rentingACar.getBrand());
            result = preparedStatement.executeQuery();
        }
        while (result.next()) {
            count = result.getInt(1);
        }
        if (count < 1)
            isAvailable = false;

        if (isAvailable) {
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
            System.out.println("Car was rented!");
        } else {
            System.out.println("There is no " + rentingACar.getBrand() + " in our car or all types of this car are rented!");
        }

    }

    @Override
    public void returnACar(Car car) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE from rentcar WHERE brand=? AND clientNumber=?");
        preparedStatement.setString(1, car.getBrand());
        preparedStatement.setInt(2, car.getClientNumber());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("update car " + " set available='1'" + " where brand=?");
        preparedStatement.setString(1, car.getBrand());
        preparedStatement.executeUpdate();

    }

    @Override
    public void makeCarUnavailable(Car car) throws SQLException {
        int count = 0;
        boolean isAvailable = true;
        {
            preparedStatement = connection.prepareStatement("SELECT COUNT(0) FROM car WHERE brand=? AND productionYear=? ");
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getProductionYear());
            result = preparedStatement.executeQuery();
        }
        while (result.next()) {
            count = result.getInt(1);
        }
        if (count < 1)
            isAvailable = false;

        if (isAvailable) {
            preparedStatement = connection.prepareStatement("update car " + " set available='0'" + " where brand=? AND productionYear=?");
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getProductionYear());
            preparedStatement.executeUpdate();
            System.out.println(car.getBrand() + " was made unavailable");
        } else {
            System.out.println("No " + car.getBrand() + " in system!");
        }

    }

    @Override
    public void makeCarAvailable(Car car) throws SQLException {
        int count = 0;
        boolean isAvailable = true;
        {
            preparedStatement = connection.prepareStatement("SELECT COUNT(0) FROM car WHERE brand=? AND productionYear=? ");
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getProductionYear());
            result = preparedStatement.executeQuery();
        }
        while (result.next()) {
            count = result.getInt(1);
        }
        if (count < 1)
            isAvailable = false;

        if (isAvailable) {
            preparedStatement = connection.prepareStatement("update car " + " set available='1'" + " where brand=? AND productionYear=?");
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getProductionYear());
            preparedStatement.executeUpdate();
            System.out.println(car.getBrand() + " was made unavailable");
        } else {
            System.out.println("No " + car.getBrand() + " in system!");
        }
    }

    @Override
    public List<Client> getAllCustomers() throws SQLException {
        List<Client> listOfClients = new ArrayList<Client>();

        String sql = "SELECT * FROM `client`";
        result = statement.executeQuery(sql);

        while (result.next()) {
            Client client = new Client();
            client.setName(result.getString("namee"));
            client.setSurname(result.getString("surname"));
            client.setStreet(result.getString("street"));
            client.setPeselNumber(result.getLong("peselNumber"));
            client.setRentDate(result.getString("rentDate"));
            client.setCity(result.getString("city"));
            client.setHouseNumber(result.getInt("houseNumber"));
            client.setClientNumber(result.getInt("clientNumber"));

            listOfClients.add(client);
        }

        return listOfClients;
    }

    @Override
    public void populateTableRent(Client client) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM rentcar WHERE clientNumber=?");
        preparedStatement.setInt(1, client.getClientNumber());
        result = preparedStatement.executeQuery();

        while (result.next()) {

            String brand = result.getString("brand");
            String name = result.getString("namee");
            String surname = result.getString("surname");
            String rentDate = result.getString("rentDate");
            System.out.println("----------------------------");
            System.out.printf("Brand:" + brand + "\nName:" + name + "\nSurname:" + surname + "\nDate of rental:" + rentDate + "\n");
            System.out.println("----------------------------");
        }

    }

    @Override
    public void populateTableViewCars(Car car) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM car WHERE dayPrice > ?");
        preparedStatement.setDouble(1, car.getDayPrice());
        result = preparedStatement.executeQuery();

        while (result.next()) {

            String brand = result.getString("brand");
            String productionYear = result.getString("productionYear");
            String engineCapacity = result.getString("engineCapacity");
            String dayPrice = result.getString("dayPrice");
            String available = result.getString("available");
            System.out.println("----------------------------");
            System.out.printf("Brand:" + brand + "\nEngine Capacity:" + engineCapacity + "\nDayPrice:" + dayPrice + "\nProduction Year:" + productionYear + "\navailable:" + available + "\n");
            System.out.println("----------------------------");
        }

    }
}
