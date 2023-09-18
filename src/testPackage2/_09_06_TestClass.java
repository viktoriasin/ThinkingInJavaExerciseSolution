package testPackage2;

import testPackage._09_06_Test;

public class _09_06_TestClass {
    protected class InsideTestClass implements _09_06_Test {
        @Override
        public void test() {
            System.out.println("In InsideTestClass class");
        }
    }

    public _09_06_Test create() {
        return new InsideTestClass();
    }


    static void test() {
        new  MyClass1().new Demo();
        new MyClass2().new Demo();
    }
}

class MyClass1 {
     class Demo {
        int a;
    }
}

class MyClass2 {
     class Demo {
        int a;
    }
}
