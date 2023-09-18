package exercises;

import java.lang.reflect.*;
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    public Object
    invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
//        System.out.println(proxy); // Trows an ex exeption!
        System.out.println("**** proxy: " + proxy.getClass() +
                ", method: " + method + ", args: " + args);
        if(args != null)
            for(Object arg : args)
                System.out.println("  " + arg);
        long startTime = System.nanoTime();
        Object res = method.invoke(proxied, args);
        long stopTime = System.nanoTime();
        System.out.println("Method call duration: " + (stopTime - startTime));
        return res;
    } }
class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{ Interface.class },
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}

public class _13_22_DynamicProxyDemo {
    public static void main(String[] args) {
        SimpleDynamicProxy.main(null);
    }
}
