package exercises;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

interface Selector11 {
    boolean end();
    Object current();
    void next();
}
class Sequence11 {
    private Object[] items;
    private int next = 0;
    public Sequence11(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }

    public Iterator<Object> getIterator() {
        return new ArrayList<Object>(Arrays.asList(items)).iterator();
    }
    private class SequenceSelector11 implements Selector11 {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
    }
    public Selector11 selector() {
        return new SequenceSelector11();
    }
    public static void main(String[] args) {
        Sequence11 sequence = new Sequence11(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));

        Iterator<Object> it = sequence.getIterator();

        while(it.hasNext()) {
            Object p = it.next();
            System.out.print(p);
        }

//        Selector11 selector = sequence.selector();
//        while(!selector.end()) {
//            System.out.print(selector.current() + " ");
//            selector.next();
//        }
    }
}

public class _10_08_SequenceIterator {
    public static void main(String[] args) {
        Sequence11.main(null);
    }
}
