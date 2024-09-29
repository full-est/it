package lab2;

public class Main {
    public static void main(String[] args) {
        Keyboard keyboard1 = new Keyboard("Logitech", "G213", 50.99, true, 63, "g3ms Saphire");
        Headphones headphones1 = new Headphones("Sony", "WH-1000XM4", 299.99, true, "TWS", "Active");
        GraphicTablet tablet1 = new GraphicTablet("Wacom", "Intuos Pro", 399.99, false, "Medium", "Back");

        keyboard1.displayInfo();
        keyboard1.connect();
        keyboard1.typing();

        headphones1.displayInfo();
        headphones1.connect();
        headphones1.listenMusic();

        tablet1.displayInfo();
        tablet1.connect();
        tablet1.draw();

        System.out.println("Total devices: " + Devices.getObjectCount());
    }
}

