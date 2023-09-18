package exercises;

import testPackage.TextFile;

import java.util.HashMap;
import java.util.Map;

public class _16_17_CountDifferentLettersInFile {
    static String file = "_17_12_WriteToFile.java";
    public static void main(String[] args) {
        Map<Character, Integer> wordCount = new HashMap<>();
        TextFile text = new TextFile("./src/exercises/" + file);
        for (String word : text) {
            for (char ch : word.toCharArray()) {
                Integer freq = wordCount.get(ch);
                wordCount.put(ch, freq == null ? 1 : freq + 1);
            }
        }
        System.out.println(wordCount);
    }
}
