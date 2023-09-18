package exercises;

import java.util.*;

class SimpleHashSet<E> extends AbstractSet<E> {

    static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    LinkedList<E>[] buckets = new LinkedList[SIZE];

    public boolean add(E e) {
        boolean added = false;
        int index = Math.abs(e.hashCode()) % SIZE;

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<E>();
        }
        LinkedList<E> bucket = buckets[index];

        if (!bucket.contains(e)) {
            bucket.add(e);
            added = true;
        }
        return added;
    }

    public boolean remove(Object e) {
        int index = Math.abs(e.hashCode()) % SIZE;
        if (buckets[index] != null && buckets[index].contains(e)) {
            buckets[index].remove(e);
            return true;
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean isModified = false;
        for (E e : c) {
            isModified |= add(e);
        }
        return isModified;
    }

    public boolean contains(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        return buckets[index] != null && buckets[index].contains(o);
    }

    public boolean isEmpty() {
        for (LinkedList<E> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            if (!bucket.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        Arrays.fill(buckets, null);
    }

    @Override
    public Iterator<E> iterator() {
        Set<E> tempSet = new HashSet<>();
        for (LinkedList<E> bucket : buckets) {
            if (bucket == null) {
                continue;
            } else {
                tempSet.addAll(bucket);
            }
        }
        return tempSet.iterator();
    }

    @Override
    public int size() {
        int counter = 0;
        for (LinkedList<E> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (E elem : bucket) {
                counter++;
            }
        }
        return counter;
    }
}

public class _16_24_SimpleHashSet {
    public static void main(String[] args) {
        SimpleHashSet<Integer> simpleSet = new SimpleHashSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(4);
        simpleSet.add(5);
        simpleSet.add(6);
        System.out.println(simpleSet);
        simpleSet.remove(3);
        System.out.println(simpleSet);
        Set<Integer> tempSet = new HashSet<>();
        tempSet.add(2);
        tempSet.add(11);
        tempSet.add(17);
        simpleSet.addAll(tempSet);
        System.out.println(simpleSet);
        System.out.println(simpleSet.contains(17));
        System.out.println(simpleSet.contains(21));
        System.out.println(simpleSet.size());
        System.out.println(simpleSet.isEmpty());
        simpleSet.clear();
        System.out.println(simpleSet.size());
        System.out.println(simpleSet.isEmpty());
        System.out.println(simpleSet);
    }
}
