package exercises;

import java.util.ArrayList;
import java.util.List;

class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }
}

public class _14_29_CaptureConversion {
        public static void holderTake(Holder<List<?>> arg, List<?> val) {
            arg.set(val);
            List<?> l = arg.get();
//            arg.get().set(0, 2);
            Object someReturnValue = arg.get().get(0);
//            l.add(1);
        }

        public  static void listTake(List<Holder<?>> arg) {
            arg.add(new Holder<Integer>());
            arg.add(new Holder<String>());
            arg.add(new Holder<Object>());
            Holder<?> h = arg.get(0);
//            Holder<Integer> hh = arg.get(0); don't ok
            Object obj = arg.get(0);
            System.out.println(arg.get(0).getClass() );

        }

    public static void main(String[] args) {
        listTake(new ArrayList<>());
    }
}

