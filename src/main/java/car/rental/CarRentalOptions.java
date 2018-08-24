package car.rental;

import car.rental.model.Car;
import car.rental.model.Client;
<<<<<<< HEAD
import car.rental.model.RentingACar;
=======
import car.rental.model.CarRental;
>>>>>>> da8ecb03fcd3a9a2ae74e4dbae27733708c205cc

import java.sql.SQLException;
import java.util.List;

class CarRentalOptions {
    private CarRentalStorage storage;
    private StringBuilder sb;

    CarRentalOptions(CarRentalStorage storage) {
        this.storage = storage;
    }

    void createNewCustomer(Client client) throws SQLException {
        storage.addClient(client);
    }

    void createNewCar(Car car) throws SQLException {
        storage.addNewCar(car);
    }

    void makeCarUnavailable(Car car) throws SQLException {
        storage.makeCarUnavailable(car);
    }

    void makeCarAvailable(Car car) throws SQLException {
        storage.makeCarAvailable(car);
    }

    void rentACar(CarRental rentingACar) throws SQLException {
        storage.rentACar(rentingACar);
    }

    String getFullInfoAboutCars() throws SQLException {
        List<Car> listOfCars = storage.getAllCars();
        sb = new StringBuilder();

        for (Car carsFullInfo : listOfCars)
            sb.append(String.valueOf(carsFullInfo));

        return sb.toString();
    }

    String getFullInfoAboutRentedCars(Client client) throws SQLException {
<<<<<<< HEAD
        List<RentingACar> listOfRentedCars = storage.getRentedCars(client);
        sb = new StringBuilder();

        for (RentingACar rentedCarsFullInfo : listOfRentedCars)
=======
        List<CarRental> listOfRentedCars = storage.getRentedCars(client);
        sb = new StringBuilder();

        for (CarRental rentedCarsFullInfo : listOfRentedCars)
>>>>>>> da8ecb03fcd3a9a2ae74e4dbae27733708c205cc
            sb.append(String.valueOf(rentedCarsFullInfo));

        return sb.toString();
    }

    String getFullInfoAboutClients() throws SQLException {
        List<Client> listOfClients = storage.getAllCustomers();
        sb = new StringBuilder();

        for (Client clientFullInfo : listOfClients)
            sb.append(String.valueOf(clientFullInfo));

        return sb.toString();
    }


    void returnACar(Car car) throws SQLException {
        storage.returnACar(car);
    }
}