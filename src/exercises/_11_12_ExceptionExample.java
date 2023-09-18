package exercises;


class SequenceV129 {
    private Object[] items;
    private int next = 0;

    public SequenceV129(int size) {
        items = new Object[size];
    }

    public void add(Object x) { // нет необходимости указывать выбрасываемое RuTime исключение в сигнатуре метода
        if (next < items.length) {
            items[next++] = x;
        } else {
            throw new ArrayIndexOutOfBoundsException("Array's size is smaller than given index!");
        }

    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

}


public class _11_12_ExceptionExample {
    public static void main(String[] args) {
        SequenceV129 sequence = new SequenceV129(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        sequence.add(Integer.toString(11));

    }
}

