package testPackage;

import exercises._13_25_TestAccessForPrivateFileds;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class _13_25_ReachingPrivateFields {
    static void callHiddenMethod(Object a, String methodName)
            throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
    static void callHiddenIntField(Object a, String fileddName)
            throws Exception {
        Field f = a.getClass().getDeclaredField(fileddName);
        f.setAccessible(true);
        System.out.println("f.getInt(pf): " + f.getInt(a));
    }

    static void callHiddenStringField(Object a, String fileddName)
            throws Exception {
        Field f = a.getClass().getDeclaredField(fileddName);
        f.setAccessible(true);
        System.out.println("f.getInt(pf): " + f.get(a));
    }

    static void callHiddenDoublegField(Object a, String fileddName)
            throws Exception {
        Field f = a.getClass().getDeclaredField(fileddName);
        f.setAccessible(true);
        System.out.println("f.getInt(pf): " + f.getDouble(a));
    }



    public static void main(String[] args) throws Exception {
        _13_25_TestAccessForPrivateFileds obj = new _13_25_TestAccessForPrivateFileds();
        callHiddenIntField(obj, "i");
        callHiddenStringField(obj, "s");
        callHiddenStringField(obj, "ss");
        callHiddenDoublegField(obj, "d");
    }
}
