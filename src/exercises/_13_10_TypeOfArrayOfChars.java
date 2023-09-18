package exercises;

public class _13_10_TypeOfArrayOfChars {
    public static void main(String[] args) {
        char[] ch = {'1', '2', '4'};
        System.out.println("Superclass of char[] c: " +
                ch.getClass().getSuperclass());
        System.out.println("char[] c instanceof Object: " +
                (ch instanceof Object));
    }
}
