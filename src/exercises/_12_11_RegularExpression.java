package exercises;

import java.util.regex.Pattern;

public class _12_11_RegularExpression {
    public static void main(String[] args) {
        String s = "Arline ate eight apples and one orange while Anita hadn’t any";
        Pattern p = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
        System.out.println(p.matcher(s).find());
    }
}
