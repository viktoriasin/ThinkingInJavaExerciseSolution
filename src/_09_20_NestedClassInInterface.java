interface NestedInterface {
    class Test {
    }

    ;

    interface F {
        interface D {
            interface C {

                void f();
                class OO {

                }
            }
        }
    }
}

public class _09_20_NestedClassInInterface implements NestedInterface {
    public static void main(String[] args) {
        new _09_20_NestedClassInInterface.Test();
    }
}


