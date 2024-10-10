package lab3;

public class Main2 {
    public static void main(String[] args) {
        // Создаем экземпляр хэш-таблицы
        HashTable<String, Integer> hashTable = new HashTable<>();

        // Добавляем несколько пар ключ-значение
        hashTable.put("Apple", 50);
        hashTable.put("Banana", 30);
        hashTable.put("Orange", 20);
        hashTable.put("Grapes", 40);

        // Выводим текущее содержимое хэш-таблицы
        System.out.println("Хэш-таблица после добавления элементов:");
        hashTable.printTable();

        // Получаем значение по ключу
        System.out.println("\nЗначение для ключа 'Banana': " + hashTable.get("Banana"));

        // Удаляем пару по ключу
        hashTable.remove("Orange");
        System.out.println("\nХэш-таблица после удаления 'Orange':");
        hashTable.printTable();

        // Проверяем размер таблицы
        System.out.println("\nТекущий размер хэш-таблицы: " + hashTable.size());

        // Проверяем, пуста ли таблица
        System.out.println("\nХэш-таблица пуста? " + hashTable.isEmpty());

        // Пытаемся получить значение для удаленного ключа
        System.out.println("\nЗначение для ключа 'Orange' (после удаления): " + hashTable.get("Orange"));
    }
}

