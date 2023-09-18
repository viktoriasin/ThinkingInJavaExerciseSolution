package exercises;

class Cleanser_v2 {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        System.out.println(x);
    } }

class Detergent_v2 extends Cleanser_v2 {

    private Cleanser_v2 cleanser;
    Detergent_v2(Cleanser_v2 cleanser) {
        this.cleanser = cleanser;
    }

    public void append(String a) {  cleanser.append(a); }
    public void dilute() { cleanser.dilute(); }
    public void apply() {
        cleanser.apply();
    }
    public void scrub() {
        cleanser.append("Detergent scrub");
        cleanser.scrub();
    }
    // Add methods to the interface:
    public void foam() { cleanser.append(" foam()"); }
    // Test the new class:

    public String toString() { return cleanser.toString(); }
}

public class _06_10_Delegation {
    public static void main(String[] args) {
        Detergent_v2 x = new Detergent_v2(new Cleanser_v2());
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser_v2.main(args);
    }
}
