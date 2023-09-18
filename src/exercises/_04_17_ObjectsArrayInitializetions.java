package exercises;


class Test {
    Test(String s) {
        System.out.println(s);
    }
}

public class _04_17_ObjectsArrayInitializetions {

    public static void main(String[] args) {
        Test[] t = new Test[3];  // на этом моменте инициализация еще не произогла, поэтому сообщение в конструкторе класса Test еще не печатается

        for (int i = 0; i < t.length; i++) {
            t[i] = new Test("s"); // а вот тут уже произошла инициализация, поэтому сообщение конструктора напечатается три раза
        }
    }
}
