package exercises;

import java.util.PriorityQueue;
import java.util.Random;

public class _10_28_PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(127);
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(rand.nextDouble());
        }

        while (priorityQueue.peek() != null) {
            System.out.println(priorityQueue.poll());
        }
    }
}
