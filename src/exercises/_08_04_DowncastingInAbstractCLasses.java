package exercises;

abstract class I {
};

abstract class Y {
    abstract void say();
}

class G extends I {
    void gg() {
        System.out.println("In gg ...");
    }

    ;

    static void ggStatic(I ref) {
        ((G) ref).gg();
    }

}

class Ee extends Y {
    void say() {
        System.out.println("I'm from E!");
    }

    static void eeStatic(Y ref) {
        ref.say(); // no need for downcasting
    }
}

public class _08_04_DowncastingInAbstractCLasses {
    public static void main(String[] args) {
        G.ggStatic(new G());
        Ee.eeStatic(new Ee());
    }
}
