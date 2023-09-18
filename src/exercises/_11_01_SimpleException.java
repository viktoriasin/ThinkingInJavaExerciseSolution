package exercises;

class MyException extends Exception {
    public MyException() {}
    public MyException(String msg) { super(msg); }
}

public class _11_01_SimpleException {

    public static void main(String[] args) throws MyException {
        try {
            System.out.println("Printing something");
            throw new MyException("From main");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The program executes successfully.");
        }
    }
}
