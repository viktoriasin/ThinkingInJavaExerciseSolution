package exercises;

public class _02_11_BinaryShift {

    public static void main(String[] args) {
        int b = 0x80000000;

        printBinary(b);

        for (int i = 1; i <= 32; ++i) {
            b >>= 1;
            printBinary(b);
        }

    }

    static void printBinary(int x) {
        System.out.println(Integer.toBinaryString(x) + "\t int " + x + "\t hex " + Integer.toHexString(x));
    }

}


