package exercises;

class Test333 {
    int i = 2;
    long l = 23L;
    float f = 23.2342342342342345F;
    double d = 11.1;

    public String toString() {
        return String.format("%d %d %.2f %.3f", i, l, f, d);
    }
}


public class _12_06_StringFormatExample {
    public static void main(String[] args) {
        System.out.println(new Test333().toString());
    }
}
