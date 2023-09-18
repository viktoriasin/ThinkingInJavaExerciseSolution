package exercises;

public class _05_04_AccessProtectedField {
    public static void main(String[] args) {
        _05_04_UsingProtectedFileds.printS(); // has access
        System.out.println(_05_04_UsingProtectedFileds.s); // has access
//        _05_04_UsingProtectedFileds.printSS(); // has not access to private fields
    }

}
