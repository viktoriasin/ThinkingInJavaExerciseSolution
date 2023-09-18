package exercises;

import java.util.Arrays;
import java.util.List;

class SimpleHolder<T> {
    private T obj1;
    private T obj2;
    private T obj3;

    public List<T> getObj() {
        return Arrays.asList(obj1, obj2, obj3);
    }

    public void setObj(T a, T a2, T a3) {
        obj1 = a;
        obj2 = a2;
        obj3 = a3;

    }

    SimpleHolder(T a1, T a2, T a3) {
        obj1 = a1;
        obj2 = a2;
        obj3 = a3;
    }

}

class SimpleTestClass {}

public class _14_02_HolderExample {
    public static void main(String[] args) {
        SimpleHolder<SimpleTestClass> t = new SimpleHolder<>(new SimpleTestClass(), new SimpleTestClass(), new SimpleTestClass());
    }
}
