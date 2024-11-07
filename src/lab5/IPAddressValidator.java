package lab5;

import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String ipAddress = "192.168.1.1";

        if (isValidIPAddress(ipAddress)) {
            System.out.println("IP-адрес корректен.");
        } else {
            System.out.println("IP-адрес некорректен.");
        }
    }

    public static boolean isValidIPAddress(String ipAddress) {
        try {
            String ipPattern = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
            Pattern pattern = Pattern.compile(ipPattern);
            Matcher matcher = pattern.matcher(ipAddress);

            return matcher.matches();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при проверке IP-адреса: " + e.getMessage());
            return false;
        }
    }
}

