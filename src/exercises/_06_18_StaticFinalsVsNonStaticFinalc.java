package exercises;
import java.util.*;

public class _06_18_StaticFinalsVsNonStaticFinalc {
    private static Random rand = new Random(47);
    static final int X = rand.nextInt(20);
    final int Y = rand.nextInt(20);

    public static void main(String[] args) {
        _06_18_StaticFinalsVsNonStaticFinalc obj1 = new _06_18_StaticFinalsVsNonStaticFinalc();
        _06_18_StaticFinalsVsNonStaticFinalc obj2 = new _06_18_StaticFinalsVsNonStaticFinalc();
        System.out.println("obj1 X " + obj1.X + " Y " + obj1.Y ); // X будут одинаковыми у объектов так как статические
        System.out.println("obj1 X " + obj2.X + " Y " + obj2.Y ); // Y будут разными у объектов так как нестатические
    }
}
