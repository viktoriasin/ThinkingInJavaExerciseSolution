package exercises;


import java.util.LinkedList;
import java.util.ListIterator;

public class _10_14_InsertInTHeMiddleUsingListIterator {
    public static ListIterator<Integer> addInTheMiddle(LinkedList<Integer> l) {
        return l.listIterator(l.size()  /2);
    }
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        addInTheMiddle(l).add(1);
        System.out.println(l);
        addInTheMiddle(l).add(2);
        System.out.println(l);
        addInTheMiddle(l).add(3);
        System.out.println(l);
        addInTheMiddle(l).add(4);
        System.out.println(l);
        addInTheMiddle(l).add(5);
        System.out.println(l);

    }
}
