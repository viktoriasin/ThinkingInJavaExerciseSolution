package exercises;

class Characteristic {
    private int refCount = 0;
    private static int counter = 0;
    private final long id = counter++;

    Characteristic() {
        System.out.println("Creating " + this);
    }


    public void addRef() {
        refCount++;
    }

    protected void dispose() {
        if (--refCount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    public String toString() {
        return "Characteristic " + id;
    }

}

class Rodent {
    private final Characteristic c;
    private static long counter = 0;
    private final long id = counter++;

    Rodent(Characteristic c) {
        this.c = c;
        this.c.addRef();
        System.out.println("Rodent");
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        c.dispose();
    }

    public void say() {
        System.out.println("I am Rodent!");
    }

    public String toString() {
        return "Rodent " + id;
    }

}

class Mouse extends Rodent {
    private static long counter = 0;
    private final long id = counter++;

    Mouse(Characteristic c) {
        super(c);
        System.out.println("Mouse");
    }

    @Override
    public void say() {
        System.out.println("I am Mouse!");
    }

    public String toString() {
        return "Mouse " + id;
    }

}

class Gerbil extends Rodent {
    private static long counter = 0;
    private final long id = counter++;

    Gerbil(Characteristic c) {
        super(c);
        System.out.println("Gerbil");
    }

    @Override
    public void say() {
        System.out.println("I am Gerbil!");
    }

    public String toString() {
        return "Gerbil " + id;
    }
}

class Hamster extends Rodent {
    private static long counter = 0;
    private final long id = counter++;

    Hamster(Characteristic c) {
        super(c);
        System.out.println("Hamster");
    }

    @Override
    public void say() {
        System.out.println("I am Hamster!");
    }

    public String toString() {
        return "Hamster " + id;
    }
}


public class _07_09_PolyExample {
    public static void main(String[] args) {
        Characteristic crr = new Characteristic();
        Rodent[] r = {
                new Mouse(crr),
                new Gerbil(crr),
                new Hamster(crr)
        };

        for (Rodent rr : r) {
            rr.say();
        }

        for (Rodent rr : r) {
            rr.dispose();
        }

    }
}
