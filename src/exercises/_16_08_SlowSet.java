package exercises;


import java.util.*;

class SlowSet<E> extends AbstractSet<E> {

    private List<E> data = new ArrayList<E>();

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public boolean contains(Object o) {
        return data.contains(o);
    }

    public Object[] toArray() {
        return data.toArray();
    }

    public boolean add(E elem) {
        if (!contains(elem)) {
            return data.add(elem);
        }
        return false;
    }

    public boolean remove(Object elem) {
        return data.remove(elem);
    }

    public void clear() {
        data.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    @Override
    public int size() {
        return data.size();
    }
}

public class _16_08_SlowSet {
    public static void main(String[] args) {
        SlowSet<Integer> slowSet = new SlowSet<>();
        slowSet.add(2);
        slowSet.add(2);
        slowSet.add(3);
        slowSet.add(4);
        slowSet.add(5);
        System.out.println(slowSet);
        slowSet.remove(2);
        System.out.println(slowSet);
        slowSet.clear();
        System.out.println(slowSet);
    }
}
