package exercises;

import java.util.*;

interface GeneratorV2<T> {
    T next();
}

class Fibonacci implements GeneratorV2<Integer> {
    private int count = 0;

    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }
}

class IterableFibonacci implements Iterable<Integer> {

    Fibonacci fib = new Fibonacci();

    private int n;

    public IterableFibonacci(int count) {
        n = count;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return n > 0;
            }

            public Integer next() {
                n--;
                return fib.next();
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }
}

public class _14_07_FibonacciIterableComposition {
    public static void main(String[] args) {
        IterableFibonacci.main(null);
    }
}
