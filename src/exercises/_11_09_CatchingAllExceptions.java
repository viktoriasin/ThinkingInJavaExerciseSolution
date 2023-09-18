package exercises;

class Exception1 extends Exception {
    public Exception1() {}
    public Exception1(String msg) { super(msg); }
}

class Exception2 extends Exception {
    public Exception2() {}
    public Exception2(String msg) { super(msg); }
}

class Exception3 extends Exception {
    public Exception3() {}
    public Exception3(String msg) { super(msg); }
}

public class _11_09_CatchingAllExceptions {
    public static void main(String[] args) {
        try {
            throw new Exception1("The first Exception");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        try {
            throw new Exception2("The second Exception");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        try {
            throw new Exception3("The third Exception");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
