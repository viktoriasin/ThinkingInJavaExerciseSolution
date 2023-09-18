package exercises;

import java.util.ArrayList;

class FixedSizeStack<T> {
    private int index = 0;
    private final ArrayList<T> storage;
    public FixedSizeStack() {
        storage = new ArrayList<T>();
    }
    public void push(T item) { storage.set(index++, item); }
    @SuppressWarnings("unchecked")
    public T pop() { return storage.get(--index); }
}

public class _14_32_GenericCast {
    public static void main(String[] args) {
        FixedSizeStack<String> strings =
                new FixedSizeStack<String>();
        for(String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
        for(int i = 0; i < 10; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
        strings.push("123");

    }
}

