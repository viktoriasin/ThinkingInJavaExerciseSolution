package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class A179 {
    private static int i = 0;
    private final int counter = i++;

    public String toString() {
        return Integer.toString(counter);
    }
}

public class _10_07_ListExample {
    public static void main(String[] args) {
        A179[] a = {new A179(), new A179(), new A179(), new A179(), new A179()};
        List<A179> apples = new ArrayList<A179>();
        Collections.addAll(apples, a);
        System.out.println("1: " + apples);
        List<A179> applesv2 =  apples.subList(1, 3);
        System.out.println("2: " + applesv2);
        applesv2.add(new A179());
        System.out.println("3: " + apples);
        apples.removeAll(applesv2);
        System.out.println("4: " + apples);
    }
}
