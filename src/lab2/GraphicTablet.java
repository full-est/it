package lab2;

public class GraphicTablet extends Devices{
    private boolean isWireless;
    private String format;
    private String color;

    public GraphicTablet() {
        super();
    }

    public GraphicTablet(String brand, String model, double price, boolean isWireless , String format, String color) {
        super(brand, model, price);
        this.isWireless = isWireless;
        this.format = format;
        this.color = color;
    }

    @Override
    public void connect(){
        System.out.println("GraphicTablet connected to the computer");
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Is wireless: " + isWireless+ ", Format: "+format + ", Color: "+color);
    }

    public void draw(){
        System.out.println("Drawing something on the graphic tablet");
    }

    public void setIsWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
