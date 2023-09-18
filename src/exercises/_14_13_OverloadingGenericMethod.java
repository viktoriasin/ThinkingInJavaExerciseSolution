package exercises;

import java.util.*;

class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, GeneratorV2<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static <T> List<T> fill(List<T> coll, GeneratorV2<T> gen, int n) {
        System.out.println("Using List");
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static <T> Queue<T> fill(Queue<T> coll, GeneratorV2<T> gen, int n) {
        System.out.println("Using Queue");
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static <T> Set<T> fill(Set<T> coll, GeneratorV2<T> gen, int n) {
        System.out.println("Using Set");
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }


    public static <T> LinkedList<T> fill(LinkedList<T> coll, GeneratorV2<T> gen, int n) {
        System.out.println("Using LinkedList");
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }


    public static void main(String[] args) {
        List<StoryCharacters> storyCharactersList = fill(new ArrayList<>(), new StoryCharactersGenerator(), 4);

        List<StoryCharacters> storyCharactersLinkedList = fill(new LinkedList<>(), new StoryCharactersGenerator(), 4);
        Set<StoryCharacters> storyCharactersSet = fill(new HashSet<>(), new StoryCharactersGenerator(), 4);
        Queue<StoryCharacters> storyCharactersQueue = fill((Queue<StoryCharacters>) new LinkedList<StoryCharacters>(), new StoryCharactersGenerator(), 4);

        for (StoryCharacters c : storyCharactersList)
            System.out.println(c);
        for (StoryCharacters c : storyCharactersSet)
            System.out.println(c);

    }
}

public class _14_13_OverloadingGenericMethod {
    public static void main(String[] args) {
        Generators.main(null);
    }
}
