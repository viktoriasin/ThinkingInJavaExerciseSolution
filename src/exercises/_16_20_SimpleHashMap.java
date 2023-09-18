package exercises;

import testPackage.Countries;

import java.util.*;

class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static int SIZE = 3;
    // You can’t have a physical array of generics,
    // but you can upcast to one:

    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets =
            new LinkedList[SIZE];

    public int size() {
        int size = 0;
        for (LinkedList<MapEntry<K, V>> l : buckets) {
            if (l == null) {
                continue;
            }
            for (MapEntry<K, V> entry : l) {
                size++;
            }
        }
        return size;
    }

    public boolean isEmpty() {
        for (LinkedList<MapEntry<K, V>> l : buckets) {
            if (l != null && !l.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K, V>>();
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
            System.out.println("Collision was found for key: " + pair.getKey()
                    + " and value: " + pair.getValue() + " num of probes is equal to " + numOfProbes);
        }
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            set.addAll(bucket);
        }
        return set;
    }

    public V remove(Object o) {
        V oldValue = null;
        int index = Math.abs(o.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(o)) {
                oldValue = iPair.getValue();
                it.remove();
                break;
            }
        }
        return oldValue;
    }

    public void clear() {
        Arrays.fill(buckets, null);
    }

    public boolean containsKey(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return false;
        for (Map.Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (LinkedList<MapEntry<K, V>> l : buckets) {
            if (l == null) {
                continue;
            }
            for (MapEntry<K, V> entry : l) {
                if (entry.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> entry : bucket) {
                set.add(entry.getKey());
            }
        }
        return set;
    }

    public Collection<V> values() {
        Set<V> set = new HashSet<V>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> entry : bucket) {
                set.add(entry.getValue());
            }
        }
        return set;
    }
}

public class _16_20_SimpleHashMap {
    public static void main(String[] args) {
        SimpleHashMap<String, String> m =
                new SimpleHashMap<String, String>();
        m.put("SomeKey", "SomeValue");
        m.put("SomeKey", "SomeValue");
        System.out.println(m);
        m.put("SomeKey", "SomeOtherValue");
        m.put("SomeKey", "SomeValue");
        m.remove("SomeKey");
        m.put("A", "B");
        m.put("C", "D");
        m.remove("C");
        System.out.println(m);
        m.clear();
        System.out.println(m);
        System.out.println(m.isEmpty());
        m.put("NotNullKey", "NotNullValue");
        System.out.println(m.isEmpty());
        m.put("1", "2");
        m.put("2", "3");
        System.out.println(m.keySet());
        System.out.println(m.values());
        System.out.println(m.isEmpty());
    }
}
