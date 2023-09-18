package exercises;


class Shape {
    static void draw() {
        System.out.println("Drawing something");
    }
    Shape() {
        System.out.println("ShapeSS constructor");
    }
}

class Triangle extends Shape {
    static int len = 3;
    static {
        System.out.println("Triangle is called");
    }
    Triangle() {
        System.out.println("Triangle constructor");
    }
}

class TriangleAdvanced extends  Triangle {
    TriangleAdvanced() {
        System.out.println("TriangleAdvanced constructor");
    }
}

public class _06_04_BaseClassConstructorTest {
    public static void main(String[] args) {
        TriangleAdvanced t = new TriangleAdvanced();
    }
}
