package exercises;

class TestV125 {
    public static class NestedClass {
        void printSomething() {
            System.out.println("Print something");
        }
    }
}

public class _09_18_NestedClassessExample {
    public static void main(String[] args) {
        TestV125.NestedClass s = new TestV125.NestedClass(); // can return static class from static main directly
    }
}
