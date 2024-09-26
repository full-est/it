public class Tasks {
    //    1
    public static double convert(int gallon) {
        return gallon * 3.785;
    }

    //    2
    public static int fitcalc(int minute, int intens) {
        return minute * intens;
    }

//        3
    public static int getTotalItems(int boxes, int bags, int barrels) {
        int itemsInBox = 20;
        int itemsInBag = 50;
        int itemsInBarrel = 100;
        return (boxes * itemsInBox) + (bags * itemsInBag) + (barrels * itemsInBarrel);
    }

    //    4
    public static String triangleType(int X, int Y, int Z) {
        if (X + Y <= Z || X + Z <= Y || Y + Z <= X) {
            return "не является треугольником";
        }
        if (X == Y && Y == Z) {
            return "равносторонний";
        }

        if (X == Y || X == Z || Y == Z) {
            return "равнобедренный";
        }

        return "разносторонний";
    }

    //    5
    public static float comparison(float a, float b) {
        float c = a > b ? a : b;
        return c;
    }

    //    6
    public static int clothcalc(double n, double w, double h) {
        double pieces = n / (w * h);
        return (int) (pieces / 2);
    }

    //    7
    public static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    //    8
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    //    9
    public static double profitcalc(double a, double b) {
        double c = 0.72;
        double profit = a * b * c;
        return profit;
    }

    //    10
    public static int deskscalc(int students, int desks) {
        double a=Math.max(0, students-(desks * 2));
        double b=Math.ceil(a/2);
        return (int) b;
    }
}
