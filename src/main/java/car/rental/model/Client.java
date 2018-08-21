package car.rental.model;

public class Client {
    private String name;
    private String surname;
    private String street;
    private int houseNumber;
    private String city;
    private long peselNumber;
    private String rentDate;
    private int clientNumber;

    @Override
    public String toString() {
        return ("\nName: " + getName()
                + "\nSurname: " + getSurname()
                + "\nStreet: " + getStreet()
                + "\nHouse number: " + getHouseNumber()
                + "\nCity: " + getCity()
                + "\nPesel Number: " + getPeselNumber()
                + "\nRent Date: " + getRentDate()
                + "\nClient number: " + getClientNumber())
                + "\n-----------------";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public long getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(long peselNumber) {
        this.peselNumber = peselNumber;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }
}