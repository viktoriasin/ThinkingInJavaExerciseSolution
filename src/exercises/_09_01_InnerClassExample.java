package exercises;

class Outer {
    class Inner {}

    public Inner returnInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner i = o.returnInner();

    }
}

public class _09_01_InnerClassExample {
    public static void main(String[] args) {
        Outer.main(new String[] {"Test"});
    }
}
