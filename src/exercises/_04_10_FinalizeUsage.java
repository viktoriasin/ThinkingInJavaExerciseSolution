package exercises;

import java.util.Random;

public class _04_10_FinalizeUsage {

    static class TestFinalize {

        TestFinalize(int number) {
            i = number;
        }

        int i;

        protected void finalize() {
            System.out.println("Finalize " + i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        TestFinalize f = new TestFinalize(1);
        new TestFinalize(2);
        // на этой строчке и ниже делаем так, чтобы на объекты, которые мы создали ничего не ссылалось. То есть, эти объекты отправяться в очередь на сборку мусора
        new TestFinalize(3);
        new TestFinalize(4);
        new TestFinalize(5);
        new TestFinalize(6);
        new TestFinalize(7);
        f = null;

        System.gc();


        int i = myPureFunction(42);
//        System.out.println("Finish! ");

//        System.gc();
//        System.gc();
//        System.gc();
//
//        while (true) {
//            System.gc();
//            Thread.sleep(100);
//        }
    }

    static int myPureFunction(int arg)  {
        return arg * arg;
    }
}
