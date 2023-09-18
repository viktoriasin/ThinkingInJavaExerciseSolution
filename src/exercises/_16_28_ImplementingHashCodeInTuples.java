package exercises;


import java.util.ArrayList;

class Tuple {
    public static <A  extends Comparable <A>,B   extends Comparable <B>> TwoTuple<A,B> tuple(A a, B b) {
        return new TwoTuple<A,B>(a, b);
    }
    public static <A  extends Comparable <A>,B   extends Comparable <B>,C extends Comparable <C>> ThreeTuple<A,B,C>
    tuple(A a, B b, C c) {
        return new ThreeTuple<A,B,C>(a, b, c);
    }
    public static <A  extends Comparable <A>,B   extends Comparable <B>,C extends Comparable <C>,D extends Comparable <D>> FourTuple<A,B,C,D>
    tuple(A a, B b, C c, D d) {
        return new FourTuple<A,B,C,D>(a, b, c, d);
    }
    public static <A  extends Comparable <A>,B   extends Comparable <B>,C extends Comparable <C>,D  extends Comparable <D>,E  extends Comparable <E>>
    FiveTuple<A,B,C,D,E> tuple(A a, B b, C c, D d, E e) {
        return new FiveTuple<A,B,C,D,E>(a, b, c, d, e);
    }
}

public class _16_28_ImplementingHashCodeInTuples {
    public static void main(String[] args) {
        ThreeTuple<Integer, Integer, Integer> threeT1 = Tuple.tuple(1, 2, 3);
        ThreeTuple<Integer, Integer, Integer> threeT2 = Tuple.tuple(2, 2, 3);
        ThreeTuple<Integer, Integer, Integer> threeT3 = Tuple.tuple(3, 2, 3);
        ThreeTuple<Integer, Integer, Integer> threeT4 = Tuple.tuple(3, 3, 3);
        ArrayList<ThreeTuple<Integer, Integer, Integer>> arrayLst = new ArrayList<>();
        arrayLst.add(threeT1);
        arrayLst.add(threeT2);
        arrayLst.add(threeT3);
        arrayLst.add(threeT4);
        arrayLst.sort(null);
        System.out.println(arrayLst);

        System.out.println(arrayLst.indexOf(threeT2));

    }
}
