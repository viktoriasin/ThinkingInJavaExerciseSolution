package kontestTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class testTaskStonesAndJewelry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputJewelry = reader.readLine().trim().split("");
        String[] inputStones = reader.readLine().trim().split("");
        HashSet<String> alreadyCount = new HashSet<>();
        int total = 0;
            for (String j : inputJewelry) {
                if (!alreadyCount.contains(j)) {
                    for (String s : inputStones) {
                        if (j.equals(s) && !j.equals("")) {
                            total++;
                        }
                    }
                    alreadyCount.add(j);
                }
        }
        System.out.println(total);
    }
}

// Решение преподавателей
//public class WooHoo {
//    public static void main(String[] args) throws Exception {
//        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//
//        String J = r.readLine();
//        String S = r.readLine();
//
//        int result = 0;
//        for (int i = 0; i < S.length(); ++i) {
//            char ch = S.charAt(i);
//            if (J.indexOf(ch) >= 0) {
//                ++result;
//            }
//        }
//
//        System.out.println(result);
//    }
//}
