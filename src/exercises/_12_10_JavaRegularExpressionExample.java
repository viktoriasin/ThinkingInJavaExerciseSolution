package exercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_10_JavaRegularExpressionExample {
    public static void main(String[] args) {
        String s = "Java now has regular expressions";
        Pattern p = Pattern.compile("^Java");
        Pattern p1 = Pattern.compile("\\Breg.*");
        Pattern p2 = Pattern.compile("n.w\\s+h(a|i)s");
        Pattern p3 = Pattern.compile("\\s?");
        Pattern p4 = Pattern.compile("\\s*");
        Pattern p5 = Pattern.compile("\\s+");
        Pattern p6 = Pattern.compile("\\s{4}");
        Pattern p7 = Pattern.compile("\\S{1}.");
        Pattern p8 = Pattern.compile("\\s{0,3}");


        System.out.println(p.matcher(s).find());
        System.out.println(p1.matcher(s).find());
        System.out.println(p2.matcher(s).find());
        System.out.println(p3.matcher(s).find());
        System.out.println(p4.matcher(s).find());
        System.out.println(p5.matcher(s).find());
        System.out.println(p6.matcher(s).find());
        System.out.println(p7.matcher(s).find());
        System.out.println(p8.matcher(s).find());

    }
}
