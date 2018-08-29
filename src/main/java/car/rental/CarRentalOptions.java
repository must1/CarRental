package car.rental;

import car.rental.repository.*;
import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.CarRental;

import java.sql.SQLException;
import java.util.List;

class CarRentalOptions {
    private StringBuilder sb;
    private ClientStorageInterface clientStorage;
    private CarStorageInterface carStorage;
    private RentalStorageInterface rentalStorage;

    CarRentalOptions(ClientStorageInterface clientStorage, CarStorageInterface carStorage, RentalStorageInterface rentalStorage) {
        this.clientStorage = clientStorage;
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }


    void createNewClient(Client client) throws SQLException {
        clientStorage.addClient(client);
    }

    void createNewCar(Car car) throws SQLException {
        carStorage.addNewCar(car);
    }

    void makeCarUnavailable(Car car) throws SQLException {
        carStorage.makeCarUnavailable(car);
    }

    void makeCarAvailable(Car car) throws SQLException {
        carStorage.makeCarAvailable(car);
    }

    void rentACar(CarRental rentingACar) throws SQLException {
        rentalStorage.rentACar(rentingACar);
    }

    String getFullInfoAboutCars() throws SQLException {
        List<Car> cars = carStorage.getAllCars();
        sb = new StringBuilder();

        for (Car carsFullInfo : cars)
            sb.append(String.valueOf(carsFullInfo));

        return sb.toString();
    }

    String getFullInfoAboutRentedCars(Client client) throws SQLException {
        List<CarRental> rentedCars = rentalStorage.getClientRentals(client);
        sb = new StringBuilder();

        for (CarRental rentedCarsFullInfo : rentedCars)
            sb.append(String.valueOf(rentedCarsFullInfo));

        return sb.toString();
    }

    String getFullInfoAboutClients() throws SQLException {
        List<Client> clients = clientStorage.getAllClients();
        sb = new StringBuilder();

        for (Client clientFullInfo : clients)
            sb.append(String.valueOf(clientFullInfo));

        return sb.toString();
    }

    void returnACar(Car car) throws SQLException {
        rentalStorage.returnACar(car);
    }

}