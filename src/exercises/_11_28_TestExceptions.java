package exercises;


import java.util.LinkedList;
import java.util.List;

class Ex11 extends Exception {}

class Ex12 extends Exception {}



class A129 {
    public void f() throws Ex11 {
        throw new Ex11();
    }

    public void l() {
        try {
            f();
        } catch(Exception e) {
            throw new RuntimeException();
        }
    }


    public void g() throws Ex11 {
        f();
    }

    public void q() {
        try {
            g();
        } catch (Ex11 e) {
            throw new RuntimeException(e);
        }
    }

    public void w() {
        l(); // компилятор не форсит нас обрабатывать исключение из l, так как оно принадлежит к формату unchecked exceptions
    }


}
