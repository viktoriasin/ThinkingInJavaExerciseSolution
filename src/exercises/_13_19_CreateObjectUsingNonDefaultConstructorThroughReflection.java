package exercises;

import java.lang.reflect.InvocationTargetException;

interface HasBatteriesV2 {}
interface WaterproofV2 {}
interface ShootsV2 {}
class ToyV2 {
    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    ToyV2() {}
    ToyV2(int i) {}
}
class FancyToyV2 extends ToyV2
        implements HasBatteries, Waterproof, Shoots {
    FancyToyV2() { super(1); }
}
class ToyTestV2 {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        } catch(ClassNotFoundException e) {
            System.out.println("Can’t find FancyToy");
            System.exit(1);
        }
        printInfo(c);


        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance(); // так мы можем создать объект, только через дефотный конструктор
            up.getConstructor(int.class).newInstance(1); // а вот через рефлексию мы можем создвть обхект не только через дефотный конструктор
        } catch(InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch(IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        } catch (NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        printInfo(obj.getClass());
    }
}

public class _13_19_CreateObjectUsingNonDefaultConstructorThroughReflection {
    public static void main(String[] args) {
        ToyTestV2.main(null);
    }
}
