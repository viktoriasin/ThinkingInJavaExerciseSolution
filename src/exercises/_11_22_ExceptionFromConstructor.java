package exercises;



class MyExceptionV127 extends Exception {
    public String toString() {
        return "MyExceptionV127";
    }
}


class  FailingConstructor {
    private int i;
    private int[] array;
    FailingConstructor(int i, int size) throws MyExceptionV127 {
        this.i = i;
        if (i == 0) {
            throw new MyExceptionV127();
        }
        if (size > 15) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            array = new int[size];
        }
    }
}

public class _11_22_ExceptionFromConstructor {
    public static void main(String[] args) throws MyExceptionV127 {
        try {
            FailingConstructor f = new FailingConstructor(1, 10);
            FailingConstructor f1 = new FailingConstructor(0, 10);
            FailingConstructor f2 = new FailingConstructor(1, 17);
        } catch (MyExceptionV127 e) {
            System.out.println(e);
        } finally {
            System.out.println("Exit the program!");
        }
    }
}

