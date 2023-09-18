package exercises;

class BV19 {
    class Inner {
        Inner(String s) {
            System.out.println(s);
        }
    }
}

class CV19 {
    class Inner2 extends BV19.Inner {
        Inner2(BV19 v) {
            v.super("e");
        }
    }
}

public class _09_26_InheritingFromInnerClass {
    public static void main(String[] args) {
        CV19 p = new CV19();
        p.new Inner2(new BV19());
    }
}
