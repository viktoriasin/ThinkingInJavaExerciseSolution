package exercises;

public class _04_14_VarargsArguments {
    static void f(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        f("sdfsd", "sdfdsf", "sdfsd");
        f(new String[]{"sdfsdf", "sdfsdf", "sdfsdf"});

    }
}
