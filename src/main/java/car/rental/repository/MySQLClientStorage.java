package car.rental.repository;

import car.rental.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class MySQLClientStorage implements ClientStorageInterface {
    private Connection connection;

    public MySQLClientStorage() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalcar?autoReconnect=true&serverTimezone=" + TimeZone.getDefault().getID(), "root", "9234355q");
    }

    @Override
    public boolean addClient(Client client) throws SQLException {
        if (client == null)
            return false;
        PreparedStatement preparedStatement = connection.prepareStatement("insert into client" + "(namee, surname, street,houseNumber,city,peselNumber,rentDate, clientNumber)" + "values(?,?,?,?,?,?,?,?)");

        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getSurname());
        preparedStatement.setString(3, client.getStreet());
        preparedStatement.setInt(4, client.getHouseNumber());
        preparedStatement.setString(5, client.getCity());
        preparedStatement.setLong(6, client.getPeselNumber());
        preparedStatement.setString(7, client.getRentDate());
        preparedStatement.setInt(8, client.getClientNumber());

        preparedStatement.executeUpdate();

        return true;
    }

    @Override
    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<Client>();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM `client`";
        ResultSet result = statement.executeQuery(sql);

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

            clients.add(client);
        }

        return clients;
    }
}
