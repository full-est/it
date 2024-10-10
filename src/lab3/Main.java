package lab3;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Product product1 = new Product("Apple", 1.50, 100);
        Product product2 = new Product("Banana", 0.80, 150);
        Product product3 = new Product("Orange", 1.20, 200);

        warehouse.addProduct("12345", product1);
        warehouse.addProduct("67890", product2);
        warehouse.addProduct("11223", product3);

        System.out.println("Продукты на складе:");
        warehouse.printAllProducts();

        System.out.println("\nПоиск продукта по штрихкоду '67890':");
        Product foundProduct = warehouse.findProduct("67890");
        if (foundProduct != null) {
            System.out.println(foundProduct);
        } else {
            System.out.println("Продукт не найден.");
        }

        warehouse.removeProduct("12345");
        System.out.println("\nПродукты на складе после удаления '12345':");
        warehouse.printAllProducts();
    }
}
