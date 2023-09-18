package exercises;

import testPackage.TestParam;
import testPackage.Test;
import testPackage.Tester;

import java.util.*;

public class _16_34_SetPerformance {
    static List<Test<Set<String>>> tests =
            new ArrayList<Test<Set<String>>>();
    static List<Test<Set<Integer>>> testsInteger =
            new ArrayList<Test<Set<Integer>>>();
    static {
        tests.add(new Test<Set<String>>("add") {
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    set.clear();
                    for(int j = 0; j < size; j++)
                        set.add(String.valueOf(j));
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for(int i = 0; i < loops; i++)
                    for(int j = 0; j < span; j++)
                        set.contains(String.valueOf(j));
                return loops * span;
            }
        });
        tests.add(new Test<Set<String>>("iterate") {
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while(it.hasNext())
                        it.next(); }
                return loops * set.size();
            }
        });

        testsInteger.add(new Test<Set<Integer>>("add") {
            public int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    set.clear();
                    for(int j = 0; j < size; j++)
                        set.add(j);
                }
                return loops * size;
            }
        });
        testsInteger.add(new Test<Set<Integer>>("contains") {
            public int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for(int i = 0; i < loops; i++)
                    for(int j = 0; j < span; j++)
                        set.contains(j);
                return loops * span;
            }
        });
        testsInteger.add(new Test<Set<Integer>>("iterate") {
            public int test(Set<Integer> set, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; i++) {
                    Iterator<Integer> it = set.iterator();
                    while(it.hasNext())
                        it.next(); }
                return loops * set.size();
            }
        });



    }
    public static void main(String[] args) {
        if(args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<String>(), tests);
        Tester.run(new HashSet<String>(), tests);
        Tester.run(new LinkedHashSet<String>(), tests);

        Tester.run(new TreeSet<Integer>(), testsInteger);
        Tester.run(new HashSet<Integer>(), testsInteger);
        Tester.run(new LinkedHashSet<Integer>(), testsInteger);
    }
}


