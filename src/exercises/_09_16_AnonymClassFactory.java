package exercises;


interface CycleFactoryV1 {
    CycleV1 getCycle();
}

interface CycleV1 {
    void move();

    void stop();

    void turn(int i);

    void getInspiredSpeech();
}

class UnicycleV1 implements CycleV1 {
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

    public static CycleFactoryV1 factory = new CycleFactoryV1() {
            public CycleV1 getCycle() {
                return new UnicycleV1();
            }
        };
    }




class BicycleV1 implements CycleV1 {
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

    public static CycleFactoryV1 factory = new CycleFactoryV1() {
        public CycleV1 getCycle() {
            return new BicycleV1();
        }
    };
}

class TricycleV1 implements CycleV1 {
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

    public static CycleFactoryV1 factory = new CycleFactoryV1() {
        public CycleV1 getCycle() {
            return new TricycleV1();
        }
    };

}



public class _09_16_AnonymClassFactory {
    public static void rideCycle(CycleFactoryV1 factory) {
        CycleV1 s = factory.getCycle();
        s.getInspiredSpeech();
        s.move();
    }
    public static void main(String[] args) {
        rideCycle(UnicycleV1.factory);
        rideCycle(BicycleV1.factory);
        rideCycle(TricycleV1.factory);
    }
}



