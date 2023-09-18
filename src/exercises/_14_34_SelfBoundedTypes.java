package exercises;




abstract class SelfBoundedGeneric<T extends SelfBoundedGeneric<T>> {
    abstract T returnGenericParameter(T arg);

    public T callAbstractMethod(T arg) {
        return returnGenericParameter(arg);
    }

    public static void doSomethong() {}

}

class SimpleClassV2 extends SelfBoundedGeneric<SimpleClassV2> {

    @Override
    SimpleClassV2 returnGenericParameter(SimpleClassV2 arg) {
        return arg;
    }


    public static void main(String[] args) {
        SimpleClassV2 s = new SimpleClassV2();
        System.out.println(s.callAbstractMethod(s).returnGenericParameter(s).getClass().getSimpleName());
    }
}


public class _14_34_SelfBoundedTypes {
    public static void main(String[] args) {
        SimpleClassV2.main(null);
    }
}





//
//
//
//
//class Base<T> {
//    int i = 0;
//}
//
//class Derived extends Base<Integer> {
//}
//
//interface OrdinaryGetter {
//    Base get(Number N);
//
//    void set(Base b);
//}
//
//interface DerivedGetter extends OrdinaryGetter {
//    // Return type of overridden method is allowed to vary:
//    Derived get(Number N);
//    Derived get();
//
//    void set(Derived b);
//}
//
//class CovariantReturnTypes {
//    void test(DerivedGetter d) {
//
//        Base b = new Derived();
//        Base d2 = d.get();
//    }
//
//    void test1(DerivedGetter1 d) {
//
//    }
//}
//
//public class _14_34_SelfBoundedTypes {
//}
//
//
//class OrdinaryGetterImpl implements OrdinaryGetter {
//
//    @Override
//    public Base get(Number N) {
//        return new Derived();
//    }
//}
//
//
//class BaseGetter {
//
//    Base get() {
//        doSomething();
//        return new Base();
//    }
//
//    protected void doSomething() {
//
//    }
//}
//
//class DerivedGetter1 extends BaseGetter {
//
//    @Override
//    Derived get() {
//        doSomething();
//        return new Derived();
//    }
//
//    void test() {
//        doSomething();
//    }
//
//    void set(Base b) {
//
//    }
//
//    void set(Derived b) {
//
//    }
//}
