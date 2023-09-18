package exercises;

public class TrestTypesPromotion {
    public static void main(String[] args) {
        byte b = 1;
        byte c = 4;
//        byte x = b + c; // вот так будет ошибка, так как тип выражения будет int а x - это байт
        byte x = (byte) (b+ c);
    }
}
