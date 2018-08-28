package car.rental.user.communication;

import car.rental.DB.CarRentalInterfaces.CarStorageInterface;
import car.rental.DB.CarRentalInterfaces.ClientStorageInterface;
import car.rental.DB.CarRentalInterfaces.RentalStorageInterface;
import car.rental.DB.MySQLCarStorage;
import car.rental.DB.MySQLClientStorage;
import car.rental.DB.MySQLRentalStorage;
import car.rental.model.Car;
import car.rental.model.CarRental;
import car.rental.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;


public class DataBaseCommunication {

    private RentalStorageInterface mySQLRentalStorage = new MySQLRentalStorage();
    private CarStorageInterface mySQLCarStorage = new MySQLCarStorage();
    private ClientStorageInterface mySQLClientStorage = new MySQLClientStorage();
    private Logger logger;

    public DataBaseCommunication() throws SQLException {
        logger = LoggerFactory.getLogger(DataBaseCommunication.class);
    }

    public void executeAddClientMessage(Client client) throws SQLException {
        if (mySQLClientStorage.addClient(client)) {
            logger.info("Account was created");
        } else {
            logger.info("Account was not created");
        }
    }

    public void executeMakeCarAvailableMessage(Car car) throws SQLException {
        if (mySQLCarStorage.makeCarAvailable(car)) {
            logger.info("Car was made available");
        } else {
            logger.info("Car was not made available");
        }
    }

    public void executeMakeCarUnvaliableMessage(Car car) throws SQLException {
        if (mySQLCarStorage.makeCarUnavailable(car)) {
            logger.info("Car was made unvaliable");
        } else {
            logger.info("Car was not made unvaliable");
        }
    }

    public void executeCreateCarMessage(Car car) throws SQLException {
        if (mySQLCarStorage.addNewCar(car)) {
            logger.info("Car was created");
        } else {
            logger.info("Car was not created");
        }
    }

    public void executeCarRentalMessage(CarRental carRental) throws SQLException {
        if (mySQLRentalStorage.rentACar(carRental)) {
            logger.info("Car was rented");
        } else {
            logger.info("Car was not rented");
        }
    }

    public void executeReturnCarMessage(Car car) throws SQLException {
        if (mySQLRentalStorage.returnACar(car)) {
            logger.info("Car was returned");
        } else {
            logger.info("Car was not returned");
        }
    }
}