package exercises;

import java.io.*;
import java.util.*;


abstract class ShapeSS implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public ShapeSS(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }

    public String toString() {
        return getClass() + "color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static ShapeSS randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new CircleS(xVal, yVal, dim);
            case 1:
                return new SquareS(xVal, yVal, dim);
            case 2:
                return new LineS(xVal, yVal, dim);
        }
    }
}

class CircleS extends ShapeSS {
    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public CircleS(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

class SquareS extends ShapeSS {
    private static int color;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public SquareS(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
        color = RED;
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

class LineS extends ShapeSS {
    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public LineS(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

class StoreCADState {
    public static void main(String[] args) throws Exception {
        List<ShapeSS> shapes = new ArrayList<ShapeSS>();
        // Make some shapes:
        for (int i = 0; i < 10; i++)
            shapes.add(ShapeSS.randomFactory());
        // Set all the static colors to GREEN:
        for (int i = 0; i < 10; i++)
            ((ShapeSS) shapes.get(i)).setColor(ShapeSS.GREEN);
        // Save the state vector:
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        LineS.serializeStaticState(out);
        CircleS.serializeStaticState(out);
        SquareS.serializeStaticState(out);
        out.writeObject(shapes);
        // Display the shapes:
        System.out.println(shapes);
    }
}

class RecoverCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        StoreCADState.main(null);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        // Read in the same order they were written:
        LineS.deserializeStaticState(in);
        CircleS.deserializeStaticState(in);
        SquareS.deserializeStaticState(in);
        List<ShapeSS> shapes = (List<ShapeSS>) in.readObject();
        System.out.println(shapes);
    }
}

public class _17_30_SerializingStaticFileds {
    public static void main(String[] args) throws Exception {
        RecoverCADState.main(null);
    }
}
