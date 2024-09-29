import java.util.Arrays;

public class Tasks2 {
    //    1
    public static String duplicateChars(String str1, String str2) {

        StringBuilder result = new StringBuilder();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (str2.indexOf(ch) == -1) {
                result.append(ch);
            }
        }

        return result.toString();
    }

//            public static void main(String[] args) {
//                System.out.println(duplicateChars("Barack", "Obama"));
//    }

    //    2
    public static int dividedByThree(int[] array) {
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] % 3 == 0) {
                result++;
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        int[] array ={3, 12, 7, 81, 52, -81, 15,-15,534,35,2};
//        System.out.println(dividedByThree(array));
//    }

    //    3
    public static String getInitials(String fullName) {
        String[] parts = fullName.split(" ");

        String surname = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase();

        String initials = "";
        for (int i = 1; i < parts.length; i++) {
            initials += parts[i].substring(0, 1).toUpperCase() + ".";
        }
        return initials + surname;
    }

//    public static void main(String[] args) {
//        System.out.println(getInitials("simonov sergei evgenievich"));  // S.E.Simonov
//        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));  // T.V.Kozhevnikova
//    }

//         4
    public static double[] normalizator(double[] arr) {
        double min = Arrays.stream(arr).min().getAsDouble();
        double max = Arrays.stream(arr).max().getAsDouble();

        if (min == max) {
            return new double[arr.length];
        }

        double[] normalizedArray = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            normalizedArray[i] = (arr[i] - min) / (max - min);
        }

        return normalizedArray;
    }

//    public static void main(String[] args) {
//        double[] arr1 = {3.5, 7.0, 1.5, 9.0, 5.5};
//        double[] normalized1 = normalizator(arr1);
//        System.out.println(Arrays.toString(normalized1));
//
//        double[] arr2 = {10.0, 10.0, 10.0, 10.0};
//        double[] normalized2 = normalizator(arr2);
//        System.out.println(Arrays.toString(normalized2));

//    5
    public static int[] compressedNums(double[] arr) {
        return Arrays.stream(arr)
                .filter(num -> num != 0)
                .mapToInt(num -> (int) Math.floor(num))
                .distinct()
                .sorted()
                .toArray();
    }

//    public static void main(String[] args) {
//        double[] arr = {1.6, 0, 212.3, 34.8, 0, 27.5};
//        int[] compressed = compressedNums(arr);
//        System.out.println(Arrays.toString(compressed));  // [1, 27, 34, 212]
//    }

//    6
public static String camelToSnake(String camelCaseStr) {
    return camelCaseStr
            .replaceAll("([a-z])([A-Z])", "$1_$2")
            .toLowerCase();
}

//    public static void main(String[] args) {
//        System.out.println(camelToSnake("helloWorld"));  // hello_world
//        System.out.println(camelToSnake("thisIsCamelCase"));  // this_is_camel_case
//    }

//    7
public static int secondBiggest(int[] arr) {
    if (arr.length < 2) {
        throw new IllegalArgumentException("Массив должен содержать как минимум 2 элемента");
    }

    // Удаляем дубликаты, сортируем по убыванию
    return Arrays.stream(arr)
            .distinct()
            .sorted()
            .toArray()[arr.length - 2];
}

//    public static void main(String[] args) {
//        int[] array = {3, 5, 8, 1, 2, 4};
//        System.out.println(secondBiggest(array));  // Вывод: 5
//    }

//    8
public static String localReverse(String str, char marker) {
    StringBuilder result = new StringBuilder();
    StringBuilder partToReverse = new StringBuilder();
    boolean insideMarkers = false;

    for (char ch : str.toCharArray()) {
        if (ch == marker) {
            if (insideMarkers) {
                result.append(partToReverse.reverse());
                partToReverse.setLength(0);
            }
            result.append(ch);
            insideMarkers = !insideMarkers;
        } else {
            if (insideMarkers) {
                partToReverse.append(ch);
            } else {
                result.append(ch);
            }
        }
    }
    return result.toString();
}

//    public static void main(String[] args) {
//        System.out.println(localReverse("baobab", 'b'));
//        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));
//    }

//    9
public static int equal(int a, int b, int c) {
    if (a == b && b == c) {
        return 3;
    } else if (a == b || a == c || b == c) {
        return 2;
    } else {
        return 0;
    }
}

//    public static void main(String[] args) {
//        System.out.println(equal(8, 1, 8));  // Вывод: 2
//        System.out.println(equal(5, 5, 5));  // Вывод: 3
//        System.out.println(equal(4, 9, 6));  // Вывод: 0
//    }

//    10
public static boolean isAnagram(String str1, String str2) {
    String cleanedStr1 = str1.toLowerCase().replaceAll("[^a-z]", "");
    String cleanedStr2 = str2.toLowerCase().replaceAll("[^a-z]", "");

    if (cleanedStr1.length() != cleanedStr2.length()) {
        return false;
    }

    char[] charArray1 = cleanedStr1.toCharArray();
    char[] charArray2 = cleanedStr2.toCharArray();

    Arrays.sort(charArray1);
    Arrays.sort(charArray2);

    return Arrays.equals(charArray1, charArray2);
}

//    public static void main(String[] args) {
//        System.out.println(isAnagram("LISTEN", "silent"));
//        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
//        System.out.println(isAnagram("hello", "world"));
//    }
}

