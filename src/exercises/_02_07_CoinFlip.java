package exercises;

import java.util.Random;

public class _02_07_CoinFlip {
    static int flipCoin(Random coin) {
        return coin.nextInt(2);
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        System.out.println(flipCoin(rand));
        System.out.println(flipCoin(rand));
        System.out.println(flipCoin(rand));
    }
}
