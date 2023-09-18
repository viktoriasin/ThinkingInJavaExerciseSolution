package exercises;

import java.util.Random;

interface TossingArtefact {
    int toss();
}

interface TossingFactory {
    TossingArtefact getTossingArtefact();
}

class CoinTossing implements TossingArtefact {
    private static Random rand = new Random(47);
    private static final int[] CHOICES = {0, 1};

    public int toss() {
        return CHOICES[rand.nextInt(2)];
    }
}

class DiceTossing implements TossingArtefact {
    private static Random rand = new Random(47);
    private static final int[] CHOICES = {1, 2, 3, 4, 5, 6};

    public int toss() {
        return CHOICES[rand.nextInt(2)];
    }
}

class CoinTossingFactory implements TossingFactory {
    public TossingArtefact getTossingArtefact() {
        return new CoinTossing();
    }
}

class DiceTossingFactory implements TossingFactory {
    public TossingArtefact getTossingArtefact() {
        return new DiceTossing();
    }
}


public class _08_19_InterfaceFactoryV2 {
    public static int flip(TossingFactory factory) {
        TossingArtefact artefact = factory.getTossingArtefact();
        return artefact.toss();
    }

    public static void main(String[] args) {
        System.out.println(flip(new CoinTossingFactory()));
        System.out.println(flip(new DiceTossingFactory()));

    }
}
