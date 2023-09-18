package exercises;

import interfaceExample.TestInterface;

class FromInterface implements TestInterface {
    public void method1() {
        System.out.println("Method 1");
    }

    public void method2() {
        System.out.println("Method 2");
    }

    public void method3() {
        System.out.println("Method 3");
    }
}


public class _08_05_InterfaceExample {
    public static void main(String[] args) {
        FromInterface fff = new FromInterface();
    }
}
