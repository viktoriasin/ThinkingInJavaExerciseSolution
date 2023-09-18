package exercises;

import java.util.*;

public class _10_18_HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> h = new HashMap<>();
        h.put(100, "Gavilar");
        h.put(5, "Dallinor");
        h.put(4, "Liver");
        h.put(3, "Matt");
        h.put(2, "Oliver");
        h.put(1, "Katty");


//        for (Map.Entry<Integer, String> f : h.entrySet()) {
//            System.out.println("Key: " + f.getKey() + " Value: " + f.getValue());
//        }

        System.out.println(h);

        List<Integer> list = new ArrayList<>(h.keySet());

        System.out.println(list);
        list.sort(Collections.reverseOrder());
        System.out.println(list);

        Map<Integer, String> newMap = new LinkedHashMap<>();
        for (int i : list) {
            newMap.put(i, h.get(i));
        }

        System.out.println(newMap);


    }
}
