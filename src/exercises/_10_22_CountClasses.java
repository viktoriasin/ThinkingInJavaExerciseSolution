package exercises;

import java.util.*;

class Word {
    private String word;
    private int counter;

    Word(String word) {
        this.word = word;
        counter++;
    }

    public String getWord() {
        return word;
    }

    public int getCounter() {
        return counter;
    }

    public void increaseCounter() {
        counter++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Word)) {
            return false;
        }

        Word wordToCompare = (Word) obj;

        if (wordToCompare.getWord().equals(word)) {
            wordToCompare.increaseCounter();
            return true;
        }
        return false;
    }

    @Override
    public int hashCode()  {
        return Objects.hashCode(word);
    }
}

public class _10_22_CountClasses {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        Collections.addAll(words, "Generic classes and methods have type parameters. Generic methods algorithms have other".split(" "));
        Set<Word> setWords = new HashSet<>();
        System.out.println(words);

        for (String s : words) {
            Word tmp = new Word(s.toUpperCase());
            if (!(setWords.contains(tmp))) {
                setWords.add(tmp);
            }
        }


        for (Word w : setWords) {
            System.out.println("Word is '" + w.getWord() + "' and this word occurs " + w.getCounter() + " times");
        }

    }
}
