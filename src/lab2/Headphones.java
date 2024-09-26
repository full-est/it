package lab2;

public class Headphones extends Devices{
    private boolean isWireless;
    private String typeOfConstruction;
    private String noiseCancelation;

    public Headphones() {
        super();
    }

    public Headphones(String brand, String model, double price, boolean isWireless, String typeOfConstruction, String noiseCancelation) {
        super(brand, model, price);
        this.isWireless = isWireless;
        this.typeOfConstruction = typeOfConstruction;
        this.noiseCancelation = noiseCancelation;
    }

    @Override
    public void connect(){
        System.out.println("Headphones connected to the computer");
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Is wireless: " + isWireless+ ", Type of construction: "+typeOfConstruction + ", NoiseCancelation: "+noiseCancelation);
    }

    public void listenMusic(){
        System.out.println("Listening to music");
    }

    public void setIsWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    public boolean getIsWireless() {
        return isWireless;
    }

    public void setTypeOfConstruction(String typeOfConstruction) {
        this.typeOfConstruction = typeOfConstruction;
    }

    public String getTypeOfConstruction() {
        return typeOfConstruction;
    }

    public void setNoiseCancelation(String noiseCancelation) {
        this.noiseCancelation = noiseCancelation;
    }

    public String getNoiseCancelation() {
        return noiseCancelation;
    }
}
