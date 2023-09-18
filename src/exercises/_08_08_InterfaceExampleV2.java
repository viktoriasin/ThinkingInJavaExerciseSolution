package exercises;

interface FastFood {
    public void addCalory();
    public void getCalory();
}

class Meal3 {
    Meal3() {
        System.out.println("Meal()"); }
}
class Bread3 {
    Bread3() { System.out.println("Bread()"); }
}
class Cheese3 {
    Cheese3() { System.out.println("Cheese()"); }
}
class Lettuce3 {
    Lettuce3() { System.out.println("Lettuce()"); }
}
class Lunch3 extends Meal3 {
    Lunch3() { System.out.println("Lunch()"); }
}
class PortableLunch3 extends Lunch3 {
    PortableLunch3() { System.out.println("PortableLunch()");}
}
class Sandwich3 extends PortableLunch3 implements FastFood {
    private Bread3 b = new Bread3();
    private Cheese3 c = new Cheese3();
    private Lettuce3 l = new Lettuce3();
    public Sandwich3() { System.out.println("Sandwich()"); }

    public void addCalory() {
        System.out.println("Calory added");
    }

    public void getCalory() {
        System.out.println("Calory received");
    }
}

public class _08_08_InterfaceExampleV2 {
    public static void main(String[] args) {
        new Sandwich3();
    }
}
