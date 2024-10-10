package lab3;

public class Main2 {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("Apple", 50);
        hashTable.put("Banana", 30);
        hashTable.put("Orange", 20);
        hashTable.put("Grapes", 40);

        System.out.println("Хэш-таблица после добавления элементов:");
        hashTable.printTable();

        System.out.println("\nЗначение для ключа 'Banana': " + hashTable.get("Banana"));

        hashTable.remove("Orange");
        System.out.println("\nХэш-таблица после удаления 'Orange':");
        hashTable.printTable();

        System.out.println("\nТекущий размер хэш-таблицы: " + hashTable.size());

        System.out.println("\nХэш-таблица пуста? " + hashTable.isEmpty());

        System.out.println("\nЗначение для ключа 'Orange' (после удаления): " + hashTable.get("Orange"));
    }
}

