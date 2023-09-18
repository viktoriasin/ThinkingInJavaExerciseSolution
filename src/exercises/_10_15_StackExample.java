package exercises;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

class Stack<T> {
    private LinkedList<T> storage = new LinkedList<T>();
    public void push(T v) { storage.addFirst(v); }
    public T peek() { return storage.getFirst(); }
    public T pop() { return storage.removeFirst(); }
    public boolean empty() { return storage.isEmpty(); }
    public String toString() { return storage.toString(); }
}

public class _10_15_StackExample {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        String s = "+U+n+c—+e+r+t—+a-+i-+n+t+y—+ -+r+u—+l+e+s—";
        ListIterator<String> it = new LinkedList<String>(Arrays.asList(s.split(""))).listIterator();
        while (it.hasNext()) {
            String nxt = it.next();
            switch(nxt) {
                case "+": st.push(it.next()); break;
                case "—":
                case "-": st.pop(); break;
                default: st.push("Unknown");
            }
        }
        System.out.println(st);
    }
}
