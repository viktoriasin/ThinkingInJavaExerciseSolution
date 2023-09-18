package exercises;

import java.util.Arrays;

public class _15_07_CreatingArrayOfNonPrimitiveValues {
    public static BerylliumSphere[][] createAndFillArray(int sizeOne, int sizeTwo) {
        BerylliumSphere[][] res = new BerylliumSphere[sizeOne][sizeTwo];
        for (int i = 0; i < sizeOne; i++) {
            for (int j = 0; j < sizeTwo; j++) {
                res[i][j] = new BerylliumSphere();
            }
        }
        return res;
    }

    public static void printArray(BerylliumSphere[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        BerylliumSphere[][] array = createAndFillArray(7, 7);
        printArray(array);
    }
}
