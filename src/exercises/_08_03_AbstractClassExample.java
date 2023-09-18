package exercises;

abstract class BaseClassAbstract {
    abstract void print();

    BaseClassAbstract() {
        print();
    }
}

class FromAbstract extends BaseClassAbstract {
    private int i = 1;
    void print() {
        System.out.println("In FromAbstract class, the value of i = " + i);
    }
}

public class _08_03_AbstractClassExample {
    public static void main(String[] args) {
        FromAbstract fromAb = new FromAbstract();
        fromAb.print();
    }
}
