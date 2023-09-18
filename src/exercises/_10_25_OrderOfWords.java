package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _10_25_OrderOfWords {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> data = new HashMap<>();
        int counter = 0;
        for (String s : "Generic classes and methods have type parameters. have classes Generic methods algorithms have other".split(" ")) {
            s = s.toUpperCase();
            if (data.containsKey(s)) {
                data.get(s).add(counter++);
            } else {
                data.put(s.toUpperCase(), new ArrayList<Integer>());
                data.get(s).add(counter++);
            }
        }
        System.out.println(data);

        String[] words = new String[counter];
        for (Map.Entry<String, ArrayList<Integer>> f : data.entrySet()) {
            for (int idx : f.getValue()) {
                words[idx] = f.getKey();
            }
        }
        System.out.println(String.join(" ", words));
    }
}
