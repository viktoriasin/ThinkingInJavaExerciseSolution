package exercises;

class TwoTuple<A  extends Comparable <A>, B  extends Comparable <B>>  implements Comparable {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result + first.hashCode();
        result = 37 * result + second.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        return o instanceof TwoTuple
                && first.equals(((TwoTuple)o).first)
                && second == ((TwoTuple)o).second;
    }


    @Override
    public int compareTo(Object arg) {
        int firstCompare = first.compareTo((A) ((TwoTuple) arg).first);
        if (firstCompare != 0) {
            return firstCompare;
        }
        return second.compareTo((B) ((TwoTuple) arg).second);
    }
}

class ThreeTuple<A extends Comparable <A>, B extends Comparable <B>, C extends Comparable <C>> extends TwoTuple<A , B>
        {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + third.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        return o instanceof ThreeTuple
                && first.equals(((ThreeTuple)o).first)
                && second == ((ThreeTuple)o).second
                && third == ((ThreeTuple)o).third;
    }

    public int compareTo(Object arg) {
        // Compare by class name first:
        int result = super.compareTo(arg);
        if (result != 0) {
            return result;
        }
        return third.compareTo((C) ((ThreeTuple) arg).third);
    }

}

class FourTuple<A extends Comparable <A>, B extends Comparable <B>, C extends Comparable <C>, D extends Comparable <D>>
        extends ThreeTuple<A, B, C>
{
    public final D fourth;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " +
                third + ", " + fourth + ")";
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + fourth.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        return super.equals(o)
                && fourth == ((FourTuple)o).fourth;
    }

    public int compareTo(Object arg) {
        // Compare by class name first:
        int result = super.compareTo(arg);
        if (result != 0) {
            return result;
        }
        return fourth.compareTo((D) ((FourTuple) arg).fourth);
    }
}

class FiveTuple<A extends Comparable <A>, B extends Comparable <B>,
        C  extends Comparable <C>, D extends Comparable <D>, E extends Comparable <E>>
        extends FourTuple<A, B, C, D> {
    public final E fifth;

    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fifth = e;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " +
                third + ", " + fourth + ", " + fifth + ")";
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + fifth.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        return super.equals(o)
                && fifth == ((FiveTuple)o).fifth;
    }

    public int compareTo(Object arg) {
        // Compare by class name first:
        int result = super.compareTo(arg);
        if (result != 0) {
            return result;
        }
        return fifth.compareTo((E) ((FiveTuple) arg).fifth);
    }
}

class SixTuple<A  extends Comparable <A>, B  extends Comparable <B>, C  extends Comparable <C>, D  extends Comparable <D>,
        E  extends Comparable <E>, F  extends Comparable <F>> extends FiveTuple<A, B, C, D, E> {
    public final F sixth;

    public SixTuple(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        sixth = f;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " +
                third + ", " + fourth + ", " + fifth + ", " + sixth + ")";
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + sixth.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        return super.equals(o)
                && sixth == ((SixTuple)o).sixth;
    }

    public int compareTo(Object arg) {
        // Compare by class name first:
        int result = super.compareTo(arg);
        if (result != 0) {
            return result;
        }
        return sixth.compareTo((F) ((SixTuple) arg).sixth);
    }

}

public class _14_03_SixTuple {
    public static void main(String[] args) {
        SixTuple<Integer, Double, Character, String, Long, Float> q =
                new SixTuple<Integer, Double, Character, String, Long, Float>(1, 2.3, 'c', "S", 1L, 23.4F);

        TwoTuple<Integer, Integer> twoT = new TwoTuple<>(1, 2);
        TwoTuple<Integer, Integer> twoTV2 = new TwoTuple<>(1, 2);
        System.out.println(twoT.hashCode());
        System.out.println(twoTV2.hashCode());
        System.out.println(twoT.equals(twoTV2));
    }
}
