package exercises;

class Art {
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor");
    }
}

public class _06_03_BaseClassConstructor extends Drawing {
    public _06_03_BaseClassConstructor() {
        System.out.println("_06_03_BaseClassConstructor constructor");
    }

    public static void main(String[] args) {
        _06_03_BaseClassConstructor x = new _06_03_BaseClassConstructor();
    }
}
