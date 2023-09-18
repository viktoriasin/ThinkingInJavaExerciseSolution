package exercises;

interface Ii {
    void getI();
}

class OuterV27 {
    public Ii getIi() {
        class InnerV28 implements Ii {
            public void getI() {
                System.out.println("Ii");
            }
        }
        return new InnerV28();
    }

    public void getIiV2(boolean what) {
        if (what) {
            class InnerV28 implements Ii {
                public void getI() {
                    System.out.println("Ii");
                }
            }
        }
    }
}


public class _09_09_InnerClassInMethod {

    public static void main(String[] args) {
        OuterV27 oo = new OuterV27();
        Ii iii = oo.getIi();
    }
}
