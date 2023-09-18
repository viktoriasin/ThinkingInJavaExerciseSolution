//:src/_01_Object.java

import java.util.Date;

import exercises.ATypeName;
import exercises._01_04_DataOnly;
import exercises._01_05_Storage;
import exercises._01_06_StaticField;

/**
 * The first Thinking in Java program.
 * Displays a string and today's date.
 *
 * @author victoria
 * @version 1.0
 */

public class _01_Object {
    /**
     * Entry point to a class of application
     *
     * @param args attay of string of arguments
     * @throws Exception No exception thrown
     */
    public static void main(String[] args) {
        System.out.println("Hello, it's: ");
        System.out.println(new Date());


        ATypeName n = new ATypeName();
        _01_04_DataOnly d = new _01_04_DataOnly();
        int di = d.i;
        double dc = d.d;
        boolean db = d.b;

        _01_05_Storage st = new _01_05_Storage();
        System.out.println("The size of the string 'Hellow, world' is: " + st.storage("Hellow, world!"));

        _01_06_StaticField cow1 = new _01_06_StaticField();
        _01_06_StaticField cow2 = new _01_06_StaticField();

        System.out.println("Initial cow1 count: " + cow1.cow_count);
        System.out.println("Initial cow2 count: " + cow2.cow_count);

        cow1.cow_count = 2;

        System.out.println("Cow1 count after change: " + cow1.cow_count);
        System.out.println("Cow2 count after change: " + cow2.cow_count);

    }
} /* Output: (55% match)
        Hello, it’s:
        Wed Oct 05 14:39:36 MDT 2005
 *///:~


// hover mouse on method or class double click f1 to see full documentation