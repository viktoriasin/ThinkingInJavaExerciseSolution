package exercises;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.regex.*;

class JGrep {
    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            System.exit(0);
        }


        Pattern p = Pattern.compile(args[1]);
        int flags = 0;

        for (int i = 2; i < args.length; i++) {
            Field d = Pattern.class.getField(args[i]);
            flags |= (int) d.get(Pattern.class);
        }

        Pattern src = Pattern.compile(args[1], flags); // как можно сделать так, чтобы не создавать дополнительного объекта?
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = src.matcher("");
        for(String line : args[0].split("\n")) {
            m.reset(line);
            System.out.println(line);
            while(m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        } }
}

public class _12_15_JGreap {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) throws Exception {
        JGrep.main(new String[] {POEM, "[A-Z]\\w", "CASE_INSENSITIVE"});
    }
}
