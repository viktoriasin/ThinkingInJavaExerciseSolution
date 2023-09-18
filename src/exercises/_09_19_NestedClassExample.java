package exercises;

class TestV123 {
    class TestV124 {
        class TestV125 {

        }
    }
}

class TestV223 {
    static class TestV224 {
        static class TestV225 {

        }
    }
}

public class _09_19_NestedClassExample {
    public static void main(String[] args) {
        System.out.println("Compiled it!");
    }
}



class DotNew {
    public class Inner {}

    public Inner inner() {
        return new Inner();
    }
    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.inner();
    }
}

class DotThis {
    void f() { System.out.println("DotThis.f()"); }
    public class Inner {
        public DotThis outer() {
            return DotThis.this;
            // A plain "this" would be Inner’s "this"
        } }
    public Inner inner() { return new Inner(); }
    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}