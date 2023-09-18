package exercises;

import testPackage.RandomGenerator;

import java.util.*;

class ToCompare implements Comparable<ToCompare> {
    String firstString;
    String secondString;

    ToCompare(String s1, String s2) {
        this.firstString = s1;
        this.secondString = s2;
    }

    public String getFirstString() {
        return firstString;
    }

    public String getSecondString() {
        return secondString;
    }

    @Override
    public int compareTo(ToCompare o) {
        return firstString.compareTo(o.getFirstString());
    }

    @Override
    public String toString() {
        return "{" + firstString + ", " + secondString + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof ToCompare)) {
            return false;
        }

        ToCompare compareObj = (ToCompare) o;

        return firstString.equals(compareObj.getFirstString()) && (secondString.equals(compareObj.getSecondString()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + firstString.hashCode();
        result = 37 * result + secondString.hashCode();
        return result;
    }

    // to alphabetic sort
    public static class compareAlphabetic implements Comparator<ToCompare> {

        @Override
        public int compare(ToCompare o1, ToCompare o2) {
            return o1.getFirstString().toLowerCase().compareTo(o2.getFirstString().toLowerCase());
        }
    }

}

public class _16_40_ComparableObjects {

    public static void main(String[] args) {
        List<ToCompare> dataList = new ArrayList<>();
        dataList.add(new ToCompare(new RandomGenerator.String().next(), new RandomGenerator.String().next()));
        dataList.add(new ToCompare(new RandomGenerator.String().next(), new RandomGenerator.String().next()));
        dataList.add(new ToCompare(new RandomGenerator.String().next(), new RandomGenerator.String().next()));
        dataList.add(new ToCompare(new RandomGenerator.String().next(), new RandomGenerator.String().next()));
        dataList.add(new ToCompare(new RandomGenerator.String().next(), new RandomGenerator.String().next()));
        dataList.add(new ToCompare("ararat", "bcd"));
        dataList.add(new ToCompare("ab", "bcd"));
        dataList.add(new ToCompare("Ab", "bcd"));
        Collections.sort(dataList);
        System.out.println(dataList);
        Comparator<ToCompare> comp = Comparator.comparing(ToCompare::getSecondString);
        Collections.sort(dataList, comp);
        System.out.println(dataList);
        System.out.println(Collections.binarySearch(dataList, new ToCompare("ab", "bcd"), comp));

        HashMap<ToCompare, Integer> mapToCompare = new HashMap<>();
        ToCompare element = new ToCompare(new RandomGenerator.String().next(), new RandomGenerator.String().next());
        mapToCompare.put(element, 1);
        mapToCompare.put(new ToCompare(new RandomGenerator.String().next(), new RandomGenerator.String().next()), 1);
        mapToCompare.put(new ToCompare(new RandomGenerator.String().next(), new RandomGenerator.String().next()), 1);
        System.out.println(mapToCompare);
        System.out.println(mapToCompare.get(element));

        Set<ToCompare> hashSetToCompare = new HashSet<>();
        ToCompare element2 = new ToCompare(new RandomGenerator.String().next(), new RandomGenerator.String().next());
        hashSetToCompare.add(element2);
        hashSetToCompare.add(element2);
        System.out.println(hashSetToCompare);
        System.out.println(hashSetToCompare.contains(element2));

        Collections.sort(dataList, new ToCompare.compareAlphabetic());
        System.out.println(dataList);
    }
}
