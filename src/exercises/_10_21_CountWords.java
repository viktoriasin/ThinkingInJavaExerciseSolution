package exercises;

import java.util.*;

public class _10_21_CountWords {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        Collections.addAll(words, "Generic classes and methods have type parameters. Generic methods algorithms have other".split(" "));
        Map<String,Integer> mapWords = new HashMap<>();
        System.out.println(words);

        for (String s : words) {
            Integer freq = mapWords.get(s.toUpperCase());
            mapWords.put(s.toUpperCase(), freq == null ? 1 : freq + 1);
        }
        System.out.println(mapWords);

        List<String> wordsList = new ArrayList<>(mapWords.keySet());
        wordsList.sort(String.CASE_INSENSITIVE_ORDER);

        System.out.println(wordsList);

    }
}
