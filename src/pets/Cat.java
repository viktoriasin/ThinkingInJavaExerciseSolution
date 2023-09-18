package pets;

import exercises.Factory;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }

    public static class InnerFactory
            implements Factory<Cat> {
        public Cat create() { return new Cat(); }
    }
}
