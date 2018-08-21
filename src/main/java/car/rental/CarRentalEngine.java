package car.rental;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import car.rental.activities.ClientActivities;
import car.rental.activities.WorkerActivities;
import car.rental.data.getters.ClientDataGetter;
import car.rental.data.getters.WorkerDataGetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CarRentalEngine {
    private CarRentalOptions carRentalOptions;
    private static final int CUSTOMER = 1;
    private static final int WORKER = 2;
    private int option;
    private Scanner input = new Scanner(System.in);
    private ClientDataGetter clientDataGetter;
    private WorkerDataGetter workerDataGetter;
    private Logger logger;


    CarRentalEngine(CarRentalOptions carRentalOptions) {
        this.carRentalOptions = carRentalOptions;
        clientDataGetter = new ClientDataGetter();
        workerDataGetter = new WorkerDataGetter();
        logger = LoggerFactory.getLogger(CarRentalEngine.class);
    }

    void startCarRental() throws SQLException {
        logger.info("Who are you?\n1. Customer\n2. Worker");
        option = input.nextInt();
        try {
            switch (option) {
                case CUSTOMER:
                    executeClientCase();
                    break;
                case WORKER:
                    executeWorkerCase();
                    break;
            }
        } catch (InputMismatchException e) {
            logger.error("Your input is wrong!");
        }
    }


    private void executeOptionsForClient(int option) throws SQLException {
        switch (option) {
            case ClientActivities.RENT_CAR:
                carRentalOptions.rentACar(clientDataGetter.rentACar(input));
                break;
            case ClientActivities.RETURN_CAR:
                carRentalOptions.returnACar(clientDataGetter.returnACar(input));
                break;
            case ClientActivities.GET_RENTED_CARS:
                carRentalOptions.getFullInfoAboutRentedCars(clientDataGetter.populateTableRent(input));
                break;
            case ClientActivities.GET_ALL_CARS:
                carRentalOptions.getFullInfoAboutCars();
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
                carRentalOptions.getFullInfoAboutCars();
                break;
            case WorkerActivities.MAKE_CAR_AVAILABLE:
                carRentalOptions.makeCarAvailable(workerDataGetter.makeCarAavailable(input));
                break;
            case WorkerActivities.MAKE_CAR_UNAVAILABLE:
                carRentalOptions.makeCarUnavailable(workerDataGetter.makeCarUnavailable(input));
                break;
            case WorkerActivities.CREATE_CAR:
                carRentalOptions.createNewCar(workerDataGetter.createCar(input));
            case WorkerActivities.QUIT:
                break;
        }
    }


    private void executeClientCase() throws SQLException {
        logger.info("1. Have you inputted your data before?\nN/Y: ");
        if (input.next().toUpperCase().equals("N")) {
            carRentalOptions.createNewCustomer(clientDataGetter.createClient(input));
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