package exercises;

import java.util.ArrayList;

class GerbilV127 {
    int gerbilNumber;
    GerbilV127(int num) {
        gerbilNumber = num;
    }

    public int hop() {
        return gerbilNumber;
    }
}

public class _10_01_BasicArrayList {
    public static void main(String[] args) {
        ArrayList<GerbilV127> array = new ArrayList<GerbilV127>();
        array.add(new GerbilV127(11));
        array.add(new GerbilV127(15));
        array.add(new GerbilV127(17));

        for (GerbilV127 g : array) {
            System.out.println(g.hop());
        }
    }
}
