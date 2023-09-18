package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import testPackage.Countries;

public class _16_07_InsertintInListUsingIterator {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>(Countries.names(7));
        List<String> lst2 = new ArrayList<>(Arrays.asList("S", "A", "G", "K", "L", "M", "N", "P"));
        ListIterator<String> it = lst.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();

        ListIterator<String> it2 = lst2.listIterator();
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }

        System.out.println();

        ListIterator<String> itToInsert = lst.listIterator();
        ListIterator<String> itToInsert2 = lst2.listIterator();

        while (itToInsert.hasNext()) {
            String toInsert = itToInsert2.next();
            itToInsert.add(toInsert);
            String next = itToInsert.next();

        }

        System.out.println(lst);

        List<String> lst3 = new ArrayList<>(Countries.names(7));
        List<String> lst4 = new ArrayList<>(Arrays.asList("S", "A", "G", "K", "L", "M", "N", "P"));

        ListIterator<String> itToInsertBackward = lst3.listIterator(lst3.size());
        ListIterator<String> itToInsertBackward2 = lst4.listIterator(lst4.size());

        while (itToInsertBackward.hasPrevious()) {

            String toInsert = itToInsertBackward2.previous();
            itToInsertBackward.add(toInsert);
            itToInsertBackward.previous();
            itToInsertBackward.previous();



        }

        System.out.println(lst3);

    }
}
