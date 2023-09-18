package exercises;

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw(); // вызов полиморфного метода внутри конструктора!
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

class RectangularGlyph extends Glyph {
    private int lengthOfSide = 5;

    RectangularGlyph(int side) {
        lengthOfSide = side;
        System.out.println("RectangularGlyph.RectangularGlyph(), lengthOfSide = " + lengthOfSide);
    }

    @Override
    void draw() {
        System.out.println("RectangularGlyph.draw(), lengthOfSide = " + lengthOfSide);
    }
}

public class _07_14_PolymorphicMethodInsideConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
        new RectangularGlyph(5);
    }
}
