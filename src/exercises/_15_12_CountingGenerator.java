package exercises;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

class CountingGenerator {
    public static class Boolean implements GeneratorV2<java.lang.Boolean> {
        private boolean value = false;

        public java.lang.Boolean next(

        ) {
            value = !value; // Just flips back and forth
            return value;
        }
    }

    public static class Byte implements GeneratorV2<java.lang.Byte> {
        private byte value = 0;

        public java.lang.Byte next() {
            return value++;
        }
    }

    public static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Character implements GeneratorV2<java.lang.Character> {
        int index = -1;

        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

    public static class String implements GeneratorV2<java.lang.String> {
        private int length = 7;
        GeneratorV2<java.lang.Character> cg = new Character();

        public String() {
        }

        public String(int length) {
            this.length = length;
        }

        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++)
                buf[i] = cg.next();
            return new java.lang.String(buf);
        }
    }

    public static class Short implements GeneratorV2<java.lang.Short> {
        private short value = 0;

        public java.lang.Short next() {
            return value++;
        }
    }

    public static class Integer implements GeneratorV2<java.lang.Integer> {
        private int value = 0;

        public java.lang.Integer next() {
            return value++;
        }
    }

    public static class Long implements GeneratorV2<java.lang.Long> {
        private long value = 0;

        public java.lang.Long next() {
            return value++;
        }
    }

    public static class Float implements GeneratorV2<java.lang.Float> {
        private float value = 0;

        public java.lang.Float next() {
            float result = value;
            value += 1.0;
            return result;
        }
    }

    public static class Double implements GeneratorV2<java.lang.Double> {
        private double value = 0.0;

        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }
    }

    public static class SkipGenerator implements GeneratorV2<java.lang.Integer> {
        private int value = 0;
        int increment;

        SkipGenerator(int increment) {
            this.increment = increment;
        }

        public java.lang.Integer next() {
            int result = value;
            value += increment;
            return result;
        }
    }

    public static class BigDecimalGenerator implements  GeneratorV2<java.math.BigDecimal> {
        private BigDecimal value = new BigDecimal(0);

        @Override
        public BigDecimal next() {
            value = value.add(BigDecimal.valueOf(1));
            return value;
        }
    }
}

class DataGenerator {
    public static class BerylliumSphereGenerator implements GeneratorV2<BerylliumSphere> {
        @Override
        public BerylliumSphere next() {
            return new BerylliumSphere();
        }
    }
}

class CollectionData<T> extends ArrayList<T> {
    public CollectionData(GeneratorV2<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++)
            add(gen.next());
    }

    // A generic convenience method:
    public static <T> CollectionData<T>
    list(GeneratorV2<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}

class Generated {
    // Fill an existing array:
    public static <T> T[] array(T[] a, GeneratorV2<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    // Create a new array:
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, GeneratorV2<T> gen, int size) {
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }
}

public class _15_12_CountingGenerator {
    @SuppressWarnings("unchecked")
    public static <T> T[] generateArray(Class<T> type, int size) {
        try {
            GeneratorV2<T> obj = (GeneratorV2<T>) type.newInstance();
            T[] res = (T[]) new Object[size];
            for (int i = 0; i < size; i++) {
                res[i] = obj.next();
            }
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Double[] d = Generated.array(Double.class, new CountingGenerator.Double(), 10);

        GeneratorV2<java.lang.Character> cg = new CountingGenerator.Character();
        char[] ch = new char[7];
        for (int i = 0; i < 7; i++) {
            ch[i] = cg.next();
        }
        String s = new java.lang.String(ch);

        System.out.println(Arrays.toString(generateArray(CountingGenerator.Double.class, 10)));
        System.out.println(Arrays.toString(generateArray(CountingGenerator.Integer.class, 10)));
        System.out.println(Arrays.toString(generateArray(CountingGenerator.Character.class, 10)));
        System.out.println(Arrays.toString(generateArray(CountingGenerator.Short.class, 10)));
        System.out.println(Arrays.toString(generateArray(CountingGenerator.Byte.class, 10)));
        System.out.println(Arrays.toString(generateArray(CountingGenerator.Long.class, 10)));
        System.out.println(Arrays.toString(generateArray(CountingGenerator.Float.class, 10)));
        System.out.println(Arrays.toString(generateArray(CountingGenerator.String.class, 10)));

        System.out.println(Arrays.toString(Generated.array(BerylliumSphere.class, new DataGenerator.BerylliumSphereGenerator(), 10)));

        System.out.println(Arrays.toString(Generated.array(Integer.class, new CountingGenerator.SkipGenerator(7), 7)));
        System.out.println(Arrays.toString(Generated.array(BigDecimal.class, new CountingGenerator.BigDecimalGenerator(), 7)));
    }
}
