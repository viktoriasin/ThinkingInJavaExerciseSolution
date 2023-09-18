package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class _10_12_ListIterator {
    public static void main(String[] args) {
        List<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(2);
        i.add(3);
        List<Integer> i2 = new ArrayList<>(Arrays.asList(0,0,0));
        ListIterator<Integer> it = i.listIterator(i.size());
        while(it.hasPrevious())
            i2.set(it.previousIndex(), it.previous());
        System.out.println(i2);

    }
}
