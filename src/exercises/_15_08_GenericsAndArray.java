package exercises;

class TestGenericArray<T> {
    T[] array;

    @SuppressWarnings("unchecked")
    public TestGenericArray(int size) {
//        array = new T[size]; // Illegal
        array = (T[]) new Object[size];
    }

//    public <U> U makeArray() {
//        return new U[10]; // Illegal
//    }
}

public class _15_08_GenericsAndArray {
    public static void main(String[] args) {
        new TestGenericArray<Integer>(2);
    }
}
