package exercises;

interface U {
    void printHello();
    void printSomething();
    String returnString();
}

class AV127 {

    static int counter = 0;
    int i = counter++;

    U getU() {
        return new U() {
            public void printHello() {
                System.out.println("Hello from my parent " + i);
            }
            public void printSomething() {
                System.out.println("Print Something");
            };
            public String returnString() {
                return "String";
            }
        };
    }
}

class BV127  {
    private U[] u = new U[10];
    private int i = 0;

    public void setU(U obj) {
        if (i < u.length) {
            u[i] = obj;
            i++;
        } else {
            System.out.println("Array is full. Sorry.");
        }
    }

    public void setUToNull(int idx) {
        if (idx >= u.length) {
            System.out.println("Given index is greater than array length. Sorry.");
        } else {
            u[idx] = null;
        }
    }

    public void iterateArray() {
        for (U elem : u) {
            if (elem != null) {
                elem.printHello();
                elem.printSomething();
                System.out.println(elem.returnString());
            }
        }
    }

    public U getU(int idx) {
        if (idx < u.length) {
            return u[idx];
        }
        return null;
    }
}

public class _09_23_InterfaceInnerAnonymClasses {
    public static void main(String[] args) {
        AV127 a1 = new AV127();
        AV127 a2 = new AV127();
        AV127 a3 = new AV127();
        BV127 b = new BV127();
        b.setU(a1.getU());
        b.setU(a2.getU());
        b.setU(a3.getU());
        b.setU(a1.getU());

        System.out.println(b.getU(0) == b.getU(3));

        b.iterateArray();

    }
}
