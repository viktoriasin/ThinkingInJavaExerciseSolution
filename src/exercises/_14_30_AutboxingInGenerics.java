package exercises;

public class _14_30_AutboxingInGenerics {
    public static void main(String[] args) {
        Holder<Integer> intHolder = new Holder<>();
        intHolder.set(1);
        int intN = intHolder.get();


        Holder<Boolean> booleanHolder = new Holder<>();
        booleanHolder.set(true);
        boolean bolleanN = booleanHolder.get();

        Holder<Double> doubleHolder = new Holder<>();
        doubleHolder.set(2.2);
        double doubleN = doubleHolder.get();

    }
}
