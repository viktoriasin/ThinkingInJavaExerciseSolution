package exercises;

interface Interface {
    void doSomething();
    void somethingElse(String arg);}

class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething"); }
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
class SimpleProxy implements Interface {
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        long startTime = System.nanoTime();
        proxied.doSomething();
        long stopTime = System.nanoTime();
        System.out.println("Method call duration: " + (stopTime - startTime));
    }
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        long startTime = System.nanoTime();
        proxied.somethingElse(arg);
        long stopTime = System.nanoTime();
        System.out.println("Method call duration: " + (stopTime - startTime));
    }
}
class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}

public class _13_21_SimpleProxyDemo {
    public static void main(String[] args) {
        SimpleProxyDemo.main(null);
    }
}
