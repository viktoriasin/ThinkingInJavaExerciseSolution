package exercises;

interface CycleFactoryV {
    CycleV getCycle();
}

interface CycleV {
    void move();

    void stop();

    void turn(int i);

    void getInspiredSpeech();
}

class UnicycleV implements CycleV {
    private int point = 0;
    final int NUMBER_OF_WHEELS = 1;
    private int n = 5;

    public void move() {
        while(n-- != 0) {
            System.out.println("UnicycleV: N: " + n + " Point: " + point);
            point++;
        }
    }

    public void stop() {
        point--;
    }

    public void turn(int i) {
        point += i;
    }

    public int getPoint() {
        return point;
    }

    public void balance() {
        point = 0;
    }

    public void getInspiredSpeech() {
        System.out.println("Riding a Unicycle! Yuhuuuu!");
    }
}


class BicycleV implements CycleV {
    private int point = 0;
    final int NUMBER_OF_WHEELS = 2;
    private int n = 3;

    public void move() {
        while(n-- != 0) {
            System.out.println("BicycleV: N: " + n + "Point: " + point);
            point++;
        }
    }

    public void stop() {
        point--;
    }

    public void turn(int i) {
        point += i;
    }

    public int getPoint() {
        return point;
    }

    public void balance() {
        point = 0;
    }

    public void getInspiredSpeech() {
        System.out.println("Riding a Bicycle! Yuhuuuu!");
    }
}

class TricycleV implements CycleV {
    private int point = 0;
    final int NUMBER_OF_WHEELS = 3;
    private int n = 2;

    public void move() {
        while(n-- != 0) {
            System.out.println("TricycleV: N: " + n + "Point: " + point);
            point++;
        }
    }

    public void stop() {
        point--;
    }

    public void turn(int i) {
        point += i;
    }

    public int getPoint() {
        return point;
    }

    public void getInspiredSpeech() {
        System.out.println("Riding a Tricycle! Yuhuuuu!");
    }

}

class UnicycleVFactory implements CycleFactoryV {
    public CycleV getCycle() {
        return new UnicycleV();
    }
}

class BicycleVFactory implements CycleFactoryV  {
    public CycleV getCycle() {
        return new BicycleV();
    }
}

class TricycleVFactory implements CycleFactoryV  {
    public CycleV getCycle() {
        return new TricycleV();
    }
}

public class _08_18_InterfaceFactory {
    public static void rideCycle(CycleFactoryV factory) {
        CycleV s = factory.getCycle();
        s.getInspiredSpeech();
        s.move();
    }
    public static void main(String[] args) {
        rideCycle(new UnicycleVFactory());
        rideCycle(new BicycleVFactory());
        rideCycle(new TricycleVFactory());
    }
}
