package car.rental.data.getters;

import car.rental.model.Car;

import java.util.Scanner;

public class WorkerDataGetter {

    public Car createCar(Scanner input) {
        Car car = new Car();

        System.out.print("Brand: ");
        car.setBrand(input.next());
        System.out.print("Day price: ");
        car.setDayPrice(input.nextInt());
        System.out.print("Engine Capcity: ");
        car.setEngineCapacity(input.next());
        System.out.print("Production year: ");
        car.setProductionYear(input.next());
        System.out.print("available: ");
        car.setAvailable(input.next());

        return car;
    }

    public Car makeCarUnavailable(Scanner input) {
        Car car = new Car();

        System.out.print("Brand: ");
        car.setBrand(input.next());
        System.out.print("production year: ");
        car.setProductionYear(input.next());

        return car;
    }

    public Car makeCarAavailable(Scanner input) {
        Car car = new Car();

        System.out.print("Brand: ");
        car.setBrand(input.next());
        System.out.print("Production year : ");
        car.setProductionYear(input.next());

        return car;
    }
}
