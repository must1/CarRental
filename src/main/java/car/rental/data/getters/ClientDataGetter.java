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

        client.setName(InputTakers.takeStringInput(input, "name"));
        client.setSurname(InputTakers.takeStringInput(input, "surname"));
        client.setCity(InputTakers.takeStringInput(input, "city"));
        client.setStreet(InputTakers.takeStringInput(input, "street"));
        client.setRentDate(InputTakers.takeStringInput(input, "rent date"));
        client.setHouseNumber(InputTakers.takeIntInput(input, "house number"));
        client.setPeselNumber(InputTakers.takeLongInput(input));
        System.out.println("Your client number is: " + client.getClientNumber());

        return client;
    }

    public CarRental rentACar(Scanner input) {
        CarRental carRental = new CarRental();

<<<<<<< HEAD
        System.out.print("Brand: ");
        rentingACar.setBrand(input.next());
        System.out.print("Name: ");
        rentingACar.setName(input.next());
        System.out.print("Surname: ");
        rentingACar.setSurname(input.next());
        System.out.print("Rent Date: ");
        rentingACar.setRentDate(input.next());
        System.out.print("Client number: ");
        rentingACar.setClientNumber(input.nextInt());

        return rentingACar;
=======
        carRental.setBrand(InputTakers.takeStringInput(input, "brand"));
        carRental.setName(InputTakers.takeStringInput(input, "name"));
            carRental.setSurname(InputTakers.takeStringInput(input, "surname"));
        carRental.setRentDate(InputTakers.takeStringInput(input, "rent date"));
        carRental.setClientNumber(InputTakers.takeIntInput(input, "client number"));
        return carRental;
>>>>>>> da8ecb03fcd3a9a2ae74e4dbae27733708c205cc
    }

    public Client populateTableRent(Scanner input) {
        Client client = new Client();

        client.setClientNumber(InputTakers.takeIntInput(input, "Input your client number: "));

        return client;
    }

    public Car returnACar(Scanner input) {
        Car car = new Car();

        car.setBrand(InputTakers.takeStringInput(input, "Input brand of car that you want to return: "));
        car.setClientNumber(InputTakers.takeIntInput(input, "Input your client number, otherwise car won't be removed from our CarRentalSQLDatabase!"));

        return car;
    }
}
