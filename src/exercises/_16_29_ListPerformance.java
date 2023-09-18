package exercises;

import testPackage.TestParam;
import testPackage.Test;
import testPackage.Tester;
import testPackage.CountingIntegerList;

import java.util.*;

class ListPerformance {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<String>>> tests = new ArrayList<Test<List<String>>>();
    static List<Test<LinkedList<String>>> qTests = new ArrayList<Test<LinkedList<String>>>();
    static List<Test<ContainerArray<String>>> myArray = new ArrayList<Test<ContainerArray<String>>>();
    static List<Test<ContainerArray<Integer>>> myArrayInteger = new ArrayList<Test<ContainerArray<Integer>>>();
    static List<Test<FastTraversalLinkedList<Integer>>> fastListTests = new ArrayList<Test<FastTraversalLinkedList<Integer>>>();

    static {
        tests.add(new Test<List<String>>("add") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++)
                        list.add(String.valueOf(j));
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<String>>("get") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new Test<List<String>>("set") {

            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.set(rand.nextInt(listSize), "1");
                return loops;
            }
        });
        tests.add(new Test<List<String>>("iteradd") {
            public int test(List<String> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<String> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++)
                    it.add("1");
                return LOOPS;
            }
        });
        tests.add(new Test<List<String>>("insert") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++)
                    list.add(5, "1"); // Minimize random-access cost
                return loops;
            }
        });
        tests.add(new Test<List<String>>("remove") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), 10)));
                    while (list.size() > 5)
                        list.remove(5); // Minimize random-access cost
                }
                return loops * size;
            }
        });
        tests.add(new Test<List<String>>("collectionSort") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), 10)));
                    Collections.sort(list);
                }
                return loops;
            }
        });
// Tests for queue behavior:
        qTests.add(new Test<LinkedList<String>>("addFirst") {
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addFirst("1");
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("addLast") {
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addLast("1");
                }
                return loops * size;
            }
        });
        qTests.add(
                new Test<LinkedList<String>>("rmFirst") {
                    public int test(LinkedList<String> list, TestParam tp) {
                        int loops = tp.loops;
                        int size = tp.size;
                        for (int i = 0; i < loops; i++) {
                            list.clear();
                            list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), 10)));
                            while (list.size() > 0)
                                list.removeFirst();
                        }
                        return loops * size;
                    }
                });
        qTests.add(new Test<LinkedList<String>>("rmLast") {
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), 10)));
                    while (list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("collectionSort") {
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), 10)));
                    Collections.sort(list);
                }
                return loops;
            }
        });
        // Test for the resizing list
        myArray.add(new Test<ContainerArray<String>>("add") {
            public int test(ContainerArray<String> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++)
                        list.add(String.valueOf(j));
                }
                return loops * listSize;
            }
        });
        myArray.add(new Test<ContainerArray<String>>("get") {
            public int test(ContainerArray<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });
        myArrayInteger.add(new Test<ContainerArray<Integer>>("add") {
            public int test(ContainerArray<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++)
                        list.add(j);
                }
                return loops * listSize;
            }
        });
        myArrayInteger.add(new Test<ContainerArray<Integer>>("get") {
            public int test(ContainerArray<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });

    }

    static class ListTester extends Tester<List<String>> {
        public ListTester(List<String> container,
                          List<Test<List<String>>> tests) {
            super(container, tests);
        }

        // Fill to the appropriate size before each test:
        @Override
        protected List<String> initialize(int size) {
            container.clear();
            container.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), 10)));
            return container;
        }

        // Convenience method:
        public static void run(List<String> list,
                               List<Test<List<String>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    static class ContainerTesterString extends Tester<ContainerArray<String>> {
        public ContainerTesterString(ContainerArray<String> container,
                          List<Test<ContainerArray<String>>> tests) {
            super(container, tests);
        }

        // Fill to the appropriate size before each test:
        @Override
        protected ContainerArray<String> initialize(int size) {
            container.resizeBackToInitialSize();
            container.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), 10)));
            return container;
        }

        // Convenience method:
        public static void run(ContainerArray<String> list,
                               List<Test<ContainerArray<String>>> tests) {
            new ContainerTesterString(list, tests).timedTest();
        }
    }

    static class ContainerTesterInteger extends Tester<ContainerArray<Integer>> {
        public ContainerTesterInteger(ContainerArray<Integer> container,
                                     List<Test<ContainerArray<Integer>>> tests) {
            super(container, tests);
        }

        // Fill to the appropriate size before each test:
        @Override
        protected ContainerArray<Integer> initialize(int size) {
            container.resizeBackToInitialSize();
            container.addAll(Arrays.asList(Generated.array(Integer.class, new CountingGenerator.Integer(), 10)));
            return container;
        }

        // Convenience method:
        public static void run(ContainerArray<Integer> list,
                               List<Test<ContainerArray<Integer>>> tests) {
            new ContainerTesterInteger(list, tests).timedTest();
        }
    }


    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        // Can only do these two tests on an array:
        Tester<List<String>> arrayTest =
                new Tester<List<String>>(null, tests.subList(1, 3)) {
                    // This will be called before each test. It
                    // produces a non-resizeable array-backed list:
                    @Override
                    protected List<String> initialize(int size) {
                        String[] ia = Generated.array(String.class,
                                new CountingGenerator.String(), size);
                        return Arrays.asList(ia);
                    }
                };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        ListTester.run(new ArrayList<String>(), tests);
        ListTester.run(new LinkedList<String>(), tests);
        ListTester.run(new Vector<String>(), tests);
        Tester.fieldWidth = 12;
        Tester<LinkedList<String>> qTest = new Tester<LinkedList<String>>(new LinkedList<String>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
        ContainerTesterString.run(new ContainerArray<String>(), myArray);
        ContainerTesterInteger.run(new ContainerArray<Integer>(), myArrayInteger);
        ListTester.run(new FastTraversalLinkedList<String>(), tests);
    }
}


public class _16_29_ListPerformance {
    public static void main(String[] args) {
        ListPerformance.main(new String[]{});
    }
}
