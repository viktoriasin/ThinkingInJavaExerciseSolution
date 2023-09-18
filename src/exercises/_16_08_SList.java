package exercises;

import java.util.ArrayList;
import java.util.NoSuchElementException;

interface ListIteratorSListInterface<E> {
    boolean hasNext();
    void add(E item);
    SList.Link<E> next();
    void remove();
    SList.Link<E>  getCurent();
}

class SList<E> {
    Link<E> first;
    Link<E> current;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public static class Link<E> {
        E item;
        Link<E> next;
        Link(E item) {
            this.next = null;
            this.item = item;
        }

    }
    SList() {
        current = null;
    }

    private class ListIteratorSList<T>  implements ListIteratorSListInterface<T> {

        int nextIndex;
        public Link<T> currentNode;

        @SuppressWarnings("unchecked")
        ListIteratorSList() {
            currentNode = (Link<T>) first;
            nextIndex = 0;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }
        public Link<T> getCurent() {
            return currentNode;
        }

        @SuppressWarnings("unchecked")
        public void add(Object item) {
            Link<E> newLink = new Link<>((E) item);
            if (current == null) {
                first = newLink;
                currentNode = (Link<T>) first; // ????
                current = newLink;
                current.next = null;
            } else {
                current.next = newLink;
                current = newLink;
                newLink.next = null;
            }
            size++;
        }

        public Link<T> next() {
            if (hasNext()) {
                nextIndex++;
                Link<T> oldCurrent = currentNode;
                currentNode = currentNode.next;
                return oldCurrent;
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            Link<E> currentToRemove = first;
            for (int i = 0; i < size - 2; i++) {
                currentToRemove = currentToRemove.next;
            }
            currentToRemove.next = null;
            current = currentToRemove;
            current.next = null;
            size--;
        }
    }
    public ListIteratorSList<E> iterator() {
        return new ListIteratorSList<>();
    }



}

public class _16_08_SList {
    public static void main(String[] args) {
        SList<Integer> lst = new SList<>();
        ListIteratorSListInterface<Integer> it = lst.iterator();
        System.out.println(it.hasNext());
        it.add(2);
        System.out.println(lst.current.item + " " + lst.first.item);
        it.add(3);
        System.out.println(lst.current.item + " " + lst.first.item);
        it.add(4);
        System.out.println(lst.current.item + " " + lst.first.item);

        while (it.hasNext()) {
            System.out.println(it.next().item);
        }
        System.out.println(lst.current.item);
        it.remove();
        System.out.println(lst.current.item);

        ListIteratorSListInterface<Integer> it2 = lst.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next().item);
        }
    }
}



