package exercises;


class TestV33 {
    TestV33() {
        System.out.println("Without arguments");
    }

    TestV33(int i) {
        System.out.println("With arguments");
    }
}

class TestV34 {
    TestV33 testV33() {
        return new TestV33() {};
    }
}

public class _09_15_AnonymClassExampleV2 {
}
