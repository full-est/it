package lab3;

import java.util.HashMap;

public class Warehouse {
    private HashMap<String, Product> productMap;

    public Warehouse() {
        this.productMap = new HashMap<>();
    }

    public void addProduct(String barcode, Product product) {
        productMap.put(barcode, product);
    }

    public Product findProduct(String barcode) {
        return productMap.get(barcode);
    }

    public void removeProduct(String barcode) {
        productMap.remove(barcode);
    }

    public void printAllProducts() {
        for (String barcode : productMap.keySet()) {
            System.out.println("Штрихкод: " + barcode + " -> " + productMap.get(barcode));
        }
    }
}
