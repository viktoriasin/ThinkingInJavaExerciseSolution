package exercises;


import java.util.Arrays;

public class _15_03_ArrayInitializationHigherDimesions {
    public static double[][] initializeArray(int sizeOne, int sizeTwo, double startValue, double endValue) {
        if (startValue > endValue) {
            return null;
        }
        if (sizeOne < 0 || sizeTwo < 0) {
            return null;
        }
        double[][] res = new double[sizeOne][sizeTwo];
        for (int i = 0; i < sizeOne; i++) {
            double curValue = startValue;
            for (int j = 0; j < sizeTwo; j++) {
                if (curValue <= endValue) {
                    res[i][j] = curValue++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void printArray(double[][] array) {
        System.out.println(Arrays.deepToString(array));
    }

    public static void main(String[] args) {
        double[][] array = initializeArray(5, 5, -11.12, 11);
        printArray(array);
    }
}
