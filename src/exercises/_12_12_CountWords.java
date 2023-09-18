package exercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_12_CountWords {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\b[a-z]+\\b)");
        Matcher m = p.matcher(POEM);
        int counter = 0;
        m.find();
        System.out.println(m.group());
        while(m.find()) {
            System.out.println(m.group());
            counter++;
        }

        System.out.println(counter);

    }
}
