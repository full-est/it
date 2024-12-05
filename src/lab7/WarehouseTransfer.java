package lab7;

import java.util.*;
import java.util.concurrent.*;

class Product {
    private final String name;
    private final int weight;

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " (" + weight + "kg)";
    }
}

public class WarehouseTransfer {

    private static final int MAX_LOAD = 150;
    private static final int WORKERS_GROUP = 1;

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Product1", 30),
                new Product("Product2", 50),
                new Product("Product3", 40),
                new Product("Product4", 20),
                new Product("Product5", 70),
                new Product("Product6", 64),
                new Product("Product7", 10),
                new Product("Product8", 40)
        );

        transferProducts(products);
    }

    public static void transferProducts(List<Product> products) {
        Queue<Product> productQueue = new LinkedList<>(products);
        ExecutorService executor = Executors.newFixedThreadPool(WORKERS_GROUP);

        while (!productQueue.isEmpty()) {
            List<Product> batch = new ArrayList<>();
            final int []currentWeight = {0};

            while (!productQueue.isEmpty() && currentWeight[0] + productQueue.peek().getWeight() <= MAX_LOAD) {
                Product product = productQueue.poll();
                batch.add(product);
                currentWeight[0] += product.getWeight();
            }

            System.out.println("Сформирована партия: " + batch + ", общий вес: " + currentWeight[0] + "kg");

            CompletableFuture.runAsync(() -> {
                System.out.println("Перенос партии: " + batch + ", общий вес: " + currentWeight[0] + "kg");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Партия доставлена: " + batch);
            }, executor);
        }

        executor.shutdown();
    }
}




