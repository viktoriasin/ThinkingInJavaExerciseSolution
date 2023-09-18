package exercises;

import java.util.*;


interface Null {
}


class Part {
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories =
            new ArrayList<Factory<? extends Part>>();
//    static {
//        // Collections.addAll() gives an "unchecked generic
//        // array creation ... for varargs parameter" warning.
//        partFactories.add(new FuelFilter.FactoryInner());
//        partFactories.add(new AirFilter.FactoryInner());
//        partFactories.add(new CabinAirFilter.FactoryInner());
//        partFactories.add(new OilFilter.FactoryInner());
//        partFactories.add(new FanBelt.FactoryInner());
//        partFactories.add(new PowerSteeringBelt.FactoryInner());
//        partFactories.add(new GeneratorBelt.FactoryInner());
//    }

    // using class object to create factory object
    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        try {
            partFactories.add(FuelFilter.FactoryInner.class.newInstance());
            partFactories.add(AirFilter.FactoryInner.class.newInstance());
            partFactories.add(CabinAirFilter.FactoryInner.class.newInstance());
            partFactories.add(OilFilter.FactoryInner.class.newInstance());
            partFactories.add(FanBelt.FactoryInner.class.newInstance());
            partFactories.add(PowerSteeringBelt.FactoryInner.class.newInstance());
            partFactories.add(GeneratorBelt.FactoryInner.class.newInstance());
            partFactories.add(Filter.NullFilter.FactoryInner.class.newInstance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    private static Random rand = new Random(49);

    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}


class Filter extends Part {


    public static class NullFilter
            extends Filter implements Null {
        private NullFilter() {
            super();
        }

        public String toString() {
            return "NullFilter";
        }

        public static class FactoryInner
                implements Factory<NullFilter> {
            public NullFilter create() {
                return new NullFilter();
            }
        }
    }

    public static final Filter NULL = new NullFilter();
}

class FuelFilter extends Filter {
    // Create a Class Factory for each specific type:
    public static class FactoryInner
            implements Factory<FuelFilter> {
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class FactoryInner
            implements Factory<AirFilter> {
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class FactoryInner
            implements Factory<CabinAirFilter> {
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class FactoryInner
            implements Factory<OilFilter> {
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {
}

class FanBelt extends Belt {
    public static class FactoryInner
            implements Factory<FanBelt> {
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class FactoryInner
            implements Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class FactoryInner
            implements Factory<PowerSteeringBelt> {
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
}


public class _13_14_RegisteredFactories {
    public static void main(String[] args) {
        RegisteredFactories.main(null);
    }
}
