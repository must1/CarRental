package car.rental;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import car.rental.activities.ClientActivities;
import car.rental.activities.WorkerActivities;
import car.rental.data.getters.ClientDataGetter;
import car.rental.data.getters.WorkerDataGetter;
import car.rental.DB.CarRentalSQLDatabase;

class CarRentalEngine {

    private static final int CUSTOMER = 1;
    private static final int WORKER = 2;
    private int option;
    private Scanner input = new Scanner(System.in);
    private CarRentalSQLDatabase storage = new CarRentalSQLDatabase();
    private CarRentalOptions carRentalOptions = new CarRentalOptions(storage);
    private ClientDataGetter clientDataGetter = new ClientDataGetter();
    private WorkerDataGetter workerDataGetter = new WorkerDataGetter();

    CarRentalEngine() throws SQLException {
    }

    void startCarRental() throws SQLException {
        System.out.println("Who are you?\n1. Customer\n2. Worker");
        try {
            switch (input.nextInt()) {
                case CUSTOMER:
                    executeClientCase();
                    break;
                case WORKER:
                    executeWorkerCase();
                    break;
            }
        } catch (InputMismatchException e) {
            System.err.println("Your input is wrong!");
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
            case ClientActivities.POPULATE_TABLE_RENTED_CARS:
                carRentalOptions.populateTableRent(clientDataGetter.populateTableRent(input));
                break;
            case ClientActivities.POPULATE_TABLE_CARS:
                carRentalOptions.populateTableViewCars(clientDataGetter.populateTableViewCars(input));
                break;
            case ClientActivities.QUIT:
                break;
        }
    }


    private void executeOptionsForWorker(int option) throws SQLException {
        switch (option) {
            case WorkerActivities.GET_ALL_CUSTOMERS:
                carRentalOptions.getAllCustomers();
                break;
            case WorkerActivities.GET_VIEW_OF_CARS:
                carRentalOptions.populateTableViewCars(clientDataGetter.populateTableViewCars(input));
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
        System.out.println("1. Have you inputted your data before?\nN/Y: ");
        if (input.next().toUpperCase().equals("N")) {
            carRentalOptions.createNewCustomer(clientDataGetter.createClient(input));
            System.out.println("Now you have your unique number clinet, use it where it is required!");
        } else {
            do {
                System.out.println("What do you want to do?");
                System.out.println("1. Rent a car\n2. Return a car\n3. Populate rented cars\n4. Populate cars\n5. Quit");
                option = input.nextInt();
                executeOptionsForClient(option);
            }
            while (option != 5);
        }
    }

    private void executeWorkerCase() throws SQLException {
        do {
            System.out.println("What do you want to do?");
            System.out.println("1. Populate clients\n2. Populate cars\n3. Make car available\n4. Make car unavailable\n5. Insert new car\n6. Quit");
            option = input.nextInt();
            executeOptionsForWorker(option);
        }
        while (option != 6);
    }
}