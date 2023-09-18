package exercises;

import java.util.*;

class Generators2 {
    public static <T> Collection<T> fill(Collection<T> coll, GeneratorV2<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<StoryCharacters> coffee = fill(new ArrayList<>(), new StoryCharactersGenerator(), 4);
        for (StoryCharacters c : coffee) {
            System.out.println(c);
        }
    }


    public static <T> Collection<T> test(Collection<T> a, Collection<T> b) {
        if (a.size() > b.size()) {
            return a;
        } else {
            return b;
        }
    }
}

public class _14_13_OverloadingGenericMethod2 {
    public static void main(String[] args) {
        Generators2.main(null);
    }
}
