package exercises;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Random;

enum Letters {
    VOWEL('a', 'e', 'i', 'o', 'u') {
        public String toString() {
            return "Vowel";
        }
    },
    SOMETIMES_A_VOWEL('w', 'y') {
        public String toString() {
            return "Sometimes a vowel";
        }
    },
    CONSONANT('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z') {
        public String toString() {
            return "consonant";
        }
    };
    Character[] letters;

    Letters(Character... letters) {
        this.letters = letters;
    }

    public static Letters typesOfLetters(Character ch) {
        if ((Arrays.asList(VOWEL.letters)).contains(ch)) {
            return VOWEL;
        } else if ((Arrays.asList(SOMETIMES_A_VOWEL.letters)).contains(ch)) {
            return SOMETIMES_A_VOWEL;
        } else {
            return CONSONANT;
        }
    }

}

public class _18_04_VowelsAndConsonants {
    public static void main(String[] args) {
        Random rand = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';

            System.out.println((char) c + ", " + c + ": " + Letters.typesOfLetters((char) c));

        }
    }
}
