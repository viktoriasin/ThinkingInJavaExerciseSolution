package exercises;


import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

class RandomChars implements Readable {
    private static Random rand = new Random(47);
    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private int count;

    public RandomChars(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0) {
            return -1;
        }
        cb.append(capitals[rand.nextInt(capitals.length)]);
        cb.append(" ");
        return 1;
    }

}


public class _08_16_ClassForScanner {
    public static void main(String[] args) {
        Scanner console = new Scanner(new RandomChars(10));
        while (console.hasNext()) {
            System.out.println(console.next());
        }
    }
}
