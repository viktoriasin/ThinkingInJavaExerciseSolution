package exercises;

import java.util.HashMap;
import java.util.Map;

interface FactoryIV2<T> {
    T create();
}

class BuildingV2 {

    public static class Factory implements FactoryIV2<BuildingV2> {
        public BuildingV2 create() {
            return new BuildingV2();
        }
    }
}

class HouseV2 extends BuildingV2 {
    public static class Factory implements FactoryIV2<HouseV2> {
        public HouseV2 create() {
            return new HouseV2();
        }
    }
}


class ClassTypeCaptureV2{
    Map<String, FactoryIV2<?>> mapData;

    public void addType(String typename, FactoryIV2<?> factory) {
        mapData.put(typename, factory);
    }

    public Object createNew(String typename) {
        try {
            return mapData.get(typename).create();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public ClassTypeCaptureV2() {
        mapData  = new HashMap<>();
    }

    public static void main(String[] args) {
        ClassTypeCaptureV2 ctt1 =
                new ClassTypeCaptureV2();
        ctt1.addType("Building", new BuildingV2.Factory());
        ctt1.addType("HouseV2", new HouseV2.Factory());
        System.out.println(ctt1.createNew("Building"));
        System.out.println(ctt1.createNew("HouseV2"));
//        System.out.println(ctt1.f(new Building()));
//        System.out.println(ctt1.f(new House()));
//        ClassTypeCapture<House> ctt2 =
//                new ClassTypeCapture<House>(House.class);
//        System.out.println(ctt2.f(new Building()));
//        System.out.println(ctt2.f(new House()));

    }
}


public class _14_24_FactoryObjectsIntheGenericArray {
    public static void main(String[] args) {
        ClassTypeCaptureV2.main(null);
    }
}
