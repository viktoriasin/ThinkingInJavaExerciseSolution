package exercises;

class SmallCounterException extends Exception {
    public String toString() {
        return "SmallCounterException";
    }
}

class UnknouwnStringException extends Exception {
    public String toString() {
        return "UnknouwnStringException";
    }
}

class DisposableClass {
    private int j;
    private String s;
    DisposableClass(int j, String s) {
        this.j = j;
        this.s = s;
    }
    public void decreaseCounter() {
        j--;
    }
    public void dispose() throws SmallCounterException, UnknouwnStringException {
        if (j <= 0) {
            throw new SmallCounterException();
        }
        if (s.equals("Unknown")) {
            throw new UnknouwnStringException();
        }
    }
}

class TestExceptionInConstructor {
    TestExceptionInConstructor() {
        try {
            DisposableClass d = new DisposableClass(2, "Hello!");
            d.decreaseCounter();
//            d.decreaseCounter();
            d.dispose();
            try {
                DisposableClass dd = new DisposableClass(2, "Unknown");
                dd.dispose();
            } catch (SmallCounterException | UnknouwnStringException e) {
                System.out.println("Inside second try block!");
                System.out.println(e);
            } finally {
                System.out.println("Exit second try block!");
            }
        } catch (SmallCounterException | UnknouwnStringException e) {
            System.out.println("Inside first try block!");
            System.out.println(e);
        } finally {
            System.out.println("Exit first try block!");

        }
    }

    public void dispose() {
        System.out.println("Disposing object");
    }
}

public class _11_23_CatchExceptionInsideConstructor {
    public static void main(String[] args) {
        TestExceptionInConstructor t = null;
        try {
            t = new TestExceptionInConstructor();
        } catch (Exception e) {
            System.out.println("Test");
        } finally {
            t.dispose();
        }

    }
}
