package exercises;

import java.util.Random;

public class _03_02_IfElseRandom {

    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt();
        for(int j = 1; j < 24; j++) {

            int next = rand.nextInt();

            System.out.println(next + " " + i);

            if (i < next) {
                System.out.println("Less than");
            } else if (i > next) {
                System.out.println("Greater than");
            } else {
                System.out.println("Equal to");
            }
            i = next;
         }
    }

}
