package lab6;

import java.util.HashMap;
import java.util.Map;

public class SalesTracker {

    private Map<String, Integer> salesMap;
    private Map<String, Double> priceMap;

    public SalesTracker() {
        salesMap = new HashMap<>();
        priceMap = new HashMap<>();
    }

    public void addProduct(String productName, double price) {
        if (!priceMap.containsKey(productName)) {
            priceMap.put(productName, price);
            salesMap.put(productName, 0);
        }
    }

    public void sellProduct(String productName, int quantity) {
        if (salesMap.containsKey(productName)) {
            salesMap.put(productName, salesMap.get(productName) + quantity);
        } else {
            System.out.println("Товар не найден: " + productName);
        }
    }

    public void printSales() {
        System.out.println("Список проданных товаров:");
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            String product = entry.getKey();
            int quantitySold = entry.getValue();
            System.out.println("Товар: " + product + ", Количество: " + quantitySold);
        }
    }

    public double getTotalSales() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            String product = entry.getKey();
            int quantitySold = entry.getValue();
            double price = priceMap.get(product);
            total += price * quantitySold;
        }
        return total;
    }

    public String getMostPopularProduct() {
        String mostPopular = null;
        int maxQuantity = 0;
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                maxQuantity = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return mostPopular;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addProduct("Телевизор", 30000);
        tracker.addProduct("Холодильник", 25000);
        tracker.addProduct("Микроволновка", 5000);

        tracker.sellProduct("Телевизор", 5);
        tracker.sellProduct("Холодильник", 3);
        tracker.sellProduct("Микроволновка", 7);
        tracker.sellProduct("Телевизор", 2);

        tracker.printSales();

        System.out.println("Общая сумма продаж: " + tracker.getTotalSales() + " рублей");
        System.out.println("Наиболее популярный товар: " + tracker.getMostPopularProduct());
    }
}

