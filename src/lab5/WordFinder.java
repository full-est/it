package lab5;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class WordFinder {
    public static void main(String[] args) {
        String text = "Apple and apricot are amazing fruits, while bananas and berries are also popular.";
        char startingLetter = 'b';

        List<String> words = findWordsStartingWith(text, startingLetter);
        System.out.println("Слова, начинающиеся с буквы '" + startingLetter + "': " + words);
    }

    public static List<String> findWordsStartingWith(String text, char startingLetter) {
        List<String> result = new ArrayList<>();
        try {
            String pattern = "\\b" + startingLetter + "\\w*\\b";
            Pattern compiledPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = compiledPattern.matcher(text);

            while (matcher.find()) {
                result.add(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при обработке текста: " + e.getMessage());
        }
        return result;
    }
}

