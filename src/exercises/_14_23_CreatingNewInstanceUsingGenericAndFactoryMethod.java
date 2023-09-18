package exercises;

interface FactoryI<T> {
    T create(Object arg);
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory, Object arg) {
        x = factory.create(arg);
    }
}

class IntegerFactory implements FactoryI<Integer> {
    public Integer create(Object arg) {
        return new Integer((Integer) arg);
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        public Widget create(Object arg) {
            return new Widget();
        }
    }
}

class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory(), 2);
        new Foo2<Widget>(new Widget.Factory(), 1);
    }
}


public class _14_23_CreatingNewInstanceUsingGenericAndFactoryMethod {
    public static void main(String[] args) {
        FactoryConstraint.main(null);
    }
}
