package exercises;


import java.util.*;

class PetSequence {
    protected Pet[] pets = Pet.createArray(8);
}

class NonCollectionSequence extends PetSequence implements Iterable<Pet> {
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            public boolean hasNext() {
                return index < pets.length;
            }

            public Pet next() {
                return pets[index++];
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterable<Pet> reversed() {
        return new Iterable<Pet>() {
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    int current = pets.length - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public Pet next() {
                        return pets[current--];
                    }

                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<Pet> randomized() {
        return new Iterable<Pet>() {
            public Iterator<Pet> iterator() {
                List<Pet> shuffled =
                        new ArrayList<Pet>(Arrays.asList(pets));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

}

public class _10_32_AdapterPattern {
    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        System.out.print("Original order: ");
        for (Pet p : nc) {
            System.out.print(p.counter);
        }
        System.out.println();
        System.out.print("Randomized order: ");
        for (Pet p : nc.randomized()) {
            System.out.print(p.counter);
        }
        System.out.println();
        System.out.print("Reversed order: ");
        for (Pet p : nc.reversed()) {
            System.out.print(p.counter);
        }
    }
}
