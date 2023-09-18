package exercises;

interface SelectorV123 {
    boolean end();
    Object current();
    void next();
}

class SequenceV123<T> {
    private T[] items;
    private int next = 0;
    public SequenceV123(int size) { items = (T[]) new Object[size]; }
    public void add(T x) {
        if(next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}

public class _14_04_GenerifySequenceSelector {
}
