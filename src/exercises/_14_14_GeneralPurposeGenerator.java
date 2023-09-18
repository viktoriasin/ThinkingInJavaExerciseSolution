package exercises;

class BasicGenerator<T> implements GeneratorV2<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type){ this.type = type; }

    public T next() {
        try {
            // Assumes type is a public class:
            return type.newInstance();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    // Produce a Default generator given a type token:
    public static <T> GeneratorV2<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
}

class CountedObject {
    private static long counter = 0;
    private final long id = counter++;
    public long id() { return id; }
    public String toString() { return "CountedObject " + id;}
}

public class _14_14_GeneralPurposeGenerator {
    public static void main(String[] args) {
        GeneratorV2<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
        for(int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
}
