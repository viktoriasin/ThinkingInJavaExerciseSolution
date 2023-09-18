package exercises;


import java.util.*;

class Generator {
    private static Random rand = new Random(47);
    private static String[] listOfMovies = {
            "Rancho Notorious",
            "The Assassination of Jesse James by the Coward Robert Ford",
            "Red River",
            "High Noon"
    };

    static String next() {
        int idx = rand.nextInt(listOfMovies.length);
        return listOfMovies[idx];
    }
}

public class _10_04_GeneratorOfMovies {
    public static void main(String[] args) {
        Generator gen = new Generator();
        ArrayList<String> array = new ArrayList<String>();
        LinkedList<String> linkedArray = new LinkedList<String>();
        HashSet<String> hashSet = new HashSet<String>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        TreeSet<String> treeSet = new TreeSet<String>();


        for (int i = 0; i < 5; i++) {
            array.add(gen.next());
            linkedArray.add(gen.next());
            hashSet.add(gen.next());
            linkedHashSet.add(gen.next());
            treeSet.add(gen.next());
        }

        System.out.println("Array");
        for (String s : array) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("linkedArray");
        for (String s : linkedArray) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("hashSet");
        for (String s : hashSet) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("linkedHashSet");
        for (String s : linkedHashSet) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("treeSet");
        for (String s : treeSet) {
            System.out.println(s);
        }
        System.out.println();
    }
}
