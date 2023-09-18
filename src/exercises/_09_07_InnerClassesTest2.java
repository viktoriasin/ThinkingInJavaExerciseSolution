package exercises;

class ClassForTest2 {
    private String s = "abcd";
    private void printSomething() {
        System.out.println("Print something!");
    }

    class InsideClassForTest2 {
        public void changeS() {
            s = "dcba";
        }
        public void tryToPrintSomething() {
            printSomething();
        }
    }

    void showInnerCLass() {
        InsideClassForTest2 i = new InsideClassForTest2();
        System.out.print("before change: " + s);
        i.changeS();
        System.out.println("before change: " + s);
        i.tryToPrintSomething();
    }

}

public class _09_07_InnerClassesTest2 {
    public static void main(String[] args) {
        ClassForTest2 classForTest = new ClassForTest2();
        classForTest.showInnerCLass();
    }
}
