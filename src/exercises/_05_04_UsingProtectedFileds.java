package exercises;

public class _05_04_UsingProtectedFileds {
    protected static String s = "s";
    protected static void printS() {
        System.out.println(s);
    }
    private static void printSS() {
        System.out.println(s);
    }
}
