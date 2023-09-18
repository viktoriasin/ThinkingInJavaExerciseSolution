package exercises;

class CycleV2 {
    public void ride() {
        System.out.println("Cycle ride!");
    }
}

class BicycleV2 extends CycleV2 {
    public void ride() {
        System.out.println("BicycleV2 ride");
    }

    public void balance() {
        System.out.println("Balancing TricycleV2");
    }
}

class TricycleV2 extends CycleV2 {
    public void ride() {
        System.out.println("TricycleV2 ride");
    }

}

class UnicycleV2 extends CycleV2 {
    public void ride() {
        System.out.println("TricycleV2 ride");
    }

    public void balance() {
        System.out.println("Balancing UnicycleV2");
    }
}

public class _07_17_DownCastingExample {

    public static void main(String[] args) {
        CycleV2[] c = { // в этом месте происходит upcasting
                new BicycleV2(),
                new TricycleV2(),
                new UnicycleV2()
        };
        ((BicycleV2)c[0]).balance(); // RTTI, в этом месте происходит downcasting
//        c[1].balance();
        ((UnicycleV2)c[0]).balance(); // RTTI, в этом месте происходит downcasting
    }
}
