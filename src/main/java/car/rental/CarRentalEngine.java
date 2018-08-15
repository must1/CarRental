package car.rental;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import car.rental.data.getters.ClientDataGetter;
import car.rental.data.getters.WorkerDataGetter;
import car.rental.db.CarRentalSQLDatabase;

class CarRentalEngine {

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
                case 1:
                    executeClientCase();
                    break;
                case 2:
                    executeWorkerCase();
                    break;
            }
        } catch (InputMismatchException e) {
            System.err.println("Your input is wrong!");
        }
    }


    private void executeOptionsForClient(int option) throws SQLException {
        switch (option) {
            case 1:
                carRentalOptions.rentACar(clientDataGetter.rentACar(input));
                break;
            case 2:
                carRentalOptions.returnACar(clientDataGetter.returnACar(input));
                break;
            case 3:
                carRentalOptions.populateTableRent(clientDataGetter.populateTableRent(input));
                break;
            case 4:
                carRentalOptions.populateTableViewCars(clientDataGetter.populateTableViewCars(input));
                break;
            case 5:
                break;
        }
    }


    private void executeOptionsForWorker(int option) throws SQLException {
        switch (option) {
            case 1:
                carRentalOptions.getAllCustomers();
                break;
            case 2:
                carRentalOptions.populateTableViewCars(clientDataGetter.populateTableViewCars(input));
                break;
            case 3:
                carRentalOptions.makeCarAvailable(workerDataGetter.makeCarAavailable(input));
                break;
            case 4:
                carRentalOptions.makeCarUnavailable(workerDataGetter.makeCarUnavailable(input));
                break;
            case 5:
                carRentalOptions.createNewCar(workerDataGetter.createCar(input));
            case 6:
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