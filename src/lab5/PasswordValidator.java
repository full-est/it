package lab5;

import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        String password = "Example123";

        if (isValidPassword(password)) {
            System.out.println("Пароль корректен.");
        } else {
            System.out.println("Пароль не соответствует требованиям.");
        }
    }

    public static boolean isValidPassword(String password) {
        try {
            String passwordPattern = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
            Pattern pattern = Pattern.compile(passwordPattern);
            Matcher matcher = pattern.matcher(password);

            return matcher.matches();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при проверке пароля: " + e.getMessage());
            return false;
        }
    }
}

