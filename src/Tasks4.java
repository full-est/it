import java.util.*;
import java.util.regex.*;

public class Tasks4 {
//    1
    public static String nonRepeat(String str) {
        str = str.toLowerCase();
        return removeExcessCharacters(str);
    }

    private static String removeExcessCharacters(String str) {
        if (str.isEmpty()) return str;

        StringBuilder result = new StringBuilder();
        boolean hasExcess = false;

        for (char ch : str.toCharArray()) {
            long count = str.chars().filter(c -> c == ch).count();
            if (count <= 3) {
                result.append(ch);
            } else {
                hasExcess = true;
            }
        }
        return hasExcess ? removeExcessCharacters(result.toString()) : result.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(nonRepeat("abracadabra"));  // ➞ "brcdbr"
//        System.out.println(nonRepeat("abababcc"));    // ➞ "bbbcc"
//    }

//    2
public static List<String> bruteForce(int n, int k) {
    List<String> result = new ArrayList<>();

    if (n > k) return result;

    char[] alphabet = new char[k];
    for (int i = 0; i < k; i++) {
        alphabet[i] = (char) ('0' + i);
    }

    generateCombinations(result, "", alphabet, n);
    return result;
}

    private static void generateCombinations(List<String> result, String current, char[] alphabet, int length) {
        if (current.length() == length) {
            result.add(current);
            return;
        }

        for (char ch : alphabet) {
            if (current.indexOf(ch) == -1) {
                generateCombinations(result, current + ch, alphabet, length);
            }
        }
    }

//    public static void main(String[] args) {
//        System.out.println(bruteForce(1, 5));  // ➞ ["0","1","2","3","4"]
//        System.out.println(bruteForce(2, 2));  // ➞ ["01", "10"]
//        System.out.println(bruteForce(5, 3));  // ➞ []
//    }

//    3
    public static int[] decode(String str, String key) {
        int[] decodedValues = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            decodedValues[i] = str.charAt(i) ^ key.charAt(i % key.length());
        }
        return decodedValues;
    }

    public static String encode(int[] values, String key) {
        StringBuilder encodedText = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            char encodedChar = (char) (values[i] ^ key.charAt(i % key.length()));
            encodedText.append(encodedChar);
        }
        return encodedText.toString();
    }

//    public static void main(String[] args) {
//        String str = "MTUCI";
//        String key = "MKIIT";
//
//        int[] decodedValues = decode(str, key);
//        System.out.print("Decoded: ");
//        for (int val : decodedValues) {
//            System.out.print(val + " ");
//        }
//        System.out.println();
//
//        int[] valuesToEncode = {0, 31, 28, 10, 29};
//        String encodedText = encode(valuesToEncode, key);
//        System.out.println("Encoded: " + encodedText);
//    }

//    4
    public static List<String> split(String str) {
        List<String> clusters = new ArrayList<>();
        int balance = 0;
        StringBuilder currentCluster = new StringBuilder();

        for (char ch : str.toCharArray()) {
            currentCluster.append(ch);

            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }

            if (balance == 0) {
                clusters.add(currentCluster.toString());
                currentCluster.setLength(0); // Сбрасываем кластер
            }
        }

        return clusters;
    }
//    public static void main(String[] args) {
//        System.out.println(split("()()()"));                 // ➞ ["()", "()", "()"]
//        System.out.println(split("((()))"));                 // ➞ ["((()))"]
//        System.out.println(split("((()))(())()()(()())"));   // ➞ ["((()))", "(())", "()", "()", "(()())"]
//        System.out.println(split("((())())(()(()()))"));     // ➞ ["((())())", "(()(()()))"]
//    }

//    5
    public static String shortHand(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= str.length(); i++) {
            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1));
                if (count > 1) {
                    result.append("*").append(count);
                }
                count = 1;
            }
        }

        return result.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(shortHand("abbccc"));         // ➞ "ab*2c*3"
//        System.out.println(shortHand("vvvvaajaaaaa"));   // ➞ "v*4a*2ja*5"
//    }

//    6
    public static String convertToRome(int number) {
        if (number < 1 || number > 1502) {
            throw new IllegalArgumentException("Число должно быть от 1 до 1502.");
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman.append(symbols[i]);
                number -= values[i];
            }
        }

        return roman.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(convertToRome(8));       // ➞ "VIII"
//        System.out.println(convertToRome(1234));    // ➞ "MCCXXXIV"
//        System.out.println(convertToRome(52));      // ➞ "LII"
//    }

//    7
    public static String uniqueSubstring(String s) {
        Map<Character, Integer> evenCounts = new HashMap<>();
        Map<Character, Integer> oddCounts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (i % 2 == 0) {
                evenCounts.put(currentChar, evenCounts.getOrDefault(currentChar, 0) + 1);
            } else {
                oddCounts.put(currentChar, oddCounts.getOrDefault(currentChar, 0) + 1);
            }
        }

        int maxEven = 0;
        int maxOdd = 0;

        for (int count : evenCounts.values()) {
            maxEven = Math.max(maxEven, count);
        }
        for (int count : oddCounts.values()) {
            maxOdd = Math.max(maxOdd, count);
        }

        return maxEven >= maxOdd ? "чет" : "нечет";
    }

//    public static void main(String[] args) {
//        System.out.println(uniqueSubstring("31312131"));       // ➞ "нечет"
//        System.out.println(uniqueSubstring("1111111"));        // ➞ "чет"
//        System.out.println(uniqueSubstring("12223234333"));    // ➞ "чет"
//    }

//    8
    private static int[] logic(int down, int right) {
        int[] res = new int[2];
        if (down > 0 && right > 0) {
            if (down > right) {
                res = new int[]{right, 1};
            } else {
                res = new int[]{down, 0};
            }
        } else if (Math.max(down, right) < 0) {
            res[0] = -1;
        }
        else if (down > 0) {
            res = new int[]{down, 0};
        } else {
            res = new int[]{right, 1};
        }
        return res;
    }
    public static List<String> labirint(int[][] matrix) {
        int n = matrix.length;
        int[][][] right_path = new int[n][n][2];

        for(int i = n - 1; i > -1; i--){
            for (int k = n - 1; k > -1; k--){
                if (matrix[i][k] < 0){
                    right_path[i][k][0] = -1;
                    continue;
                }
                if (i == n - 1 || k == n - 1){
                    if (i == n - 1 && k != n - 1){
                        right_path[i][k] = logic(-1, right_path[i][k + 1][0]);
                        right_path[i][k][0] += matrix[i][k];
                    } else if (i != n - 1 && k == n - 1) {
                        right_path[i][k] = logic(right_path[i + 1][k][0], -1);
                        right_path[i][k][0] += matrix[i][k];
                    }else{
                        right_path[i][k][0] = matrix[i][k];
                    }
                }else{
                    right_path[i][k] = logic(right_path[i + 1][k][0], right_path[i][k + 1][0]);
                    if (right_path[i][k][0] > 0){
                        right_path[i][k][0] += matrix[i][k];
                    }
                }
            }
        }
        ArrayList <String> res = new ArrayList<>();
        if (right_path[0][0][0] > 0){
            StringBuilder path = new StringBuilder();
            int l = 0, m = 0;
            for (int p = 0; p < 2 * n - 1; p ++){
                if (right_path[l][m][1] == 0){
                    path.append(matrix[l][m]).append("-");
                    l += 1;
                }else{
                    path.append(matrix[l][m]).append("-");
                    m += 1;
                }
            }

            res.add(path.reverse().substring(1));
            res.add(String.valueOf(right_path[0][0][0]));

        }else{
            res.add("Нет прохода");
        }
        return res;
    }

//    public static void main(String[] args) {
//        int[][] grid1 = {
//                {1, 3, 1},
//                {1, -1, 1},
//                {4, 2, 1}
//        };
//        System.out.println(labirint(grid1)); // ➞ ["1-1-1-3-1", "7"]
//
//        int[][] grid2 = {
//                {2, -7, 3},
//                {-4, -1, 8},
//                {4, 5, 9}
//        };
//        System.out.println(labirint(grid2)); // ➞ ["Прохода нет"]
//    }

//    9
    public static String numericOrder(String sentence) {
        String[] words = sentence.split(" ");
        TreeMap<Integer, String> orderedWords = new TreeMap<>();

        for (String word : words) {
            Matcher matcher = Pattern.compile("\\d").matcher(word);
            if (matcher.find()) {
                int position = Integer.parseInt(matcher.group());
                String cleanWord = word.replaceAll("\\d", "");
                orderedWords.put(position, cleanWord);
            }
        }

        return String.join(" ", orderedWords.values());
    }

//    public static void main(String[] args) {
//        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
//        // ➞ "One ring to rule them all"
//
//        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
//        // ➞ "With great power comes great responsibility"
//    }

//    10
    public static boolean fibString(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(charCount.values());
        Collections.sort(frequencies);

        List<Integer> fibonacciSeq = new ArrayList<>(Arrays.asList(1, 1));
        while (fibonacciSeq.size() < frequencies.size()) {
            int nextFib = fibonacciSeq.get(fibonacciSeq.size() - 1) + fibonacciSeq.get(fibonacciSeq.size() - 2);
            fibonacciSeq.add(nextFib);
        }

        for (int i = 0; i < frequencies.size(); i++) {
            if (!frequencies.get(i).equals(fibonacciSeq.get(i))) {
                return false;
            }
        }

        return true;
    }

//    public static void main(String[] args) {
//        System.out.println(fibString("CCCABDD")); // ➞ true
//        System.out.println(fibString("ABC"));      // ➞ false
//    }
}
