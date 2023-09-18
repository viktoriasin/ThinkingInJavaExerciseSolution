package exercises;

class Coffee {
    private String value;

    public void set(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}

class Decorator extends Coffee {
    protected Coffee basic;

    public Decorator(Coffee basic) {
        this.basic = basic;
    }

    public void set(String val) {
        basic.set(val);
    }

    public String get() {
        return basic.get();
    }
}

class StreamedMilk extends Decorator {
    StreamedMilk(Coffee basic) {
        super(basic);
    }

    public void addMilk() {
        System.out.println("Add milk!");
    }
}

class Foam extends Decorator {
    Foam(Coffee basic) {
        super(basic);
    }

    public void addFoam() {
        System.out.println("Add foam!");
    }
}

class Caramel extends Decorator {
    Caramel(Coffee basic) {
        super(basic);
    }

    public void addCaramel() {
        System.out.println("Add caramel!");
    }
}

class WhippedCream extends Decorator {
    WhippedCream(Coffee basic) {
        super(basic);
    }

    public void addWhippedCream() {
        System.out.println("Add whipped cream!");
    }
}

public class _14_38_MixinsUsingDecoratorPattern {
    public static void main(String[] args) {
        WhippedCream coffee = new WhippedCream(new Caramel(new Foam(new StreamedMilk(new Decorator(new Coffee())))));
        coffee.addWhippedCream();
//        coffee.addCaramel()

    }
}
