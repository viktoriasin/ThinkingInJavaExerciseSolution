package exercises;
import java.util.*;

enum Note {
    MIDDLE_C, C_SHARP, B_FLAT; // Etc.
}

class Instrument {
    void play(Note n) {
        System.out.println("Instrument.play() " + n); }
    String what() { return this.toString(); }
    void adjust() { System.out.println("Adjusting Instrument"); }
}
class Wind extends Instrument {
    void play(Note n) { System.out.println("Wind.play() " + n); }
    String what() { return this.toString(); }
    void adjust() { System.out.println("Adjusting Wind"); }
}
class Percussion extends Instrument {
    void play(Note n) { System.out.println("Percussion.play() " + n); }
    String what() { return this.toString(); }
    void adjust() { System.out.println("Adjusting Percussion"); }
}
class Stringed extends Instrument {
    void play(Note n) { System.out.println("Stringed.play() " + n); }
    String what() { return this.toString(); }
    void adjust() { System.out.println("Adjusting Stringed"); }
}
class Brass extends Wind {
    void play(Note n) { System.out.println("Brass.play() " + n); }
    void adjust() { System.out.println("Adjusting Brass"); }
}
class Woodwind extends Wind {
    void play(Note n) { System.out.println("Woodwind.play() " + n); }
    String what() { return "Woodwind"; }
}

class Piano extends Instrument {
    void play(Note n) {
        System.out.println("Piano.play() " + n);
    }
}

class RandomMusicGenerator {
    private Random rand = new Random(47);

    public Instrument next() {
        switch (rand.nextInt(6)) {
            default:
            case 0:
                return new Wind();
            case 1:
                return new Percussion();
            case 2:
                return new Stringed();
            case 3:
                return new Brass();
            case 4:
                return new Woodwind();
            case 5:
                return new Piano();
        }
    }
}

public class _07_03_PolymorphismExample {
    private static RandomMusicGenerator gen =
            new RandomMusicGenerator();
    // Doesn’t care about type, so new types
    // added to the system still work right:
    public static void tune(Instrument i) {
// ...
        i.play(Note.MIDDLE_C);
        System.out.println(i.what());
    }
    public static void tuneAll(Instrument[] e) {
        for(Instrument i : e)
            tune(i); }
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = new Instrument[5];
        for (int i = 0;  i < orchestra.length; i++)
            orchestra[i] = gen.next();

        tuneAll(orchestra);
    }
}

