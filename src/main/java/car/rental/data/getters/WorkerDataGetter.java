package car.rental.data.getters;

import car.rental.model.Car;

import java.util.Scanner;

public class WorkerDataGetter {

    public Car createCar(Scanner input) {
        Car car = new Car();

        car.setBrand(InputTaker.takeStringInput(input, "Brand"));
        car.setDayPrice(InputTaker.takeIntInput(input, "Day Price"));
        car.setProductionYear(InputTaker.takeStringInput(input, "production year"));
        car.setEngineCapacity(InputTaker.takeStringInput(input, "engine capacity"));
        car.setAvailable(InputTaker.takeStringInput(input, "available"));

        return car;
    }

    public Car makeCarUnavailable(Scanner input) {
        Car car = new Car();

        car.setBrand(InputTaker.takeStringInput(input, "Brand"));
        car.setProductionYear(InputTaker.takeStringInput(input, "production year"));

        return car;
    }

    public Car makeCarAavailable(Scanner input) {
        Car car = new Car();

        car.setBrand(InputTaker.takeStringInput(input, "brand"));
        car.setProductionYear(InputTaker.takeStringInput(input, "production year"));

        return car;
    }
}
