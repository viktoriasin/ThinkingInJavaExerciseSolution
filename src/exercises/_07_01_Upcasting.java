package exercises;

class Cycle {
    public static void ride(Cycle c) {
        c.move();
        c.wheels();
    }

    public void move() {
        System.out.println("Moving cycle");
    }

    public void wheels() {};
}

class Unicycle extends Cycle {
    public void move() {
        System.out.println("Moving Unicycle");
    }

    @Override
    public void wheels() {
        System.out.println("I have 1 wheels");
    }
}

class Bicycle extends Cycle {
    public void move() {
        System.out.println("Moving Bicycle");
    }

    @Override
    public void wheels() {
        System.out.println("I have 2 wheels");
    }
}

class Tricycle extends Cycle {
    public void move() {
        System.out.println("Moving Tricycle");
    }

    @Override
    public void wheels() {
        System.out.println("I have 3 wheels");
    }
}

public class _07_01_Upcasting {

    public static void main(String[] args) {
        Cycle cc = new Cycle();
        Unicycle u = new Unicycle();
        Bicycle b = new Bicycle();
        Tricycle t = new Tricycle();
        cc.ride(u);
        cc.ride(b);
        cc.ride(t);
    }
}
