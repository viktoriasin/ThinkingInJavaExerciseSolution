package exercises;

import java.util.Arrays;

class TestComparisons implements Comparable<TestComparisons>  {
    private static int counter = 0;
    private final int id = counter;
    private int i;
    TestComparisons(int i) {
        this.i = i;
        counter++;
    }
    public int getI() {
        return i;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof  TestComparisons) {
            return i == ((TestComparisons) obj).getI();
        }
        return false;
    }

    @Override
    public int compareTo(TestComparisons o) {
        return Integer.compare(i, o.getI());
    }
}

public class _15_19_ComparingArraysOFObjects {
    public static void main(String[] args) {
        TestComparisons[] testV1 = {new TestComparisons(2), new TestComparisons(2)};
        TestComparisons[] testV2 = {new TestComparisons(2), new TestComparisons(2)};
        System.out.println(Arrays.equals(testV2, testV1));

    }
}
