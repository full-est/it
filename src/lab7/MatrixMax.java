package lab7;

public class MatrixMax {
    public static void main(String [] args){
        double[][] matrix = {
                {3, 5, 9, 12.6},
                {15.8, 8, 7.2, 20},
                {11, 14.3, 6, 19},
                {2.1, 10, 4, 18}
        };

        final double[] rowMax = new double[matrix.length];

        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            final int rowIndex = i;
            threads[i] = new Thread(() -> {
                rowMax[rowIndex] = findMax(matrix[rowIndex]);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double overallMax = findMax(rowMax);

        System.out.println("Наибольший элемент в матрице: " + overallMax);
    }

    private static double findMax(double[] row) {
        double max = row[0];
        for (double value : row) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
