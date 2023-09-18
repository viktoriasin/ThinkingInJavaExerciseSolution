package exercises;

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
        static Cup cup1;
        static Cup cup2;
        static {
            cup1 = new Cup(1);
            cup2= new Cup(2);
        }
        Cups() {
            System.out.println("Cups()");
        }
}


public class _04_13_StaticInitializationExample {
    public static void main(String[] args) {
        System.out.println("inside main()");
        Cups.cup1.f(99); // обращаемся к статическому полю - происходит инициализация статических полей в классе
    }
     static Cups cups1 = new Cups(); // другой сопсоб проинициализировать поля - создать объект класса
     static Cups cups2 = new Cups();
}
