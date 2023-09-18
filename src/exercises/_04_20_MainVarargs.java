package exercises;

public class _04_20_MainVarargs {

    public static void main(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
    }
}
