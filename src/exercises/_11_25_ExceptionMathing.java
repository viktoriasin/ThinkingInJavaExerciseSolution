package exercises;

class Ex1 extends Exception {
    public String toString() {
        return "Ex1";
    }
}

class Ex2 extends Ex1 {
    public String toString() {
        return "Ex2";
    }
}

class Ex3 extends Ex2 {
    public String toString() {
        return "Ex3";
    }
}

class A125 {
    public void f() throws Ex1 {
        throw new Ex1();
    }
}

class B125 extends A125 {
    public void f() throws Ex2 {
        throw new Ex2();
    }
}

class C125 extends B125 {
    public void f() throws Ex3 {
        throw new Ex3();
    }
}

public class _11_25_ExceptionMathing {
    public static void main(String[] args) throws Ex1 {
        A125 obj = new A125();
        obj.f();
    }
}
