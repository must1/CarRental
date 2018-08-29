package car.rental;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import car.rental.activities.ClientActivities;
import car.rental.activities.WorkerActivities;
import car.rental.data.getters.ClientDataGetter;
import car.rental.data.getters.WorkerDataGetter;
import car.rental.model.Car;
import car.rental.model.CarRental;
import car.rental.model.Client;
import car.rental.repository.*;
import car.rental.user.communication.DataBaseCommunication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CarRentalEngine {
    private CarRentalOptions carRentalOptions;
    private static final int CLIENT = 1;
    private static final int WORKER = 2;
    private int option;
    private Scanner input = new Scanner(System.in);
    private ClientDataGetter clientDataGetter = new ClientDataGetter();
    private WorkerDataGetter workerDataGetter = new WorkerDataGetter();
    private Logger logger;
    private Car car;
    private DataBaseCommunication dataBaseCommunication;

    CarRentalEngine(CarRentalOptions carRentalOptions) throws SQLException {
        this.carRentalOptions = carRentalOptions;
        logger = LoggerFactory.getLogger(CarRentalEngine.class);
        ClientStorageInterface mySQLClientStorage = new MySQLClientStorage();
        CarStorageInterface mySQLCarStorage = new MySQLCarStorage();
        RentalStorageInterface mySQLRentalStorage = new MySQLRentalStorage();
        dataBaseCommunication = new DataBaseCommunication(mySQLClientStorage, mySQLCarStorage, mySQLRentalStorage);
    }

    void startCarRental() throws SQLException {
        logger.info("Who are you?\n1. Customer\n2. Worker");
        option = input.nextInt();
        try {
            switch (option) {
                case CLIENT:
                    executeClientCase();
                    break;
                case WORKER:
                    executeWorkerCase();
                    break;
            }
        } catch (InputMismatchException e) {
            logger.error("Try again");
        }
    }


    private void executeOptionsForClient(int option) throws SQLException {
        switch (option) {
            case ClientActivities.RENT_CAR:
                CarRental carRental = clientDataGetter.rentACar(input);
                carRentalOptions.rentACar(carRental);
                dataBaseCommunication.executeCarRentalMessage(carRental);
                break;
            case ClientActivities.RETURN_CAR:
                car = clientDataGetter.returnACar(input);
                carRentalOptions.returnACar(car);
                dataBaseCommunication.executeReturnCarMessage(car);
                break;
            case ClientActivities.GET_RENTED_CARS:
                carRentalOptions.getFullInfoAboutRentedCars(clientDataGetter.populateTableRent(input));
                break;
            case ClientActivities.GET_ALL_CARS:
                logger.info(carRentalOptions.getFullInfoAboutCars());
                break;
            case ClientActivities.QUIT:
                break;
        }
    }


    private void executeOptionsForWorker(int option) throws SQLException {
        switch (option) {
            case WorkerActivities.GET_ALL_CUSTOMERS:
                logger.info(carRentalOptions.getFullInfoAboutClients());
                break;
            case WorkerActivities.GET_ALL_CARS:
                logger.info(carRentalOptions.getFullInfoAboutCars());
                break;
            case WorkerActivities.MAKE_CAR_AVAILABLE:
                car = workerDataGetter.makeCarAavailable(input);
                carRentalOptions.makeCarAvailable(car);
                dataBaseCommunication.executeMakeCarAvailableMessage(car);
                break;
            case WorkerActivities.MAKE_CAR_UNAVAILABLE:
                car = workerDataGetter.makeCarAavailable(input);
                carRentalOptions.makeCarUnavailable(car);
                dataBaseCommunication.executeMakeCarUnvaliableMessage(car);
                break;
            case WorkerActivities.CREATE_CAR:
                car = workerDataGetter.createCar(input);
                carRentalOptions.createNewCar(car);
                dataBaseCommunication.executeCreateCarMessage(car);
            case WorkerActivities.QUIT:
                break;
        }
    }


    private void executeClientCase() throws SQLException {
        logger.info("1. Have you inputted your perdata before?\nN/Y: ");
        if (input.next().toUpperCase().equals("N")) {
            Client client = clientDataGetter.createClient(input);
            carRentalOptions.createNewClient(client);
            dataBaseCommunication.executeAddClientMessage(client);
            logger.info("Now you have your unique number clinet, use it where it is required!");
        } else {
            do {
                logger.info("What do you want to do?");
                logger.info("1. Rent a car");
                logger.info("2. Return a car");
                logger.info("3. Populate rented cars");
                logger.info("4. Populate cars");
                logger.info("5. Quit");
                option = input.nextInt();
                executeOptionsForClient(option);
            }
            while (option != 5);
        }
    }

    private void executeWorkerCase() throws SQLException {
        do {
            logger.info("What do you want to do?");
            logger.info("1. Populate clients");
            logger.info("2. Populate cars");
            logger.info("3. Make car available");
            logger.info("4. Make car unavailable");
            logger.info("5. Insert new car");
            logger.info("6. Quit");
            option = input.nextInt();
            executeOptionsForWorker(option);
        }
        while (option != 6);
    }
}