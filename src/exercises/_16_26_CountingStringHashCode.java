package exercises;

import java.util.*;

class CountedString {
    private static List<String> created = new ArrayList<String>();
    private String s;
    private int id = 0;
    private char ch;
    public CountedString(String str, char charArg) {
        s = str;
        ch = charArg;
        created.add(s);
        // id is the total number of instances
        // of this string in use by CountedString:
        for(String s2 : created)
            if(s2.equals(s))
                id++;
    }
    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }
    public int hashCode() {
        // The very simple approach:
        // return s.hashCode() * id;
        // Using Joshua Bloch’s recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        result = 37 * result + (int) ch;
        return result;
    }
    public boolean equals(Object o) {
        return o instanceof CountedString
                && s.equals(((CountedString)o).s)
                && id == ((CountedString)o).id
                && ch == ((CountedString)o).ch;
    }
    public static void main(String[] args) {
        Map<CountedString,Integer> map = new HashMap<CountedString,Integer>();
        CountedString[] cs = new CountedString[5];
        for(int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi", 'o');
            map.put(cs[i], i); // Autobox int -> Integer
        }
        System.out.println(map);
        for(CountedString cstring : cs) {
            System.out.println("Looking up " + cstring);
            System.out.println(map.get(cstring));
        }
    }
}

public class _16_26_CountingStringHashCode {
    public static void main(String[] args) {
        CountedString.main(null);
    }
}
