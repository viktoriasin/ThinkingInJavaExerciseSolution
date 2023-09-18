package exercises;

class Component1 {
    static {
        System.out.println("Static I'm here!"); // вызовется только один раз
    }

    {
        System.out.println("I'm here!");
    }

    Component1(String s) {
        System.out.println("Component1 constructor" + s);
    }
    void dispose() {
        System.out.println("Dispose Component1");
    }
};

class Component2 {
    Component2(String s) {
        System.out.println("Component2 constructor" + s);
    }

    void dispose() {
        System.out.println("Dispose Component2");
    }
};

class Component3 {
    Component3(String s) {
        System.out.println("Component3 constructor" + s);
    }

    void dispose() {
        System.out.println("Dispose Component3");
    }
};

class Root {
    Component1 c1 = new Component1(" root");
    Component2 c2 = new Component2(" root");
    Component3 c3 = new Component3(" root");
    Root(int i) {
        System.out.println("Root constructor");
    }

    void dispose() {
        c3.dispose();
        c2.dispose();
        c1.dispose();
        System.out.println("Dispose Root");
    }
}

class Stem extends Root {
    Stem(int j) {
        super(j);
        System.out.println("Stem constructor");
    }

    Component1 c1 = new Component1(" stem");
    Component2 c2 = new Component2(" stem");
    Component3 c3 = new Component3(" stem");

    void dispose() {
        c3.dispose();
        c2.dispose();
        c1.dispose();
        super.dispose();
        System.out.println("Dispose Root");
    }
}

public class _06_09_RootConstructors {
    public static void main(String[] args) {
        Stem m = new Stem(1);
    }
}
