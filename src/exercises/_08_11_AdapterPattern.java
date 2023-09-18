package exercises;

interface Processor {
    String name();

    Object process(Object input);
}

class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}

class SwapElements {
    public String name() {
        return getClass().getSimpleName();
    }

    public String process(Object input) {
        return ((String) input).replaceFirst("(.)(.)", "$2$1");
    }
}

class SwapAdapter implements Processor {
    SwapElements sw;

    public SwapAdapter(SwapElements sw) {
        this.sw = sw;
    }

    public String name() {
        return sw.name();
    }

    public String process(Object input) {
        return sw.process((String) input);
    }
}


public class _08_11_AdapterPattern {
    public static void main(String[] args) {
        Apply.process(new SwapAdapter(new SwapElements()), "Hey");
    }
}
