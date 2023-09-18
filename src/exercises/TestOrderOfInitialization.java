package exercises;


class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class WindowTest {

    Window w = new Window(2);

    WindowTest() {
        System.out.println("In window Test");
    }

    static Window w_static = new Window(1);
}

public class TestOrderOfInitialization {
    public static void main(String[] args) {
        WindowTest ww = new WindowTest();
    }
}
