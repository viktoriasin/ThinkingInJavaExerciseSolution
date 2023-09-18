package exercises;

import testPackage.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _16_01_ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Countries.names(9));
        List<String> namesLinked = new LinkedList<>(Countries.names(9));
        System.out.println(names);
        System.out.println(namesLinked);
        Collections.sort(names);
        Collections.sort(namesLinked);
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(names);
            Collections.shuffle(namesLinked);

            System.out.println(i + " " + names);
            System.out.println(i + " " + namesLinked);
        }
    }
}
