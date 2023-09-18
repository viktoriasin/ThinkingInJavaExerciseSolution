package pets;


import exercises.Factory;

public class Pet extends Individual {
    public Pet(String name) { super(name); }
    public Pet() { super(); }

    public static class InnerFactory implements Factory<Pet> {
        public Pet create() { return new Pet(); }
    }
}




