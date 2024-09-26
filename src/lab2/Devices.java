package lab2;

public abstract class Devices {
    private String brand;
    private String model;
    private double price;

    public static int objectCount = 0;

    public Devices() {
        objectCount++;
    }

    public Devices(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        objectCount++;
    }
    public abstract void connect();

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public void displayInfo(){
        System.out.println("Brand: " + brand + ", Model: " + model + ", Price: " + price);
    }
}
