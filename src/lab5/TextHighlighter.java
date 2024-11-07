package lab5;

public class TextHighlighter {
    public static void main(String[] args) {
        String text = "This is a sampleText with mixedCase and camelCaseExample.";
        System.out.println("Исходный текст: " + text);

        String highlightedText = highlightLowerUpperCases(text);

        System.out.println("Текст с выделением: " + highlightedText);
    }

    public static String highlightLowerUpperCases(String text) {
        try {
            String pattern = "(?<=[a-z])(?=[A-Z])";
            return text.replaceAll(pattern, "!");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при обработке текста: " + e.getMessage());
            return text;
        }
    }
}

