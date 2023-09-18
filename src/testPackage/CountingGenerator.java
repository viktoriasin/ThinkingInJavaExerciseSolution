package testPackage;


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

    public static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Character implements GeneratorV2<java.lang.Character> {
        int index = -1;

        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

    public static class String implements GeneratorV2<java.lang.String> {
        private int length = 7;
        GeneratorV2<java.lang.Character> cg = new CountingGenerator.Character();

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

    public static class BigDecimalGenerator implements GeneratorV2<java.math.BigDecimal> {
        private BigDecimal value = new BigDecimal(0);

        @Override
        public BigDecimal next() {
            value = value.add(BigDecimal.valueOf(1));
            return value;
        }
    }
}


