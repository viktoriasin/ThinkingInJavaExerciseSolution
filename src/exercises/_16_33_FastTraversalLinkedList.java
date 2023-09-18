package exercises;

import java.util.*;

class FastTraversalLinkedList<E> extends AbstractList<E> {
    private List<E> data = new LinkedList<>();

    public boolean add(E element) {
        return data.add(element);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return data.addAll(collection);
    }

    public boolean remove(Object elem) {
        return data.remove(elem);
    }

    public E remove(int index) {
        return data.remove(index);
    }

    public void clear() {
        data.clear();
    }

    public E set(int index, E element) {
        return data.set(index, element);
    }

    public void add(int index, E element) {
        data.add(index, element);
    }

    private class InnerList<T> extends AbstractList<E> {
        @Override
        public int size() {
            return data.size();
        }

        @Override
        public E get(int index) {
            return data.get(index);
        }

        public boolean remove(Object elem) {
            return data.remove(elem);
        }

        public void clear() {
            data.clear();
        }

        public E set(int index, E element) {
            return data.set(index, element);
        }

        public void add(int index, E element) {
            data.add(index, element);
        }
    }

    public Iterator<E> iterator() {
        return new InnerList<E>().iterator();
    }

    public ListIterator<E> listIterator() {
        return new InnerList<E>().listIterator(0);
    }

    public ListIterator<E> listIterator(final int index) {
        return new ArrayList<E>(data).listIterator(index);
    }

    @Override
    public E get(int index) {
        Iterator<E> it = iterator();
        int counter = 0;
        while (it.hasNext()) {
            if (counter == index) {
                break;
            }
            it.next();
            counter++;
        }
        return it.next();
    }

    @Override
    public int size() {
        return data.size();
    }
}

public class _16_33_FastTraversalLinkedList {
    public static void main(String[] args) {
        FastTraversalLinkedList<Integer> fastList = new FastTraversalLinkedList<Integer>();
        fastList.add(1);
        fastList.add(2);
        fastList.add(3);
        fastList.add(4);
        ListIterator<Integer> it = fastList.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        fastList.remove(fastList.size() - 1);
        ListIterator<Integer> it2 = fastList.listIterator();
        while (it2.hasNext()) {
            it2.next();
            it2.add(9);
        }
        System.out.println(fastList);
    }
}
