package exercises;

import java.util.*;

public class _10_20_HashMapToCountOccurence {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>();

        Map<String,Integer> m =
                new HashMap<String,Integer>();
        Collections.addAll(set1,
                "A E I O U".split(" "));
        for (String s : "Word Hello House".split(" ")) {
            int counter = 0;
            System.out.print("Word: " + s);
            for (String v : s.split("")) {
                if (set1.contains(v.toUpperCase())) {
                    counter++;
                    Integer freq = m.get(v.toUpperCase());
                    m.put(v.toUpperCase(), freq == null ? 1 : freq + 1);
                }
            }
            System.out.println(String.format(" has %d vowels", counter));
        }
        System.out.println(m);
    }
}


