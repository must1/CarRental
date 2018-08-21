package car.rental.data.getters;

import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.RentingACar;

import java.util.Random;
import java.util.Scanner;

public class ClientDataGetter {

    private Random rand = new Random();

    public Client createClient(Scanner input) {
        Client client = new Client();
        int maxNumberOfClients = 999;
        client.setClientNumber(rand.nextInt(maxNumberOfClients));

        System.out.print("name: ");
        client.setName(input.next());
        System.out.print("surname: ");
        client.setSurname(input.next());
        System.out.print("city: ");
        client.setCity(input.next());
        System.out.print("house number: ");
        client.setHouseNumber(input.nextInt());
        System.out.print("street: ");
        client.setStreet(input.next());
        System.out.print("pesel number: ");
        client.setPeselNumber(input.nextLong());
        System.out.print("rent date: ");
        client.setRentDate(input.next());
        System.out.println("Your client number is: " + client.getClientNumber());

        return client;
    }

    public RentingACar rentACar(Scanner input) {
        RentingACar rentingACar = new RentingACar();

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
    }

    public Client populateTableRent(Scanner input) {
        Client client = new Client();

        System.out.println("Input your client number: ");
        client.setClientNumber(input.nextInt());

        return client;
    }

    public Car returnACar(Scanner input) {
        Car car = new Car();

        System.out.println("Input brand of car that you want to return: ");
        car.setBrand(input.next());
        System.out.println("Input your client number, otherwise car won't be removed from our CarRentalSQLDatabase!");
        car.setClientNumber(input.nextInt());

        return car;
    }
}
