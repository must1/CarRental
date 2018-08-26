package car.rental;

import java.sql.SQLException;
import java.util.Scanner;

import car.rental.activities.ClientActivities;
import car.rental.activities.WorkerActivities;
import car.rental.data.getters.ClientDataGetter;
import car.rental.data.getters.WorkerDataGetter;
import car.rental.model.Car;
import car.rental.model.CarRental;
import car.rental.model.Client;
import car.rental.user.communication.DataBaseCommunication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CarRentalEngine {
    private CarRentalOptions carRentalOptions;
    private static final int CUSTOMER = 1;
    private static final int WORKER = 2;
    private int option;
    private Scanner input = new Scanner(System.in);
    private ClientDataGetter clientDataGetter = new ClientDataGetter();
    private WorkerDataGetter workerDataGetter = new WorkerDataGetter();
    private Logger logger;
    private Client client;
    private Car car;
    private CarRental carRental;
    private DataBaseCommunication dataBaseCommunication;

    CarRentalEngine(CarRentalOptions carRentalOptions) throws SQLException {
        this.carRentalOptions = carRentalOptions;
        logger = LoggerFactory.getLogger(CarRentalEngine.class);
        dataBaseCommunication = new DataBaseCommunication();
    }

    void startCarRental() throws SQLException {
        logger.info("Who are you?\n1. Customer\n2. Worker");
        option = input.nextInt();
        switch (option) {
            case CUSTOMER:
                executeClientCase();
                break;
            case WORKER:
                executeWorkerCase();
                break;
        }
    }


    private void executeOptionsForClient(int option) throws SQLException {
        switch (option) {
            case ClientActivities.RENT_CAR:
                carRental = clientDataGetter.rentACar(input);
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
        logger.info("1. Have you inputted your data before?\nN/Y: ");
        if (input.next().toUpperCase().equals("N")) {
            client = clientDataGetter.createClient(input);
            carRentalOptions.createNewCustomer(client);
            logger.info("Now you have your unique number clinet, use it where it is required!");
        } else {
            do {
                logger.info("What do you want to do?");
                logger.info("1. Rent a car\n2. Return a car\n3. Populate rented cars\n4. Populate cars\n5. Quit");
                option = input.nextInt();
                executeOptionsForClient(option);
            }
            while (option != 5);
        }
    }

    private void executeWorkerCase() throws SQLException {
        do {
            logger.info("What do you want to do?");
            logger.info("1. Populate clients\n2. Populate cars\n3. Make car available\n4. Make car unavailable\n5. Insert new car\n6. Quit");
            option = input.nextInt();
            executeOptionsForWorker(option);
        }
        while (option != 6);
    }
}