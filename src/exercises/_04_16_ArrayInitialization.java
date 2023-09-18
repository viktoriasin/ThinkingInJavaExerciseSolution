package exercises;

import java.util.*;

public class _04_16_ArrayInitialization {

    public static void main(String[] args) {
        Random rand = new Random(47);
        String[] s = new String[rand.nextInt(10)];
        for (int i = 0; i < s.length; i++) {
            s[i] = Integer.toString(rand.nextInt(20));
        }

        for (String m : s) {
            System.out.println(m);
        }
    }
}
