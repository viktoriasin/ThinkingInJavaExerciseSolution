package exercises;

class D {
    D(int i) {
        System.out.println("D constructor");
    }
}

class E extends D {
    E(int i) {
        super(i);
        System.out.println("E contstructor");
    }
}

class M extends D {
    M() {
        super(11);
        System.out.println("M constructor");
    }
}
public class _06_08_BaseClassConstructors {
    public static void main(String[] args) {

    }
}
