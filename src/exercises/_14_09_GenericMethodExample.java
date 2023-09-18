package exercises;

import java.util.Random;

class GenericMethods {
    public <R, O, P> void f(R a, O b, P c, Character ch) {
        System.out.println(a.getClass().getName());
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(c.getClass().getName());
        System.out.println(ch.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f(1, 1.0, 'c', 'w');
        gm.f(1, 1, 'c', 'q');
        gm.f(3, 'c', 'c', 'r');
    }
}


public class _14_09_GenericMethodExample {
    public static void main(String[] args) {
        // GenericMethods.main(null);

        String s = "s";
        logClass2(s).length();
        ((String) logClass(s)).length();

        int i = 1;
        boolean test1 = logClass2(i) > 0;
        boolean test2 = ((Integer) logClass(i)) > 0;
    }

    static Object logClass(Object obj) {
        System.out.println(obj.getClass().getSimpleName());
        if (new Random().nextInt(1000) == 999) {
            return "obj";
        } else {
            return obj;
        }
    }

    static <T> T logClass2(T obj) {
        System.out.println(obj.getClass().getSimpleName());
        return obj;
    }

}



