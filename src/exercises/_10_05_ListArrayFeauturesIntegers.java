package exercises;

import java.util.*;

public class _10_05_ListArrayFeauturesIntegers {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> qw = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 4, 5));
        System.out.println("1: " + qw);

        Integer h = new Integer(5);
        qw.add(h); // Automatic// ally resizes
        System.out.println("2: " + qw);


        System.out.println("3: " + qw.contains(h));
        qw.remove(h); // Remove the first equvalince to h
        System.out.println("3.5: " + qw);


        Integer p = qw.get(2);
        System.out.println("4: " + p + " " + qw.indexOf(p));
        System.out.println("4.5: 5"  + " " + qw.indexOf(5));


        Integer cymric = new Integer(11);
        System.out.println("5: " + qw.indexOf(cymric));
        System.out.println("6: " + qw.remove(cymric));
        // Must be the exact object:


        System.out.println("7: " + qw.remove(p));
        System.out.println("8: " + qw);


        qw.add(3, new Integer(111));
        System.out.println("9: " + qw);


        List<Integer> sub = qw.subList(1, 4);
        System.out.println("subList: " + sub);


        System.out.println("10: " + qw.containsAll(sub));
        Collections.sort(sub); // In-place sort
        System.out.println("sorted subList: " + sub);
        // Order is not important in containsAll():
        System.out.println("11: " + qw.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + qw.containsAll(sub));


        List<Integer> copy = new ArrayList<Integer>(qw);
        sub = Arrays.asList(qw.get(1), qw.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<Integer>(qw); // Get a fresh copy
        copy.remove(2); // Remove by index
        System.out.println("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        System.out.println("15: " + copy);
        copy.set(1, new Integer(119)); // Replace an element
        System.out.println("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        System.out.println("17: " + copy);
        System.out.println("18: " + qw.isEmpty());
        qw.clear(); // Remove all elements
        System.out.println("19: " + qw);
        System.out.println("20: " + qw.isEmpty());
        qw.addAll( new ArrayList<Integer>(Arrays.asList(117, 121)));
        System.out.println("21: " + qw);
        Object[] o = qw.toArray();
        System.out.println("22: " + o[3]);

    }
}
