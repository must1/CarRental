package car.rental;

import car.rental.model.Car;
import car.rental.model.Client;
import car.rental.model.RentingACar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class CarRentalOptions {
    private CarRentalStorage storage;
    private Logger logger = LoggerFactory.getLogger(CarRentalOptions.class);

    public CarRentalOptions(CarRentalStorage storage) {
        this.storage = storage;
    }

    public void createNewCustomer(Client client) throws SQLException {
        storage.addClient(client);
    }

    void createNewCar(Car car) throws SQLException {
        storage.addNewCar(car);
    }

    void makeCarUnavailable(Car car) throws SQLException {
        storage.makeCarUnavailable(car);
    }

    void makeCarAvailable(Car car) throws SQLException {
        storage.makeCarAvailable(car);
    }

    void rentACar(RentingACar rentingACar) throws SQLException {
        storage.rentACar(rentingACar);
    }

    void populateTableViewCars(Car car) throws SQLException {
        storage.populateTableViewCars(car);
    }

    void populateTableRent(Client client) throws SQLException {
        storage.populateTableRent(client);
    }

    void getAllCustomers() throws SQLException {
        for (int i = 0; i < storage.getAllCustomers().size(); i++) {
            logger.info("Name: " + storage.getAllCustomers().get(i).getName()
                    + "\nSurname: " + storage.getAllCustomers().get(i).getSurname()
                    + "\nStreet: " + storage.getAllCustomers().get(i).getStreet()
                    + "\nHouse number: " + storage.getAllCustomers().get(i).getHouseNumber()
                    + "\nCity: " + storage.getAllCustomers().get(i).getCity()
                    + "\nPesel Number: " + storage.getAllCustomers().get(i).getPeselNumber()
                    + "\nRent Date: " + storage.getAllCustomers().get(i).getRentDate()
                    + "\nClient number: " + storage.getAllCustomers().get(i).getClientNumber());
            logger.info("---------------------------");
        }
    }

    void returnACar(Car car) throws SQLException {
        storage.returnACar(car);
    }
}