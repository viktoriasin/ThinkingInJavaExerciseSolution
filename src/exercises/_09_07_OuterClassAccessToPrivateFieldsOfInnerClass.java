package exercises;

class OuterV7 {
    class InnerV8 {
        private String s = "S";
    }

    public void getPrivateString() {
        System.out.println(new InnerV8().s);
    }
}

public class _09_07_OuterClassAccessToPrivateFieldsOfInnerClass {
    public static void main(String[] args) {
        OuterV7 outer = new OuterV7();
        outer.getPrivateString();
    }
}
