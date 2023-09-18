package exercises;

import java.util.regex.Pattern;

public class _12_07_MatchWholeSentence {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("^[A-Z].*\\.", "Hello, I'm fine."));
        System.out.println(Pattern.matches("^[A-Z].*\\.", "Hello, I'm fine"));
        System.out.println(Pattern.matches("^[A-Z].*\\.", "hello, I'm fine"));
        System.out.println(Pattern.matches("^[A-Z].*\\.", "hello, I'm fine."));
        System.out.println(Pattern.matches("^[A-Z].*\\.", "3123123123210938128937i"));
        System.out.println(Pattern.matches("^[A-Z].*\\.", "Hello, \nI'm fine."));
    }
}
