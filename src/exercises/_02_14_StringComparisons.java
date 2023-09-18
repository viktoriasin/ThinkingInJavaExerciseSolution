package exercises;

public class _02_14_StringComparisons {

    static void CompareString(String s, String m) {
        System.out.println(s == m);
        System.out.println(s != m);
        System.out.println(s.equals(m));
        //! System.out.println(s < m);
        //! System.out.println(s <= m);
        //! System.out.println(s > m);
    }

    public static void main(String[] args) {
        String s = "sd";
        String s2 = "sd";
        String s3 = "sdd";

        CompareString(s, s2);

        CompareString(s, s3);
    }
}
