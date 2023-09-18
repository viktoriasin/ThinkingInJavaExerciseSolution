package exercises;

public class printBinaryUsingTernaryOperator {

    static String printBinary(int x) {
        String res = "";
        res += (x & 1) == 1 ? 1 : 0;

        x >>= 1;
        while (x != 0) {
            int expr = (x & 1) == 1 ? 1 : 0;
            res = expr + res;
            x >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int i1 = 0b0101010;
        int i2 = 0b1110101;
        System.out.println(printBinary(i2));
        System.out.println(Integer.toBinaryString(i2));
        System.out.println(printBinary(i1 & i2));
    }
}
