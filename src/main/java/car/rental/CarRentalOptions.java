package car.rental;

import car.rental.DB.MySQLCarStorage;
import car.rental.DB.MySQLClientStorage;
import car.rental.DB.MySQLRentalStorage;
import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.CarRental;

import java.sql.SQLException;
import java.util.List;

class CarRentalOptions {
    private MySQLClientStorage mySQLClientStorage;
    private MySQLCarStorage mySQLCarStorage;
    private MySQLRentalStorage mySQLRentalStorage;
    private StringBuilder sb;

    CarRentalOptions(MySQLClientStorage mySQLClientStorage, MySQLCarStorage mySQLCarStorage, MySQLRentalStorage mySQLRentalStorage) {
        this.mySQLCarStorage = mySQLCarStorage;
        this.mySQLClientStorage = mySQLClientStorage;
        this.mySQLRentalStorage = mySQLRentalStorage;
    }


    void createNewClient(Client client) throws SQLException {
        mySQLClientStorage.addClient(client);
    }

    void createNewCar(Car car) throws SQLException {
        mySQLCarStorage.addNewCar(car);
    }

    void makeCarUnavailable(Car car) throws SQLException {
        mySQLCarStorage.makeCarUnavailable(car);
    }

    void makeCarAvailable(Car car) throws SQLException {
        mySQLCarStorage.makeCarAvailable(car);
    }

    void rentACar(CarRental rentingACar) throws SQLException {
        mySQLRentalStorage.rentACar(rentingACar);
    }

    String getFullInfoAboutCars() throws SQLException {
        List<Car> cars = mySQLCarStorage.getAllCars();
        sb = new StringBuilder();

        for (Car carsFullInfo : cars)
            sb.append(String.valueOf(carsFullInfo));

        return sb.toString();
    }

    String getFullInfoAboutRentedCars(Client client) throws SQLException {
        List<CarRental> rentedCars = mySQLRentalStorage.getClientRentals(client);
        sb = new StringBuilder();

        for (CarRental rentedCarsFullInfo : rentedCars)
            sb.append(String.valueOf(rentedCarsFullInfo));

        return sb.toString();
    }

    String getFullInfoAboutClients() throws SQLException {
        List<Client> clients = mySQLClientStorage.getAllClients();
        sb = new StringBuilder();

        for (Client clientFullInfo : clients)
            sb.append(String.valueOf(clientFullInfo));

        return sb.toString();
    }

    void returnACar(Car car) throws SQLException {
        mySQLRentalStorage.returnACar(car);
    }

}