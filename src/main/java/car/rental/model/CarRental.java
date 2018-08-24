package car.rental.model;

public class CarRental {

    private String brand;
    private String surname;
    private String name;
    private String rentDate;
    private int clientNumber;

    @Override
    public String toString() {
        return ("\nBrand: " + getBrand()
                + "\nName: " + getName()
                + "\nSurname: " + getSurname()
                + "\nRent Date: " + getRentDate()
                + "\n-----------------");
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }
}
