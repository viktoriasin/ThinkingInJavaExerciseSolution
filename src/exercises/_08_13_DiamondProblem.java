package exercises;

interface MyInterface {

}

interface V1 extends MyInterface {
    void test();
}

interface V2 extends MyInterface {
    void test();
}

interface V3 extends V1, V2 {
}

class TestV3 implements V3 {

    @Override
    public void test() {
        System.out.println("Testing multiple inheritance problem!");

    }
}

public class _08_13_DiamondProblem {
    public static void main(String[] args) {
        V3 t = new TestV3();

//        Object tmp = t;

//        Integer t2 = (Integer) t;

        t.test();
    }
}
