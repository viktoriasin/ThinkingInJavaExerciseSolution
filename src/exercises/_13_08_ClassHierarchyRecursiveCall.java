package exercises;

import java.util.Arrays;
import java.util.Objects;


class HJK {
    private int i;
    public String s;

};
class QWE extends HJK {};
class KBJ extends QWE {
    public int kbj;
};

public class _13_08_ClassHierarchyRecursiveCall {

    public static int gettHierarchy(Object obj) throws InstantiationException, IllegalAccessException {
        Class up = obj.getClass().getSuperclass();
        if (Objects.equals(up.getSimpleName(), "Object")) {
            System.out.println(up.getCanonicalName());
            System.out.println("!!!Found!!!All!!!");
            return 1;
        } else {
            System.out.println(up.getCanonicalName());
            Object objV2 = up.newInstance();
            System.out.println(Arrays.toString(up.getDeclaredFields()));
            return gettHierarchy(objV2);
        }

    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        gettHierarchy(new KBJ());
    }
}
