package exercises;

import java.util.*;

class SortedSet<E> extends LinkedList<E> {

    public boolean add(E x) {
        if (contains(x)) {
            return false;
        }
        super.add(x);
        sort(null);
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        Iterator<? extends E> it = c.iterator();
        while (it.hasNext()) {
            E elem = it.next();
            if (!contains(elem)) {
                add(elem);
            }
        }
        return true;
    }

    public Object first() {
        return getFirst();
    }

    public Object last() {
        return getLast();
    }

    public SortedSet<E> subSet(E fromElement, E toElement) {
        SortedSet<E> res = new SortedSet<E>();
        Iterator<E> it = listIterator(indexOf(fromElement));
        while (it.hasNext()) {
            E next = it.next();
            if (next.equals(toElement)) {
                break;
            }
            res.add(next);
        }
        return res;
    }

    public SortedSet<E> headSet(E toElement) {
        return subSet(getFirst(), toElement);
    }

    public SortedSet<E> tailSet(E toElement) {
        return subSet(toElement, null);
    }

}

public class _16_10_SortedSetImplementation {
    public static void main(String[] args) {
        SortedSet<Integer> obj = new SortedSet<Integer>();
        obj.add(2);
        obj.add(0);
        obj.add(5);
        obj.add(3);
        System.out.println(obj);
        obj.addAll(Arrays.asList(9, 1, 5));
        System.out.println(obj);
        System.out.println(obj.first());
        System.out.println(obj.last());
        SortedSet<Integer> subset = obj.subSet(1, 5);
        System.out.println(subset);
        SortedSet<Integer> subset2 = obj.headSet(9);
        System.out.println(subset2);
        SortedSet<Integer> subset3 = obj.tailSet(3);
        System.out.println(subset3);
        subset3.remove();
        System.out.println(subset3);
    }
}
