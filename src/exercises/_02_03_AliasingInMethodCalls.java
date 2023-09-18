package exercises;

/**
 * Demonstrate that passing object in methods dome by reference
 */

class FloatClass {
    float f;
}

public class _02_03_AliasingInMethodCalls {

    static void changeLetter(FloatClass y) {
        y.f = 3;
    }
    public static void main(String[] args) {
            FloatClass f1 = new FloatClass();
            f1.f = 4;
            System.out.println("Attribute before changing: " + f1.f);
            changeLetter(f1);
            System.out.println("Attribute after changing: " + f1.f);
        }
    }

