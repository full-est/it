import java.util.Arrays;

public class Tasks3 {
    //    1
    public static boolean isStrangePair(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return false;
        }
        return str1.charAt(0) == str2.charAt(str2.length() - 1) &&
                str1.charAt(str1.length() - 1) == str2.charAt(0);
    }
//    public static void main(String[] args) {
//        System.out.println(isStrangePair("ratio", "orator"));
//        System.out.println(isStrangePair("spark", "kite"));
//    }

    //    2
    public static String[][] applyDiscount(String[][] products, int discount) {
        for (int i = 0; i < products.length; i++) {
            String name = products[i][0];
            double price = Double.parseDouble(products[i][1]);
            int newPrice = (int) Math.round(price * (100 - discount) / 100);
            newPrice = Math.max(newPrice, 1);
            products[i][1] = String.valueOf(newPrice);
        }
        return products;
    }
//    public static void main(String[] args) {
//        String[][] products = {
//                {"Laptop", "124200"},
//                {"Phone", "51450"},
//                {"Headphones", "13800"}
//        };
//
//        String[][] result = applyDiscount(products, 25);
//
//        Arrays.stream(result).forEach(product ->
//                System.out.println(product[0] + ": " + product[1])
//        );
//    }

    //    3
    public static boolean successShot(double x, double y, double r, double m, double n) {
        double distance = Math.sqrt(Math.pow(m - x, 2) + Math.pow(n - y, 2));
        return distance <= r;
    }
//    public static void main(String[] args) {
//        System.out.println(successShot(0, 0, 5, 2, 2));  // ➞ true
//        System.out.println(successShot(-2, -3, 4, 5, -6));  // ➞ false
//    }

    //    4
    public static boolean parityAnalysis(int a) {
        int sum = 0;
        int num = a;
        boolean isNumOdd = num % 2 != 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        boolean isSumOdd = sum % 2 != 0;

        return (isSumOdd == isNumOdd);
    }
//    public static void main(String[] args) {
//        System.out.println(parityAnalysis(243));
//    }

    //    5
    public static String rps(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Ничья";
        }
        switch (player1) {
            case "камень":
                return player2.equals("ножницы") ? "Игрок 1 выигрывает" : "Игрок 2 выигрывает";
            case "ножницы":
                return player2.equals("бумага") ? "Игрок 1 выигрывает" : "Игрок 2 выигрывает";
            case "бумага":
                return player2.equals("камень") ? "Игрок 1 выигрывает" : "Игрок 2 выигрывает";
            default:
                return "Неправильный ввод";
        }
    }

//    public static void main(String[] args) {
//        System.out.println(rps("камень", "бумага"));
//        System.out.println(rps("ножницы", "бумага"));
//        System.out.println(rps("бумага", "бумага"));
//    }

//    6
    public static int bugger(int num) {
        int count = 0;

        while (num >= 10) {
            int product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }
            num = product;
            count++;
        }

        return count;
    }

//    public static void main(String[] args) {
//        System.out.println(bugger(39));  // ➞ 3
//        System.out.println(bugger(999)); // ➞ 4
//        System.out.println(bugger(4));   // ➞ 0
//    }

//    7
    public static String mostExpensive(String[][] items) {
        String mostExpensiveItem = "";
        int maxTotalValue = 0;

        for (String[] item : items) {
            String name = item[0];
            int price = Integer.parseInt(item[1]);
            int quantity = Integer.parseInt(item[2]);
            int totalValue = price * quantity;
            if (totalValue > maxTotalValue) {
                maxTotalValue = totalValue;
                mostExpensiveItem = name;
            }
        }
        return "Наиб. общ. стоимость у предмета " + mostExpensiveItem + " - " + maxTotalValue;
    }

//    public static void main(String[] args) {
//        String[][] inventory = {
//                {"Скакалка", "550", "8"},
//                {"Шлем", "3750", "4"},
//                {"Мяч", "2900", "10"}
//        };
//        System.out.println(mostExpensive(inventory));
//    }

//    8
    public static String longestUnique(String str) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        String longestSubstring = "";
        char[] charArray = new char[256];

        while (right < str.length()) {
            char letter = str.charAt(right);

            if (charArray[letter] == 0) {
                charArray[letter]++;
            } else {
                while (charArray[letter] > 0) {
                    charArray[str.charAt(left)]--;
                    left++;
                }
                charArray[letter]++;
            }

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                longestSubstring = str.substring(left, right + 1);
            }

            right++;
        }

        return longestSubstring;
    }

//    public static void main(String[] args) {
//        System.out.println(longestUnique("abcba"));
//        System.out.println(longestUnique("bbb"));
//        System.out.println(longestUnique("abacabad"));
//    }

//    9
    public static boolean isPrefix(String word, String prefix) {
        if (prefix.endsWith("-")) {
            prefix = prefix.substring(0, prefix.length() - 1);
        }
        return word.startsWith(prefix);
    }

    public static boolean isSuffix(String word, String suffix) {
        if (suffix.startsWith("-")) {
            suffix = suffix.substring(1);
        }
        return word.endsWith(suffix);
    }

//    public static void main(String[] args) {
//        System.out.println(isPrefix("automation", "auto-"));
//        System.out.println(isSuffix("arachnophobia", "-phobia"));
//        System.out.println(isPrefix("retrospect", "sub-"));
//        System.out.println(isSuffix("vocation", "-logy"));
//    }

//    10
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        int[] brickParams = {a, b, c};
        Arrays.sort(brickParams);

        int[] holeParams = {w, h};
        Arrays.sort(holeParams);

        return (brickParams[0] <= holeParams[0]) && (brickParams[1] <= holeParams[1]);
    }

    public static void main(String[] args) {
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));  // ➞ true
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));  // ➞ true
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));  // ➞ false
    }
}
