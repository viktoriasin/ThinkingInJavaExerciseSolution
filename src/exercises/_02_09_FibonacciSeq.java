package exercises;

public class _02_09_FibonacciSeq {

    static void Fibonacci(int n) {
        if (n == 0) {
            System.out.println(0);
        } else {
            int prev_n = 1;
            int cur_n = 0;
            for (int i = 0; i < n; i++) {
                int temp = cur_n;
                cur_n = cur_n + prev_n;
                prev_n = temp;
                System.out.print(cur_n + " ");
            }
        }
    }

    public static void main(String[] args) {
        Fibonacci(0);
    }
}
