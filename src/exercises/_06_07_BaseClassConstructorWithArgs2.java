package exercises;

class Aa {
    Aa(int i) {
        System.out.println("I'm A!");
    }
};

class Bb {
    Bb(int i) {
        System.out.println("I'm B!");
    }
}

class Cc extends Aa {
    Cc() {super(11);}

    Bb b = new Bb(11);
};




public class _06_07_BaseClassConstructorWithArgs2 {
    public static void main(String[] args) {
        Cc c = new Cc();
    }
}
