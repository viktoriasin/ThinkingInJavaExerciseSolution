package exercises;

import java.util.*;

abstract class ShapeV127 {
    void draw() { System.out.println(this + ".draw()"); }
    public void rotate() {};
    abstract public String toString();
    public boolean highlighted = false;
}
class CircleV127 extends ShapeV127 {
    public String toString() { return highlighted + " CircleS" ; }
}
class SquareV127 extends ShapeV127 {
    public String toString() { return highlighted + " SquareS" ; }
    public void rotate() {
        System.out.println("Rotating SquareS!");
    }
}
class TriangleV127 extends ShapeV127 {
    public String toString() { return highlighted + " Triangle"; }
    public void rotate() {
        System.out.println("Rotating Triangle!");
    }
}

class RhomboidV127 extends ShapeV127 {
    public String toString() { return highlighted + " Rhomboid, "; }
    public void rotate() {
        System.out.println("Rotating Rhomboid!");
    }
}

class ShapesV127 {
    public static void rotate(ShapeV127 sh) {
        if (!(sh instanceof CircleV127)) {
            sh.rotate();
        }
    }

    public static void setFlag(ShapeV127 sh)  {
        Class thatClass = sh.getClass();
        System.out.println(thatClass.getSimpleName());
        if (thatClass.getSimpleName().equals("TriangleV127") || thatClass.getSimpleName().equals("RhomboidV127")) {
            sh.highlighted = true;
        }
    }

    public static void main(String[] args) {
        List<ShapeV127> shapeList = Arrays.asList(
                new CircleV127(), new SquareV127(), new TriangleV127(), new RhomboidV127()
        );
        ShapeV127 c = new CircleV127();
        ShapeV127 r = new RhomboidV127(); // upcast
        RhomboidV127 o = (RhomboidV127) r; //downcast
//        CircleV127 cc = (CircleV127) r; // ClassCastException exception!
        if (r instanceof CircleV127) {
            CircleV127 cc = (CircleV127) r;
        }

        for(ShapeV127 shape : shapeList)
            shape.draw();

        for(ShapeV127 shape : shapeList)
            rotate(shape);

        for(ShapeV127 shape : shapeList)
            setFlag(shape);

        for(ShapeV127 shape : shapeList)
            shape.draw();
    }
}

public class _13_03_RTTIExampleV2 {
    public static void main(String[] args) {
        ShapesV127.main(null);
    }
}
