package exercises;

class StaticBlock {
    static void PrintStatic() {
        System.out.println(m);
        System.out.println(d);
    }


    static String d = "a";
    static String m;
    static {
        m = "b";
    }


}

public class _04_14_StaticBlickExample {
    public static void main(String[] args) {
        StaticBlock.PrintStatic();
    }
}
