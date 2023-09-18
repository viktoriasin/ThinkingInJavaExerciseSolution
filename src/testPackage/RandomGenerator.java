package testPackage;

import java.util.*;

interface GeneratorV2<T> {
    T next();
}

public class RandomGenerator {
    private static Random r = new Random(47);

    public static class Boolean implements GeneratorV2<java.lang.Boolean> {
        public java.lang.Boolean next() {
            return r.nextBoolean();
        }
    }

    public static class Byte implements GeneratorV2<java.lang.Byte> {
        public java.lang.Byte next() {
            return (byte) r.nextInt();
        }
    }

    public static class Character implements GeneratorV2<java.lang.Character> {
        public java.lang.Character next() {
            return CountingGenerator.chars[r.nextInt(CountingGenerator.chars.length)];

        }
    }

    public static class String extends CountingGenerator.String {
        // Plug in the random Character generator:
        {
            cg = new Character();
        } // Instance initializer

        public String() {
        }

        public String(int length) {
            super(length);
        }
    }

    public static class Short implements GeneratorV2<java.lang.Short> {
        public java.lang.Short next() {
            return (short) r.nextInt();
        }
    }

    public static class Integer implements GeneratorV2<java.lang.Integer> {
        private int mod = 10000;

        public Integer() {
        }

        public Integer(int modulo) {
            mod = modulo;
        }

        public java.lang.Integer next() {
            return r.nextInt(mod);
        }
    }

    public static class Long implements GeneratorV2<java.lang.Long> {
        private int mod = 10000;

        public Long() {
        }

        public Long(int modulo) {
            mod = modulo;
        }

        public java.lang.Long next() {
            return new java.lang.Long(r.nextInt(mod));
        }
    }

    public static class Float implements GeneratorV2<java.lang.Float> {
        public java.lang.Float next() {
            // Trim all but the first two decimal places:
            int trimmed = Math.round(r.nextFloat() * 100);
            return ((float) trimmed) / 100;
        }
    }

    public static class Double implements GeneratorV2<java.lang.Double> {
        public java.lang.Double next() {
            long trimmed = Math.round(r.nextDouble() * 100);
            return ((double) trimmed) / 100;
        }
    }
}
