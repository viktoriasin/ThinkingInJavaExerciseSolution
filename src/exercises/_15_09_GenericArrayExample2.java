package exercises;

import java.util.ArrayList;
import java.util.List;

class Peel<T> {
}

class Banana {
}

public class _15_09_GenericArrayExample2 {
    public static void main(String[] args) {
//        Peel<Banana>[] peels = new Peel<Banana> [10]; // Illegal
        List<Peel<Banana>> peels = new ArrayList<>();
    }
}
