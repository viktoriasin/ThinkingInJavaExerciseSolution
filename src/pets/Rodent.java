package pets;

import exercises.Factory;

public class Rodent extends Pet {
    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
        super();
    }

    public static class InnerFactory
            implements Factory<Rodent> {
        public Rodent create() { return new Rodent(); }
    }
}
