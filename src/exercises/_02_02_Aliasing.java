package exercises;

class Tank {float level;}

public class _02_02_Aliasing {
    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 1F;
        t2.level = 2F;
        System.out.println("T1 level is: " + t1.level + " T2 level is: " + t2.level);
        t1 = t2;
        System.out.println("T1 level is: " + t1.level + " T2 level is: " + t2.level);
        t1.level = 3;
        System.out.println("T1 level is: " + t1.level + " T2 level is: " + t2.level);
    }
}
