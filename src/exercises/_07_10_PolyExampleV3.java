package exercises;

class BaseClassV4 {
    public void v2() {
        v3();
    }

    public void v3() {
        System.out.println("I'am in BaseClassV4 class");
    }
}

class InheritedClassV4 extends BaseClassV4 {
    @Override
    public void v3() {
        System.out.println("I'am in InheritedClassV4 class");
    }
}

public class _07_10_PolyExampleV3 {
    public static void main(String[] args) {
        BaseClassV4 b =  new InheritedClassV4();
        b.v2();
    }
}
