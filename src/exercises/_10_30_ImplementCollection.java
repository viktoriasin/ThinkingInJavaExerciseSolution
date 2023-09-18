package exercises;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class Pet {
    private static int idx = 0;
    final int counter = idx++;


    public static Pet[] createArray(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            pets[i] = new Pet();
        }
        return pets;
    }

}

class CollectionSequence<Pet> implements Collection<Pet> {
    private exercises.Pet[] pets = exercises.Pet.createArray(8);
    public int size() { return pets.length; }

    @Override
    public boolean isEmpty() {
        return pets.length == 0;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < pets.length; i++ ) {
            if (pets[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<exercises.Pet>() {
            private int index = 0;

            public boolean hasNext() {
                return index < pets.length;
            }

            public exercises.Pet next() {
                return pets[index++];
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public Object[] toArray() {
        return pets;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < pets.length; i++ ) {
            if (pets[i].equals(o)) {
                pets[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        pets = null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (int i = 0; i < c.size(); i++ ) {
                c = null;
            }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new List[]{Arrays.asList(a)};
    }

    public void printPet() {
        for (exercises.Pet p : pets) {
            System.out.println(p.counter);
        }
    }

}

public class _10_30_ImplementCollection {
    public static void main(String[] args) {
        CollectionSequence<Pet> c = new CollectionSequence<Pet>();
        c.printPet();
    }
}
