package exercises;

public class _04_02_DifferentTypeOfInitialization {

    static class TestClass {
        String t;
        TestClass(String s) {
            t = s;
        }
    }

    static class TestClass2 {
        String t = "x";
    }

    public static void main(String[] args) {
        TestClass t1 = new TestClass("x");
        System.out.println(t1.t);

        TestClass2 t2 = new TestClass2();
        System.out.println(t2.t);
    }
}
