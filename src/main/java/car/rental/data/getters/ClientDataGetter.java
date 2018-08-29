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

        client.setName(InputParser.readString(input, "name"));
        client.setSurname(InputParser.readString(input, "surname"));
        client.setCity(InputParser.readString(input, "city"));
        client.setStreet(InputParser.readString(input, "street"));
        client.setRentDate(InputParser.readString(input, "rent date"));
        client.setHouseNumber(InputParser.readInteger(input, "house number"));
        client.setPeselNumber(InputParser.readLong(input));
        System.out.println("Your client number is: " + client.getClientNumber());

        return client;
    }

    public CarRental rentCar(Scanner input) {
        CarRental carRental = new CarRental();

        carRental.setBrand(InputParser.readString(input, "brand"));
        carRental.setName(InputParser.readString(input, "name"));
        carRental.setSurname(InputParser.readString(input, "surname"));
        carRental.setRentDate(InputParser.readString(input, "rent date"));
        carRental.setClientNumber(InputParser.readInteger(input, "client number"));

        return carRental;
    }

    public Client populateTableRent(Scanner input) {
        Client client = new Client();

        client.setClientNumber(InputParser.readInteger(input, "Input your client number: "));

        return client;
    }

    public Car returnCar(Scanner input) {
        Car car = new Car();

        car.setBrand(InputParser.readString(input, "Input brand of car that you want to return: "));
        car.setClientNumber(InputParser.readInteger(input, "Input your client number, otherwise car won't be removed from our CarRentalSQLDatabase!"));

        return car;
    }
}
