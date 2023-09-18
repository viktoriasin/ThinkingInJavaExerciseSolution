package exercises;

public class _02_10_BitwiseOperations {
    public static void main(String[] args) {
        byte i1 = 0b0101010;
        byte i2 = 0b1110101;
        System.out.println(Integer.toBinaryString(i2));
        System.out.println(Integer.toBinaryString(i1));
        System.out.println(Integer.toBinaryString(i1 & i2));
        System.out.println(Integer.toBinaryString(i1 | i2));
        System.out.println(Integer.toBinaryString(i1 ^ i2));
        System.out.println(Integer.toBinaryString(~i2));
    }
}


// byte i2 = 0b1 почему мы так можем получить бинарное число
// byte b = 0x7f; почему мы в байт вроде как записываем хекс?

//cmnd+d быстрое дублирование строки
// cmnd+/ быстрое комментирование строки
// opt+cmnd+L форматирование