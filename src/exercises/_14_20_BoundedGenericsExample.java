package exercises;


interface InterfaceTest {
    void printT();

    void printG();
}

class TestClass implements InterfaceTest {
    public void printT() {
        System.out.println("PrintT");
    }

    public void printG() {
        System.out.println("PrintG");
    }

    public void printK() {
        System.out.println("PrintK");
    }
}

class BoundedClass {
    public <T extends InterfaceTest> void f(T d) {
        d.printG();
        d.printT();
    }
}

public class _14_20_BoundedGenericsExample {
    public static void main(String[] args) {
        new BoundedClass().f(new TestClass());
    }
}
