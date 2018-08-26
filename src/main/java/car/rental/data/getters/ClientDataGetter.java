package car.rental.data.getters;

import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.CarRental;

import java.util.Random;
import java.util.Scanner;

public class ClientDataGetter {

    private Random rand = new Random();

    public Client createClient(Scanner input) {
        Client client = new Client();
        int maxNumberOfClients = 999;
        client.setClientNumber(rand.nextInt(maxNumberOfClients));

        client.setName(InputTaker.takeStringInput(input, "name"));
        client.setSurname(InputTaker.takeStringInput(input, "surname"));
        client.setCity(InputTaker.takeStringInput(input, "city"));
        client.setStreet(InputTaker.takeStringInput(input, "street"));
        client.setRentDate(InputTaker.takeStringInput(input, "rent date"));
        client.setHouseNumber(InputTaker.takeIntInput(input, "house number"));
        client.setPeselNumber(InputTaker.takeLongInput(input));
        System.out.println("Your client number is: " + client.getClientNumber());

        return client;
    }

    public CarRental rentACar(Scanner input) {
        CarRental carRental = new CarRental();

        carRental.setBrand(InputTaker.takeStringInput(input, "brand"));
        carRental.setName(InputTaker.takeStringInput(input, "name"));
        carRental.setSurname(InputTaker.takeStringInput(input, "surname"));
        carRental.setRentDate(InputTaker.takeStringInput(input, "rent date"));
        carRental.setClientNumber(InputTaker.takeIntInput(input, "client number"));

        return carRental;
    }

    public Client populateTableRent(Scanner input) {
        Client client = new Client();

        client.setClientNumber(InputTaker.takeIntInput(input, "Input your client number: "));

        return client;
    }

    public Car returnACar(Scanner input) {
        Car car = new Car();

        car.setBrand(InputTaker.takeStringInput(input, "Input brand of car that you want to return: "));
        car.setClientNumber(InputTaker.takeIntInput(input, "Input your client number, otherwise car won't be removed from our CarRentalSQLDatabase!"));

        return car;
    }
}
