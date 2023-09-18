package exercises;


import java.util.Iterator;
import java.util.Random;

class StoryCharacters {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class GoodGuys extends StoryCharacters {
}

class BadGuys extends StoryCharacters {
}

class Neo extends GoodGuys {
}

class Trinity extends GoodGuys {
}

class Morfeous extends GoodGuys {
}

class Smith extends BadGuys {
}

class Merovingien extends BadGuys {
}

class Cypher extends BadGuys {
}

class StoryCharactersGenerator implements GeneratorV2<StoryCharacters>, Iterable<StoryCharacters> {
    private final Class[] types = {Neo.class, Trinity.class,
            Morfeous.class, Smith.class, Merovingien.class, Cypher.class};
    private static final Random rand = new Random(47);

    public StoryCharactersGenerator() {
    }

    private int size = 0;

    public StoryCharactersGenerator(int sz) {
        size = sz;
    }

    public StoryCharacters next() {
        try {
            return (StoryCharacters) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class StoryCharactersIterator implements Iterator<StoryCharacters> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public StoryCharacters next() {
            count--;
            return StoryCharactersGenerator.this.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<StoryCharacters> iterator() {
        return new StoryCharactersIterator();
    }
}


public class _14_08_StoryCharacterGenerator {
    public static void main(String[] args) {
        StoryCharactersGenerator gen = new StoryCharactersGenerator();
        for (int i = 0; i < 7; i++) {
            System.out.println(gen.next());
        }
        for (StoryCharacters st : new StoryCharactersGenerator(7)) {
            System.out.println(st);
        }
    }
}
