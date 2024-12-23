package lab8;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        dataManager.registerDataProcessor(new FilterProcessor());
        dataManager.registerDataProcessor(new TransformProcessor());
        dataManager.registerDataProcessor(new AggregateProcessor());

        try {
            dataManager.loadData("C:\\Users\\xamil\\IdeaProjects\\labs\\src\\lab8\\input.txt");

            dataManager.processData();

            dataManager.saveData("output.txt");
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
