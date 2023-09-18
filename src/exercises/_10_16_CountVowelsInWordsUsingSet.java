package exercises;


import jdk.nashorn.internal.runtime.PropertyMap;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _10_16_CountVowelsInWordsUsingSet {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>();
        Collections.addAll(set1,
                "A E I O U".split(" "));
        for (String s : "Word Hello House".split(" ")) {
            int counter = 0;
            System.out.print("Word: " + s);
            for (String v : s.split("")) {
                if (set1.contains(v.toUpperCase())) {
                    counter++;
                }
            }
            System.out.println(String.format(" has %d vowels", counter));
        }
    }
}
