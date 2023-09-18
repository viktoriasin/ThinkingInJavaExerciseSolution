package exercises;

enum Moneys {
     FIVE, TEN, Hundred, THOUSAND
}

public class _04_21_Enums {
    public static void main(String[] args) {
        for (Moneys m : Moneys.values()) {
            System.out.println(m + ", ordinal " + m.ordinal());
        }
        Moneys mm = Moneys.FIVE;
        switch (mm) {
            case FIVE:
                System.out.println("FIVE");
                break;
            case TEN: System.out.println("TEN");
                break;
            case Hundred:
                System.out.println("Hunderd");
                break;
            case THOUSAND:
                System.out.println(("Thousand"));
                break;
            default:
                System.out.println("Unknown currency");
        }
    }

}
