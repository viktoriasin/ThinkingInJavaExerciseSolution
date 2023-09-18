package exercises;

class OuterV2 {
    private static String s;
    OuterV2(String s) {
        this.s = s;
    }
    static class Inner {
        public String toString() {
            System.out.println(s);
            return null;
        }
    }
}


public class _09_03_InnerClassExampleV2 {
    public static void main(String[] args) {
        OuterV2.Inner s = new OuterV2.Inner();
        s.toString();
    }
}
