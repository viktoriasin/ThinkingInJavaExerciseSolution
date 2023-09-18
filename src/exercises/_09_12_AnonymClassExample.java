package exercises;

interface TestV15 {
    void f();
}

class OuterV17 {
    private int field = 1;
    private void method() {
        System.out.println("Method");
    }

    public TestV15 testV15() {
        return new TestV15() {
            public void f() {
                System.out.println("F");
            }
            public void getPrivateAccess() {
                field = 2;
                method();
            }

        };
    }
}

public class _09_12_AnonymClassExample {
}
