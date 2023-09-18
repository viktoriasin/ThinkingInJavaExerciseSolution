package exercises;


import pets.*;
import exercises.Factory;
import pets.Hamster;
import pets.Mouse;
import pets.Pet;
import pets.Rodent;

import java.util.*;

abstract class FactoryPetCreator {
    private Random rand = new Random(47);

    // Вот это надо было реализовать в упражнении:
    public abstract List<Factory<? extends Pet>> types();

    public pets.Pet randomPet() { // Create one random Pet
        int n = rand.nextInt(types().size());
        // Вот это надо было реализовать в упражнении:
        return types().get(n).create();
    }

    public pets.Pet[] createArray(int size) {
        pets.Pet[] result = new pets.Pet[size];
        for (int i = 0; i < size; i++)
            result[i] = randomPet();
        return result;
    }

    public ArrayList<pets.Pet> arrayList(int size) {
        ArrayList<pets.Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }

}

class LiteralPetCreatorFactory extends FactoryPetCreator {
    // No try block needed.
    @SuppressWarnings("unchecked")
    // Вот это надо было реализовать в упражнении:
    public static final List<Factory<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(new Pet.InnerFactory(), new Cat.InnerFactory(),
                    new Dog.InnerFactory(), new Rodent.InnerFactory()));
    // Types for random creation:
    private static final List<Factory<? extends Pet>> types = allTypes;

    public List<Factory<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}

class PetsV2 {
    public static final FactoryPetCreator creator =
            new LiteralPetCreatorFactory();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}

class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }
    }

    public static void
    countPets(FactoryPetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            // List each individual pet:
            System.out.print(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet)
                counter.count("Pet");
            if (pet instanceof Dog)
                counter.count("Dog");
            if (pet instanceof Mutt)
                counter.count("Mutt");
            if (pet instanceof Pug)
                counter.count("Pug");
            if (pet instanceof Cat)
                counter.count("Cat");
            if (pet instanceof Manx)
                counter.count("EgyptianMau");
            if (pet instanceof Manx)
                counter.count("Manx");
            if (pet instanceof Manx)
                counter.count("Cymric");
            if (pet instanceof Rodent)
                counter.count("Rodent");
            if (pet instanceof Rat)
                counter.count("Rat");
            if (pet instanceof Mouse)
                counter.count("Mouse");
            if (pet instanceof Hamster)
                counter.count("Hamster");
        }
        // Show the counts:
        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(PetsV2.creator);
    }
}

public class _13_15_PetCounterUsingRegisteredFactories {
    public static void main(String[] args) {
        PetCount.main(null);
    }
}


interface SomeInterface {
    void doSomething();

    void doSomethingAnother(int arg);
}


// ====================

class SomeInterfaceStub implements SomeInterface {

    @Override
    public void doSomething() {
    }

    @Override
    public void doSomethingAnother(int arg) {
    }
}

class SomeInterfaceMock implements SomeInterface {

    private int counter = 0;

    @Override
    public void doSomething() {
        System.out.println("Привет! Это отладочный объект! У него позвали метод doSomething()" + counter++ + " раз");

        if (counter > 2) {
            throw new RuntimeException("Что-то пошло не по плану!");
        }
    }

    @Override
    public void doSomethingAnother(int arg) {
        System.out.println("Привет! Это отладочный объект! У него позвали метод doSomethingAnother() с аргументом " + arg);
    }
}


// ====================


class SomeTestClass {
    void doWork(SomeInterface obj) {
        obj.doSomething();
        obj.doSomethingAnother(new Random().nextInt());
    }
}


class UnitTest {
    void testMyClass() {
        SomeTestClass cls = new SomeTestClass();
        SomeInterfaceMock obj = new SomeInterfaceMock();
        cls.doWork(obj);
        cls.doWork(obj);
        cls.doWork(obj);
    }
}


