package lab4;

import java.io.*;
import java.util.*;

class CustomDivisionException extends Exception {
    public CustomDivisionException(String message) {
        super(message);
    }
}

class CustomAgeException extends Exception {
    public CustomAgeException(String message) {
        super(message);
    }
}

class CustomFileNotFoundException extends Exception {
    public CustomFileNotFoundException(String message) {
        super(message);
    }
}

class CustomNumberFormatException extends Exception {
    public CustomNumberFormatException(String message) {
        super(message);
    }
}

class CustomEmptyStackException extends Exception {
    public CustomEmptyStackException(String message) {
        super(message);
    }
}

class CustomInputMismatchException extends Exception {
    public CustomInputMismatchException(String message) {
        super(message);
    }
}

class CustomEmailFormatException extends Exception {
    public CustomEmailFormatException(String message) {
        super(message);
    }
}

class CustomUnsupportedOperationException extends Exception {
    public CustomUnsupportedOperationException(String message) {
        super(message);
    }
}

public class ExceptionHandlingDemo {

    public static void logException(Exception e) {
        try (FileWriter fw = new FileWriter("exceptions_log.txt", true); PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Исключение: " + e.getMessage());
        } catch (IOException ioException) {
            System.out.println("Ошибка записи в файл лога: " + ioException.getMessage());
        }
    }

    public static void divideNumbers(int a, int b) throws CustomDivisionException {
        if (b == 0) {
            throw new CustomDivisionException("Ошибка: деление на ноль.");
        }
        System.out.println("Результат деления: " + (a / b));
    }

    public static void checkAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Недопустимый возраст: " + age);
        }
        System.out.println("Ваш возраст: " + age);
    }

    public static void readFile(String filename) throws CustomFileNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new CustomFileNotFoundException("Файл " + filename + " не найден.");
        }
        System.out.println("Файл " + filename + " успешно найден.");
    }

    public static void parseNumber(String str) throws CustomNumberFormatException {
        try {
            int number = Integer.parseInt(str);
            System.out.println("Число: " + number);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException("Некорректное число: " + str);
        }
    }

    static class CustomStack {
        private Stack<Integer> stack = new Stack<>();

        public void push(int value) {
            stack.push(value);
        }

        public int pop() throws CustomEmptyStackException {
            if (stack.isEmpty()) {
                throw new CustomEmptyStackException("Ошибка: стек пуст.");
            }
            return stack.pop();
        }
    }

    public static void inputNumber(Scanner scanner) throws CustomInputMismatchException {
        try {
            System.out.print("Введите число: ");
            int number = scanner.nextInt();
            System.out.println("Вы ввели: " + number);
        } catch (InputMismatchException e) {
            throw new CustomInputMismatchException("Некорректный ввод: ожидалось число.");
        }
    }

    public static void checkEmail(String email) throws CustomEmailFormatException {
        if (!email.matches("^[\\w-\\.]+@[\\w-\\.]+\\.[a-z]{2,3}$")) {
            throw new CustomEmailFormatException("Некорректный формат email: " + email);
        }
        System.out.println("Email верный: " + email);
    }

    public static void performOperation(String operation) throws CustomUnsupportedOperationException {
        switch (operation) {
            case "add":
                System.out.println("Операция сложения.");
                break;
            case "subtract":
                System.out.println("Операция вычитания.");
                break;
            case "multiply":
                System.out.println("Операция умножения.");
                break;
            case "division":
                System.out.println("Операция деления.");
                break;
            default:
                throw new CustomUnsupportedOperationException("Операция " + operation + " не поддерживается.");
        }
    }

    public static void main(String[] args) {

        try {
            divideNumbers(10, 8);
        } catch (CustomDivisionException e) {
            System.out.println(e.getMessage());
            logException(e);
        }

        try {
            checkAge(130);
        } catch (CustomAgeException e) {
            System.out.println(e.getMessage());
            logException(e);
        }

        try {
            readFile("file.txt");
        } catch (CustomFileNotFoundException e) {
            System.out.println(e.getMessage());
            logException(e);
        }

        try {
            parseNumber("123");
        } catch (CustomNumberFormatException e) {
            System.out.println(e.getMessage());
            logException(e);
        }

        CustomStack stack = new CustomStack();
        try {
            stack.pop();
        } catch (CustomEmptyStackException e) {
            System.out.println(e.getMessage());
            logException(e);
        }

        Scanner scanner = new Scanner(System.in);
        try {
            inputNumber(scanner);
        } catch (CustomInputMismatchException e) {
            System.out.println(e.getMessage());
            logException(e);
        }

        try {
            checkEmail("wrong-emai@gmail.com");
        } catch (CustomEmailFormatException e) {
            System.out.println(e.getMessage());
            logException(e);
        }

        try {
            performOperation("multiply");
        } catch (CustomUnsupportedOperationException e) {
            System.out.println(e.getMessage());
            logException(e);
        }
    }
}
