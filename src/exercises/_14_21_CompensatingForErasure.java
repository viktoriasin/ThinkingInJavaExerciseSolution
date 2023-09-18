package exercises;

import java.util.HashMap;
import java.util.Map;

class Building {
}

class House extends Building {
}

class ClassTypeCapture {
    Map<String, Class<?>> mapData;

    public boolean f(Object arg) {
        for (Class<?> kind : mapData.values()) {
            if (kind.isInstance(arg)) {
                return true;
            }
        }
        return false;
    }

    public void addType(String typename, Class<?> kind) {
        mapData.put(typename, kind);
    }

    public Object createNew(String typename) {
        try {
            return mapData.get(typename).newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public ClassTypeCapture() {
        mapData = new HashMap<>();
    }


    public static void main(String[] args) {
        ClassTypeCapture ctt1 =
                new ClassTypeCapture();
//        System.out.println(ctt1.f(new Building()));
//        System.out.println(ctt1.f(new House()));
//        ClassTypeCapture<House> ctt2 =
//                new ClassTypeCapture<House>(House.class);
//        System.out.println(ctt2.f(new Building()));
//        System.out.println(ctt2.f(new House()));

        ctt1.addType("Building", Building.class);
        ctt1.addType("House", House.class);
        System.out.println(ctt1.createNew("Building"));


        Building building = (Building) ctt1.createNew("Building");
    }
}

public class _14_21_CompensatingForErasure {
    public static void main(String[] args) {
        ClassTypeCapture.main(null);
    }
}
