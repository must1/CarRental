package car.rental;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import car.rental.data.getters.ClientDataGetter;
import car.rental.data.getters.WorkerDataGetter;
import car.rental.model.Car;
import car.rental.model.CarRental;
import car.rental.model.Client;
import car.rental.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CarRentalEngine {
    private static final int CLIENT = 1;
    private static final int WORKER = 2;
    private int option;
    private Scanner input = new Scanner(System.in);
    private ClientDataGetter clientDataGetter = new ClientDataGetter();
    private WorkerDataGetter workerDataGetter = new WorkerDataGetter();
    private Logger logger;
    private ClientStorageInterface clientStorage;
    private CarStorageInterface carStorage;
    private RentalStorageInterface rentalStorage;

    CarRentalEngine(ClientStorageInterface clientStorage, CarStorageInterface carStorage, RentalStorageInterface rentalStorage) {
        this.clientStorage = clientStorage;
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
        logger = LoggerFactory.getLogger(CarRentalEngine.class);
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
            case 1:
                CarRental readCarRental = clientDataGetter.rentCar(input);

                if (rentalStorage.rentCar(readCarRental)) {
                    logger.info("Car was rented");
                } else {
                    logger.info("Car was not rented");
                }
                break;
            case 2:
                Car readCar = clientDataGetter.returnCar(input);

                if (rentalStorage.returnACar(readCar)) {
                    logger.info("Car was returned");
                } else {
                    logger.info("Car was not returned");
                }
                break;
            case 3:
                Client readClients = clientDataGetter.populateTableRent(input);
                List<CarRental> rentedCars = rentalStorage.getClientRentals(readClients);
                StringBuilder sb = new StringBuilder();

                for (CarRental rentedCarsFullInfo : rentedCars)
                    sb.append(String.valueOf(rentedCarsFullInfo));

                logger.info(sb.toString());
                break;
            case 4:
                List<Car> cars = carStorage.getAllCars();
                sb = new StringBuilder();

                for (Car carsFullInfo : cars)
                    sb.append(String.valueOf(carsFullInfo));

                logger.info(sb.toString());
                break;
            case 5:
                break;
        }
    }


    private void executeOptionsForWorker(int option) throws SQLException {
        switch (option) {
            case 1:
                List<Client> clients = clientStorage.getAllClients();
                StringBuilder sb = new StringBuilder();

                for (Client clientFullInfo : clients)
                    sb.append(String.valueOf(clientFullInfo));

                logger.info(sb.toString());
                break;
            case 2:
                List<Car> cars = carStorage.getAllCars();
                sb = new StringBuilder();

                for (Car carsFullInfo : cars)
                    sb.append(String.valueOf(carsFullInfo));

                logger.info(sb.toString());
                break;
            case 3:
                Car readCar = workerDataGetter.makeCarAvailable(input);
                if (carStorage.makeCarAvailable(readCar)) {
                    logger.info("Car was made available");
                } else {
                    logger.info("Car was not made available");
                }
                break;
            case 4:
                readCar = workerDataGetter.makeCarUnavailable(input);
                if (carStorage.makeCarUnavailable(readCar)) {
                    logger.info("Car was made unvaliable");
                } else {
                    logger.info("Car was not made unvaliable");
                }
                break;
            case 5:
                readCar = workerDataGetter.createCar(input);

                if (carStorage.addNewCar(readCar)) {
                    logger.info("Car was created");
                } else {
                    logger.info("Car was not created");
                }
                break;
            case 6:
                break;
        }
    }


    private void executeClientCase() throws SQLException {
        logger.info("1. Have you inputted your perdata before?\nN/Y: ");
        if (input.next().toUpperCase().equals("N")) {
            Client client = clientDataGetter.createClient(input);
            clientStorage.addClient(client);
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