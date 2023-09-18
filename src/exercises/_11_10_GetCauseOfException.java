package exercises;


class Exception4 extends Exception {
    public Exception4(String s) { super(s); }
}

class Exception5 extends Exception {
    public Exception5(String s) { super(s); }
}

public class _11_10_GetCauseOfException {
    public static void g() throws Exception4 {
        throw new Exception4("From g");
    }

    public static void f() throws Exception5 {
        try {
            g();
        } catch (Exception4 e) {
            throw new Exception5("From f; e5");
        }
    }

    public static void c() throws Exception5 {
        try {
            g();
        } catch (Exception4 e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception5 {
        c();
//        f();
    }
}
