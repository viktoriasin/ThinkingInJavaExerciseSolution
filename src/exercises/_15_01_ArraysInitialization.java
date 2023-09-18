package exercises;

import java.util.*;

class BerylliumSphere implements Comparable<BerylliumSphere> {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Sphere " + id; }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(BerylliumSphere o) {
        return (Long.compare(this.id, o.getId()));
    }
}

public class _15_01_ArraysInitialization {
    public static void createArray(BerylliumSphere[] arg) {
        for (BerylliumSphere b : arg) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        createArray(new BerylliumSphere[]{new BerylliumSphere()});
//        createArray({new BerylliumSphere(), new BerylliumSphere()}); does not work
        BerylliumSphere[] bo = {new BerylliumSphere(), new BerylliumSphere()};
        BerylliumSphere[] jo;
//        jo = {new BerylliumSphere(), new BerylliumSphere()}; // does not work


    }
}
