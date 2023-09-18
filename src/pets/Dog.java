package pets;

import exercises.Factory;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }

    public static class InnerFactory
            implements Factory<Dog> {
        public Dog create() { return new Dog(); }
    }
}
