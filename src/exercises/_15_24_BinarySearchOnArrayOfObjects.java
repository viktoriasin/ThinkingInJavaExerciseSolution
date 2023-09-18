package exercises;

import java.util.Arrays;

public class _15_24_BinarySearchOnArrayOfObjects {
    public static void main(String[] args) {
        TestComparisons[] gGj = new TestComparisons[5];
        for (int i = 0; i < gGj.length; i++) {
            gGj[i] = new TestComparisons(i);
        }

        System.out.println(Arrays.binarySearch(gGj, gGj[2]));
    }
}
