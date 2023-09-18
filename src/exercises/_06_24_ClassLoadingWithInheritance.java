package exercises;

class Insect {
    private int i = 9;
    protected int j;

    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 =
            printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 =
            printInit("static Beetle.x2 initialized");
}

class Needle extends Beetle {
    private int k = printInit("Needle.k initialized");

    public Needle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 =
            printInit("static Needle.x2 initialized");
}


public class _06_24_ClassLoadingWithInheritance {
    public static void main(String[] args) {
        System.out.println("Needle constructor");
        Needle b = new Needle();
    }
}
