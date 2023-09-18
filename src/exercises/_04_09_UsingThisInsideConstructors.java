package exercises;

public class _04_09_UsingThisInsideConstructors {
    static class Test {
        Test(int x) {
            this("s");
        };
        Test(String x) {
            System.out.println(x);
        };
    }
}
