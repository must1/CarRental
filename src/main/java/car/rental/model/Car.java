package car.rental.model;

public class Car {
    private String available;
    private String brand;
    private String productionYear;
    private String engineCapacity;
    private int dayPrice;
    private int clientNumber;

    @Override
    public String toString() {
        return ("\nBrand: " + getBrand()
                + "\nProdction Year: " + getProductionYear()
                + "\nEngine Capacity: " + getEngineCapacity()
                + "\nDay Price: " + getDayPrice()
                + "\nAvailable: " + getAvailable())
                + "\n-----------------";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(int dayPrice) {
        this.dayPrice = dayPrice;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public int getClientNumber() {
        return clientNumber;
    }
}
