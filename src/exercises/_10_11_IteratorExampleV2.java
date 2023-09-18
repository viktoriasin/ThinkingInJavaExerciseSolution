package exercises;

import java.util.*;

public class _10_11_IteratorExampleV2 {
    public static void iterateSequence(Collection<Object> c) { // если указать как Collection c, то не придется приводить к Object у переменных. Почему так работает?
        Iterator<Object> it = c.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Collection<Object> i1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collection<Object> i2 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Object> i3 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 5, 7, 7));
        Collection<Object> i4 = new TreeSet<>(Arrays.asList("Hello", "World", "!"));

        iterateSequence(i1);
        iterateSequence(i2);
        iterateSequence(i3);
        iterateSequence(i4);
    }
}
