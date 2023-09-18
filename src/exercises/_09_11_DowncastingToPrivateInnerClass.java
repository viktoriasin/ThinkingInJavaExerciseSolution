package exercises;

interface ForTestingPurposes {
    public void getI();
}

class TestV127 {
    private class TestInnerV127 implements ForTestingPurposes {
        public void printSomething() {
            System.out.println("print Something.");
        }
        public void getI() {
            System.out.println("Getting I.");
        }
    }


    ForTestingPurposes getTestInnerV127() {
        TestInnerV127 ttt = new TestInnerV127();
        return ttt;
    }
}

public class _09_11_DowncastingToPrivateInnerClass {
    public static void main(String[] args) {
        TestV127 tttt = new TestV127();
        ForTestingPurposes fff = tttt.getTestInnerV127();
//        TestV127.TestInnerV127 v2 = (TestV127.TestInnerV127) fff;
//        v2.printSomething(); // wtf?! почему мы можем использовать метод интерфейса, но не можем использовать метод класса?
    }
}
