package exercises;

import testPackage.Countries;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class _16_03_SetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>(Countries.names(3));
        hashSet.addAll(Countries.names(3));
        hashSet.addAll(Countries.names(3));
        hashSet.addAll(Countries.names(3));
        System.out.println(hashSet);


        Set<String> linkHashSet = new LinkedHashSet<>(Countries.names(3));
        linkHashSet.addAll(Countries.names(3));
        linkHashSet.addAll(Countries.names(3));
        linkHashSet.addAll(Countries.names(3));
        System.out.println(linkHashSet);

        Set<String> treeSet = new TreeSet<>(Countries.names(3));
        treeSet.addAll(Countries.names(3));
        treeSet.addAll(Countries.names(3));
        treeSet.addAll(Countries.names(3));
        System.out.println(treeSet);
    }
}
