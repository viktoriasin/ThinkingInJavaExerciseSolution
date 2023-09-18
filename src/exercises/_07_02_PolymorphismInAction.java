package exercises;

import java.util.*;


class ShapeV2 {
    public void draw() {
    }

    public void erase() {
    }

    public void printMessage() {
        System.out.println("Print shape message");
    }
}

class Circle extends ShapeV2 {
    @Override
    public void draw() {
        System.out.println("CircleS.draw()");
    }

    @Override
    public void erase() {
        System.out.println("CircleS.erase()");
    }

    @Override
    public void printMessage() {
        System.out.println("Print circle message");
    }
}

class SquareV2 extends ShapeV2 {
    @Override
    public void draw() {
        System.out.println("SquareS.draw()");
    }

    @Override
    public void erase() {
        System.out.println("SquareS.erase()");
    }
}


class TriangleV2 extends ShapeV2 {
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }
}

class RandomShapeGenerator {
    private Random rand = new Random(47);

    public ShapeV2 next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new SquareV2();
            case 2:
                return new TriangleV2();
        }
    }
}

class Shapes {
}

public class _07_02_PolymorphismInAction {
    private static RandomShapeGenerator gen =
            new RandomShapeGenerator();

    public static void main(String[] args) {
        ShapeV2[] s = new ShapeV2[9];
        // Fill up the array with shapes:
        for (int i = 0; i < s.length; i++)
            s[i] = gen.next();
        // Make polymorphic method calls:
        for (ShapeV2 shp : s) {
            shp.draw();
            shp.printMessage();
        }
    }
}
