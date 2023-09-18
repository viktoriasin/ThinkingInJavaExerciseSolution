package exercises;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class _15_21_ComparingArrays {
    public static void main(String[] args) {
        BerylliumSphere[] b = new BerylliumSphere[10];
        for (int i = 0; i < b.length; i++) {
            b[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(b));
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        Arrays.sort(b, Collections.reverseOrder());
        System.out.println(Arrays.toString(b));

    }
}
