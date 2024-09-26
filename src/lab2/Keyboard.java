package lab2;

public class Keyboard extends Devices {
    private boolean isWireless;
    private int amountOfKeys;
    private String typeOfSwitch;

    public Keyboard() {
        super();
    }

    public Keyboard(String brand, String model, double price, boolean isWireless, int amountOfKeys, String typeOfSwitch) {
        super(brand, model, price);
        this.isWireless = isWireless;
        this.amountOfKeys = amountOfKeys;
        this.typeOfSwitch = typeOfSwitch;
    }

    @Override
    public void connect(){
        System.out.println("Keyboard connected to the computer");
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Is wireless: " + isWireless+ ", Amount of keys: "+ amountOfKeys+ ", Type of switch: "+typeOfSwitch);
    }

    public void typing(){
        System.out.println("Typing on the keyboard");
    }

    public void setIsWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    public boolean getIsWireless() {
        return isWireless;
    }

    public void setAmountOfKeys(int amountOfKeys) {
        this.amountOfKeys = amountOfKeys;
    }

    public int getAmountOfKeys() {
        return amountOfKeys;
    }

    public void setTypeOfSwitch(String typeOfSwitch) {
        this.typeOfSwitch = typeOfSwitch;
    }

    public String getTypeOfSwitch() {
        return typeOfSwitch;
    }
}
