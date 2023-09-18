package exercises;

import java.util.Arrays;

public class _15_18_ArrayShallowCopy {
    public static void main(String[] args) {
        BerylliumSphere[] b = new BerylliumSphere[10];
        Arrays.fill(b, new BerylliumSphere());
        System.out.println(Arrays.toString(b)); // no new BerylliumSphere objects created in array, just copying the references
        BerylliumSphere[] newB = new BerylliumSphere[10];
        System.arraycopy(b, 0, newB, 0, b.length );
        System.out.println(Arrays.toString(newB));
        b[0] = new BerylliumSphere();
        b[1] = null;
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(newB));
    }
}
