package exercises;

import java.util.*;

class Fish {
    private static long counter = 0;
    private final long id = counter++;

    Fish() {
    } //forcing to use Generator

    public String toString() {
        return "Fish " + id;
    }

    public static GeneratorV2<Fish> generator() {
        return new GeneratorV2<Fish>() {
            public Fish next() {return new Fish();}
        };
    }
}

class LittleFish extends Fish {

    private static long counter = 0;
    private final long id = counter++;

    private LittleFish() {
    } //forcing to use Generator

    public String toString() {
        return "LittleFish " + id;
    }

    public static GeneratorV2<Fish> generator() {
        return new GeneratorV2<Fish>() {
            public Fish next() {return new LittleFish();}
        };
    }
}

class BigFish extends Fish {
    private static long counter = 0;
    private final long id = counter++;

    private BigFish() {
        super();
    } //forcing to use Generator

    public String toString() {
        return "BigFish " + id;
    }

    public static GeneratorV2<Fish> generator() {
        return new GeneratorV2<Fish>() {
            public Fish next() {
                return new BigFish();}
        };
    }

}


public class _14_18_GeneratorAsAnonymClass {
    public static void eat(LittleFish little, BigFish big) {
        System.out.println(big + " eat " + little);
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Fish> littleQ = new ArrayList<>();
        Generators.fill(littleQ, LittleFish.generator(), 15);
        Queue<Fish> bigQ = new LinkedList<>();
        Generators.fill(bigQ, BigFish.generator(), 15);

        for(Fish c : bigQ)
            eat((LittleFish) littleQ.get(rand.nextInt(littleQ.size())), (BigFish) c);

    }
}
