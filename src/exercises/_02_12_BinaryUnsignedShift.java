package exercises;

public class _02_12_BinaryUnsignedShift {

    public static void main(String[] args) {

        int b = 0b11111;
        printBinary(b);
        b <<= 1;
        printBinary(b);
        b >>>= 1;
        printBinary(b); // в итоге получаем тоже самое число, если бы использовали  >>, то получили бы 1111

    }

    static void printBinary(int x) {
        System.out.println(Integer.toBinaryString(x) + "\t int " + x + "\t hex " + Integer.toHexString(x));
    }
}
