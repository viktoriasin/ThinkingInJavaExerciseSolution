package exercises;

interface X {
    String doSomething();
    class NestedClass {
        public static void callInterfaceMethod(X x) {
            System.out.println(x.doSomething());
        }
    }
}


public class _09_21_NestedClassesWithStaticField implements X {
    public String doSomething() {return "Hello!";}

    public static void main(String[] args) {
        _09_21_NestedClassesWithStaticField test = new _09_21_NestedClassesWithStaticField();
        NestedClass.callInterfaceMethod(test); // почему работает и как X.NestedClass и просто как NestedClass ?!
    }
}

