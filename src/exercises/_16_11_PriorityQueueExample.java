package exercises;

import java.util.PriorityQueue;
import java.util.Random;

class IntegerHolder implements Comparable<IntegerHolder>  {
    private int i;
    IntegerHolder() {
        i = new Random().nextInt(100);
    }

    @Override
    public int compareTo(IntegerHolder o) {
        return Integer.compare(i, o.getI());
    }

    private int getI() {
        return i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

}

public class _16_11_PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<IntegerHolder> queue = new PriorityQueue<>();
        queue.add(new IntegerHolder());
        queue.add(new IntegerHolder());
        queue.add(new IntegerHolder());
        queue.add(new IntegerHolder());
        queue.add(new IntegerHolder());
        queue.add(new IntegerHolder());
        while(!queue.isEmpty())
            System.out.println(queue.remove());
    }
}
