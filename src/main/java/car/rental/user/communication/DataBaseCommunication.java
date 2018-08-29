package car.rental.user.communication;

import car.rental.repository.CarStorageInterface;
import car.rental.repository.ClientStorageInterface;
import car.rental.repository.RentalStorageInterface;
import car.rental.model.Car;
import car.rental.model.CarRental;
import car.rental.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;


public class DataBaseCommunication {
    private ClientStorageInterface clientStorage;
    private CarStorageInterface carStorage;
    private RentalStorageInterface rentalStorage;
    private Logger logger;

    public DataBaseCommunication(ClientStorageInterface clientStorage, CarStorageInterface carStorage, RentalStorageInterface rentalStorage) {
        this.clientStorage = clientStorage;
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
        logger = LoggerFactory.getLogger(DataBaseCommunication.class);
    }

    public void executeAddClientMessage(Client client) throws SQLException {
        boolean isTrue = clientStorage.addClient(client);
        if (isTrue) {
            logger.info("Account was created");
        } else {
            logger.info("Account was not created");
        }
    }

    public void executeMakeCarAvailableMessage(Car car) throws SQLException {
        if (carStorage.makeCarAvailable(car)) {
            logger.info("Car was made available");
        } else {
            logger.info("Car was not made available");
        }
    }

    public void executeMakeCarUnvaliableMessage(Car car) throws SQLException {
        if (carStorage.makeCarUnavailable(car)) {
            logger.info("Car was made unvaliable");
        } else {
            logger.info("Car was not made unvaliable");
        }
    }

    public void executeCreateCarMessage(Car car) throws SQLException {
        if (carStorage.addNewCar(car)) {
            logger.info("Car was created");
        } else {
            logger.info("Car was not created");
        }
    }

    public void executeCarRentalMessage(CarRental carRental) throws SQLException {
        if (rentalStorage.rentACar(carRental)) {
            logger.info("Car was rented");
        } else {
            logger.info("Car was not rented");
        }
    }

    public void executeReturnCarMessage(Car car) throws SQLException {
        if (rentalStorage.returnACar(car)) {
            logger.info("Car was returned");
        } else {
            logger.info("Car was not returned");
        }
    }
}