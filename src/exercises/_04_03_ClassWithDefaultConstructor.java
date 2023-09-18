package exercises;

public class _04_03_ClassWithDefaultConstructor {

    static class TestClass {
        TestClass() {
            System.out.println("I'm here!");
        }

        TestClass(String s) {
            System.out.println(s + ": I'm here!");
        }
    }

    public static void main(String[] args) {
        new TestClass();
        new TestClass("Overloaded constructor");
    }
}
