package testPackage.blackJack;

public class Koloda {

    private Card[] koloda = new Card[52];

    public void prepared() {
        koloda[0] = new Card("Двойка треф", 2);
        koloda[1] = new Card("Двойка треф", 2);
        koloda[2] = new Card("Двойка треф", 2);
    }
}
