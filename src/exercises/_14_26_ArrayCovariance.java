package exercises;

import java.util.ArrayList;
import java.util.List;

public class _14_26_ArrayCovariance {
    public static void main(String[] args) {
        Number[] n = new Integer[10]; // covariant
//        List<Number> nn = new ArrayList<Integer>();  // not covariant
        List<? extends Number> nn = new ArrayList<Integer>();
//        nn.add(2); // do not compile
        Number number = nn.get(0);
    }
}
