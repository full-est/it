package lab8;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data;

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            data = reader.lines()
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .filter(word -> !word.isBlank())
                    .collect(Collectors.toList());
        }
        System.out.println("Данные загружены: " + data);
    }

    public void processData() {
        if (data == null) {
            throw new IllegalStateException("Данные не загружены!");
        }

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Object processor : processors) {
            for (Method method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    try {
                        method.setAccessible(true);

                        Future<List<String>> future = executor.submit(() -> {
                            return (List<String>) method.invoke(processor, data);
                        });

                        data = future.get();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        executor.shutdown();

        System.out.println("Обработанные данные: " + data);
    }

    public void saveData(String destination) throws IOException {
        Path path = Paths.get(destination);
        Files.write(path, data);
        System.out.println("Данные сохранены в файл: " + destination);
    }
}

