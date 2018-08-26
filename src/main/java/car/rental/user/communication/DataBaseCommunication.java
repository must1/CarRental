package car.rental.user.communication;

import car.rental.DB.CarRentalSQLDatabase;
import car.rental.model.Car;
import car.rental.model.CarRental;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;


public class DataBaseCommunication {

    private CarRentalSQLDatabase carRentalSQLDatabase = new CarRentalSQLDatabase();
    private Logger logger;

    public DataBaseCommunication() throws SQLException {
        logger = LoggerFactory.getLogger(DataBaseCommunication.class);
    }

    public void executeMakeCarAvailableMessage(Car car) throws SQLException {
        if (carRentalSQLDatabase.makeCarAvailable(car)) {
            logger.info("Car was made available");
        } else {
            logger.info("Car was not made available");
        }
    }

    public void executeMakeCarUnvaliableMessage(Car car) throws SQLException {
        if (carRentalSQLDatabase.makeCarUnavailable(car)) {
            logger.info("Car was made unvaliable");
        } else {
            logger.info("Car was not made unvaliable");
        }
    }

    public void executeCreateCarMessage(Car car) throws SQLException {
        if (carRentalSQLDatabase.addNewCar(car)) {
            logger.info("Car was created");
        } else {
            logger.info("Car was not created");
        }
    }

    public void executeCarRentalMessage(CarRental carRental) throws SQLException {
        if (carRentalSQLDatabase.rentACar(carRental)) {
            logger.info("Car was rented");
        } else {
            logger.info("Car was not rented");
        }
    }

    public void executeReturnCarMessage(Car car) throws SQLException {
        if (carRentalSQLDatabase.returnACar(car)) {
            logger.info("Car was returned");
        } else {
            logger.info("Car was not returned");
        }
    }
}