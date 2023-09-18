package exercises;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public class _16_38_TestingHashMapLoadFactor {
     public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
         HashMap<Integer, Integer> testHashMap1 = new HashMap<>();
         System.out.println("Initial load factor: " + (1.0 * testHashMap1.size()) / (1 << 4));
         for (int i = 0; i < 20000; i++) {
             testHashMap1.put(i, i);
         }
         Field f1 = testHashMap1.getClass().getDeclaredField("table");
         f1.setAccessible(true);
         Object[] capacity = (Object[]) f1.get(testHashMap1);
         System.out.println(capacity.length);
         System.out.println("Load factor after loading some elements: " + (1.0 * testHashMap1.size()) / (capacity.length));
     }
}
