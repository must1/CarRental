package car.rental.data.getters;

import car.rental.model.Car;

import java.util.Scanner;

public class WorkerDataGetter {

    public Car createCar(Scanner input) {
        Car car = new Car();

        car.setBrand(InputTakers.takeStringInput(input, "Brand"));
        car.setDayPrice(InputTakers.takeIntInput(input, "Day Price"));
        car.setProductionYear(InputTakers.takeStringInput(input, "production year"));
        car.setEngineCapacity(InputTakers.takeStringInput(input, "engine capacity"));
        car.setAvailable(InputTakers.takeStringInput(input, "available"));

        return car;
    }

    public Car makeCarUnavailable(Scanner input) {
        Car car = new Car();

        car.setBrand(InputTakers.takeStringInput(input, "Brand"));
        car.setProductionYear(InputTakers.takeStringInput(input, "production year"));

        return car;
    }

    public Car makeCarAavailable(Scanner input) {
        Car car = new Car();

        car.setBrand(InputTakers.takeStringInput(input, "brand"));
        car.setProductionYear(InputTakers.takeStringInput(input, "production year"));

        return car;
    }
}
