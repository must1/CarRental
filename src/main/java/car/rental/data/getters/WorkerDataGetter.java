package car.rental.data.getters;

import car.rental.model.Car;

import java.util.Scanner;

public class WorkerDataGetter {

    public Car createCar(Scanner input) {
        Car car = new Car();

        car.setBrand(InputParser.readString(input, "Brand"));
        car.setDayPrice(InputParser.readInteger(input, "Day Price"));
        car.setProductionYear(InputParser.readString(input, "production year"));
        car.setEngineCapacity(InputParser.readString(input, "engine capacity"));
        car.setAvailable(InputParser.readString(input, "available"));

        return car;
    }

    public Car makeCarUnavailable(Scanner input) {
        Car car = new Car();

        car.setBrand(InputParser.readString(input, "Brand"));
        car.setProductionYear(InputParser.readString(input, "production year"));

        return car;
    }

    public Car makeCarAvailable(Scanner input) {
        Car car = new Car();

        car.setBrand(InputParser.readString(input, "brand"));
        car.setProductionYear(InputParser.readString(input, "production year"));

        return car;
    }
}
