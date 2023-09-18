package exercises;


import java.util.Arrays;

class TestForNUllException {
    void printSomething() {
        System.out.println("Hello!");
    }
};

public class _11_02_TryToCatchNullExeption {
    public static void main(String[] args) {
        try {
            TestForNUllException t = null;
            t.printSomething();
        } catch (NullPointerException n) {
            System.out.println("Catch it!");
        }
    }

    public static _11_02_TryToCatchNullExeption[] getWinterMonths() {
        return new _11_02_TryToCatchNullExeption[2];
    }
}
