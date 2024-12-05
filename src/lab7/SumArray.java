package lab7;

public class SumArray {
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 3, 4, 5.45, 6, 3.4, 7, 6};

        final double[] partialSums = new double[2];

        Thread firstHalfThread = new Thread(() -> {
            partialSums[0] = calculateSum(array, 0, array.length / 2);
        });

        Thread secondHalfThread = new Thread(() -> {
            partialSums[1] = calculateSum(array, array.length / 2, array.length);
        });

        firstHalfThread.start();
        secondHalfThread.start();

        try {
            firstHalfThread.join();
            secondHalfThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double totalSum = partialSums[0] + partialSums[1];

        System.out.println("Сумма элементов массива: " + totalSum);
    }

    private static double calculateSum ( double[] array, int start, int end){
        double sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
