package exercises;

public class isPrime {
    static void PrintPrime(int n) {

        for(int i = 1; i <= n; i++) {

            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime)
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
        PrintPrime(0);
    }
}
