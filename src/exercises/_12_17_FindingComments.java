package exercises;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CommentFinder {
    public static void main(String[] args) {
        System.out.println("FINDING COMMENTS ...");
        if (args.length != 1) {
            System.out.println("Give the source string!");
            System.exit(0);
        }
        String s = args[0];

        System.out.println("Single line comments: ");
        Pattern singleComment = Pattern.compile("// .*$", Pattern.MULTILINE);
        Matcher m = singleComment.matcher(s);
        while(m.find())
            System.out.println(m.group() + ": " + m.start());

        System.out.println("Multiline comments: ");
        Pattern multilineComment = Pattern.compile("^/\\* .* \\*/$", Pattern.MULTILINE | Pattern.DOTALL);
        Matcher mMulti = multilineComment.matcher(s);
        while(mMulti.find())
            System.out.println(mMulti.group() + ": " + mMulti.start());

    }
}

class ClassFinder {
    public static void main(String[] args) {
        System.out.println("FINDING CLASSES ...");

        if (args.length != 1) {
            System.out.println("Give the source string!");
            System.exit(0);
        }
        String s = args[0];

        Pattern singleComment = Pattern.compile("class\\s+([A-Z][a-z0-9]*)", Pattern.MULTILINE);
        Matcher m = singleComment.matcher(s);
        while(m.find())
            System.out.println(m.group(1) + ": " + m.start());


    }
}

class LiteralsFinder {
    public static void main(String[] args) {
        System.out.println("FINDING LE ...");

        if (args.length != 1) {
            System.out.println("Give the source string!");
            System.exit(0);
        }
        String s = args[0];

        Pattern singleComment = Pattern.compile("=\\s*\"(.*?)\"");
        Matcher m = singleComment.matcher(s);
        while(m.find())
            System.out.println(m.group(1) + ": " + m.start());


    }
}

public class _12_17_FindingComments {

    static public final String POEM =
            "Twas brillig, and the slithy toves ) this is Comment!!! \n" +
                    "// abd this is comment\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch. // Comment?\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "/* thi is a miltiline\n" +
                    "comment */\n" +
                    "The frumious Bandersnatch.";

    static public final String CLASS =
            "class Jo { \n" +
                    "private int i = 2;\n" +
                    "prvate String j = \"Hello!\";\n" +
                    "public void getSomething() {\n\n" +
                    "return;\n" +
                    "}\n" +
                    "}\n" +
                    "public class Empty \n" +
                    "{}\n" +
                    "public class Ho {}";


    static public final String LITERAL =
            "class Jo { \n" +
                    "private int i = 2;\n" +
                    "prvate String j = \"Hello!\";\n" +
                    "public void getSomething() {\n\n" +
                    "return;\n" +
                    "}\n" +
                    "}\n" +
                    "public class Empty \n" +
                    "{}\n" +
                    "public class Ho {\n" +
            "private String something=\"TYU\"; " +
            "public String findIt =\"adwedwe2323dsfsdf 8778dfsdfjkn\";" +
            "}";

    public static void main(String[] args) throws Exception {
//        CommentFinder.main(new String[] {POEM});
//        ClassFinder.main(new String[] {CLASS});
        LiteralsFinder.main(new String[] {LITERAL});
    }
}
