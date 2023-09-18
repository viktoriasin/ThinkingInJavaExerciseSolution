package exercises;


import java.util.Arrays;
import java.util.Collection;

class ContainerArray<T> {
    private final int initialSize = 3;
    private int CAPACITY_FACTOR = 500;
    private Object[] arrayString = new Object[initialSize];
    private int lastAvaliableIndex = 0;

    public void resizeBackToInitialSize() {
        arrayString = new Object[initialSize];
        lastAvaliableIndex = 0;
    }

    public void addAll(Collection<T> c) {
        for (T elem : c) {
            add(elem);
        }
    }

    public void clear() {
        Arrays.fill(arrayString, null);
        lastAvaliableIndex = 0;
    }

    public int size() {
        return arrayString.length;
    }


    private void resize() {
        Object[] tempArray = new Object[arrayString.length + CAPACITY_FACTOR];
        System.arraycopy(arrayString, 0, tempArray, 0, arrayString.length);
        arrayString = tempArray;
    }

    public void add(T s) {
        int index = lastAvaliableIndex;
        add(index, s);
        lastAvaliableIndex++;
    }

    public void add(int index, T s) {
        if (index >= arrayString.length) {
            resize();
        }
//        System.out.println("element " + s);
//        System.out.println("index " + index);
//        System.out.println("length " + arrayString.length);
        arrayString[index] = s;
    }

    public Object get(int index) {
        return arrayString[index];
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] == null) {
                break;
            }
            builder.append(arrayString[i]);
            builder.append(", ");
        }
        if (builder.length() != 0) {
            builder.delete(builder.length() - 2, builder.length());
        }
        builder.append("]");
        return builder.toString();
    }

}

public class _16_31_ResizingArrayImplementation {
    public static void main(String[] args) {
        ContainerArray<String> c = new ContainerArray<>();
        c.add("L");
        c.add("L");
        c.add("L");
        c.add("L");
        c.add("L");
        c.add("L");
        c.add("L");
        System.out.println(c);

        ContainerArray<Integer> cI = new ContainerArray<>();
        cI.add(2);
        cI.add(3);

        System.out.println(cI);
    }
}
