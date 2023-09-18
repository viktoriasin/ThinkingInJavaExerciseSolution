package exercises;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    Employee() {
        System.out.println("Using default constructor to create new object.");
    }

    Employee(int i) {
        System.out.println("Using integer constructor to create new object.");
    }

    Employee(int i, double d) {
        System.out.println("Using integer and double constructor to create new object.");
    }
}


class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind, List<Class<?>> types, List<Object> initargs) {
        try {
            x = kind.getConstructor(types.toArray(new Class[0])).newInstance(initargs.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ClassAsFactory(Class<T> kind, List<Object> initargs) {
        this(kind, initargs.stream().map(Object::getClass).collect(Collectors.toList()), initargs);
    }

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

class InstantiateGenericType {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class, Collections.singletonList(int.class), Collections.singletonList(1));
            System.out.println("ClassAsFactory<Integer> succeeded");
            System.out.println((Integer) fi.x);
        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}

public class _14_22_CreatingNewInstanceOfObjectsUsingGeneric {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        InstantiateGenericType.main(null);
    }
}
