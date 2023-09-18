package exercises;

public class _02_13_CharToBinary {
    public static void main(String[] args) {
        char ch = 'x';
        charToBinary(ch);
    }

    static void charToBinary (char x) {
        System.out.println(Integer.toBinaryString(Character.getNumericValue(x)));
    }
}
