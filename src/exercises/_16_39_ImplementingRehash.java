package exercises;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

class SimpleHashMapRehash<K, V> extends SimpleHashMap<K, V> {
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private int nextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private void rehash() {
        int newSize = SIZE * 2;
        SIZE = nextPrime(newSize + 1);
        resize();
    }

    private void resize() {
        LinkedList<MapEntry<K, V>>[] newBuckets = Arrays.copyOf(buckets, SIZE);
    }

    public V put(K key, V value) {
        if ((1.0 * size()) / buckets.length > 0.75) {
            System.out.println("Rehashing!");
            rehash();
        }
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) buckets[index] = new LinkedList<MapEntry<K, V>>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        int numOfProbes = 0;
        while (it.hasNext()) {
            numOfProbes++;
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        } else {
            System.out.println("Collision was found for key: " + pair.getKey() + " and value: " + pair.getValue() + " num of probes is equal to " + numOfProbes);
        }
        return oldValue;
    }
}

public class _16_39_ImplementingRehash {
    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMapRehash<String, String>();
        m.put("SomeKey", "SomeValue");
        m.put("SomeKey", "SomeValue");
        System.out.println(m);
        m.put("1", "SomeValue");
        m.put("2", "SomeValue");
        m.put("3", "SomeValue");
        System.out.println(m);
        System.out.println(m.size());
    }
}
