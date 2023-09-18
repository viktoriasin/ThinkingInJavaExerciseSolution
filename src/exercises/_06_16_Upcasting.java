package exercises;


class Amphibian {
    void jump() {
        System.out.println("I'am jumping!");
    }

    static void inspect(Amphibian a) {
        // ...
        a.jump();
    }
}

class Frog extends Amphibian {
    @Override
    void jump() {
        System.out.println("I'am Frog and i'm jumping!");
    }
}

public class _06_16_Upcasting {
    public static void main(String[] args) {
        Frog f = new Frog();
        Amphibian.inspect(f); // upcasting
    }
}


