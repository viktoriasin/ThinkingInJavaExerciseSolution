package exercises;

class A {
    A() {
        System.out.println("I'm A!");
    }
};

class B {
    B() {
        System.out.println("I'm B!");
    }
}

class C extends A {
    B b = new B();
};

public class _06_05_InheretanceFromBaseClass {
    public static void main(String[] args) {
        C c = new C();
    }
}
