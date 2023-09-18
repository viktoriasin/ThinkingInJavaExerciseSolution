package exercises;

class SimpleClass { };

public class _06_01_LazyInitialization {
    SimpleClass s;
    public String toString() {
        if (s == null) {
            s = new SimpleClass(); // lazy initialization
        }
        return "reference to object " + s;
    }

    public static void main(String[] args) {
        _06_01_LazyInitialization l = new _06_01_LazyInitialization();
        System.out.println(l.toString());
    }
}
