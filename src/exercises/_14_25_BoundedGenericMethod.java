package exercises;

interface InterfaceOne {
    public void doSomething();
}

interface InterfaceTwo {
    public void doSomethingElse();
}

class ImplementingInterfaces implements InterfaceOne, InterfaceTwo {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void doSomethingElse() {
        System.out.println("doSomethingElse");
    }
}

public class _14_25_BoundedGenericMethod {
    public static <T extends InterfaceOne> void testOne(T obj) {
        obj.doSomething();
    }
    public static <T extends InterfaceTwo> void testTwo(T obj) {
        obj.doSomethingElse();
    }
    public static void main(String[] args) {
        ImplementingInterfaces i = new ImplementingInterfaces();
        testOne(i);
        testTwo(i);

    }
}
