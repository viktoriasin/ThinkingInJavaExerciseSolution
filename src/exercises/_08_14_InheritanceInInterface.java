package exercises;

interface Inter1 {
    void sleep1();

    void eat();
}

interface Inter2 {
    void run();

    void jump();
}

interface Inter3 {
    void lean();

    void move();
}

interface CommonInter extends Inter1, Inter2, Inter3 {
    void combine();
}

abstract class Obj1 {
    abstract void implement();
}

class MainObj extends Obj1 implements CommonInter {
    public void sleep1() {
    }


    public void eat() {
    }


    public void run() {
    }


    public void jump() {
    }


    public void lean() {
    }


    public void move() {
    }


    public void combine() {
    }

    public void implement() {
    }

}


public class _08_14_InheritanceInInterface {

    static void takes1(Inter1 i) {
        System.out.println("takes1");
    }

    static void takes2(Inter2 i) {
        System.out.println("takes2");
    }

    static void takes3(Inter3 i) {
        System.out.println("takes3");
    }

    static void takes4(CommonInter i) {
        System.out.println("CommonInter");
    }

    public static void main(String[] args) {
        MainObj m = new MainObj();
        takes1(m);
        takes2(m);
        takes3(m);
        takes4(m);
    }
}
