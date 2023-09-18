package exercises;

import testPackage.Countries;

import java.util.*;

class MapEntryV2<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;
    private MapEntryV2<K, V> next;

    public MapEntryV2<K, V> getNextMapEntry() {
        return next;
    }

    public void changeNext(MapEntryV2<K, V> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public MapEntryV2(K key, V value, MapEntryV2<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public MapEntryV2(K key, V value) {
        this(key, value, null);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^
                (value == null ? 0 : value.hashCode());
    }

    public boolean equals(Object o) {
        if (!(o instanceof MapEntry)) return false;
        MapEntry me = (MapEntry) o;
        return
                (key == null ?
                        me.getKey() == null : key.equals(me.getKey())) &&
                        (value == null ?
                                me.getValue() == null : value.equals(me.getValue()));
    }

    public String toString() {
        return key + "=" + value;
    }
}

class SimpleHashMapV2<K, V> extends AbstractMap<K, V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
    // You can’t have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntryV2<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;

        if (buckets[index] == null)
            buckets[index] = new LinkedList<MapEntryV2<K, V>>();

        LinkedList<MapEntryV2<K, V>> bucket = buckets[index];
        MapEntryV2<K, V> pair = new MapEntryV2<K, V>(key, value);

        boolean found = false;

        if (bucket.isEmpty()) {
            buckets[index].add(pair);
        } else {
            MapEntryV2<K, V> current = bucket.getFirst();
            do {
                if (current.getKey().equals(key)) {
                    oldValue = current.getValue();
                    current.setValue(value); // Replace old with new
                    found = true;
                    break;
                }
                current = current.getNextMapEntry();
            } while (current.hasNext());

            if (!found) {
                buckets[index].add(pair);
                current.changeNext(pair);
            }
        }
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntryV2<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        for (LinkedList<MapEntryV2<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntryV2<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }


}


public class _16_25_SimpleHashMapV2 {
    public static void main(String[] args) {
            SimpleHashMapV2<Integer, Integer> simpleHashMap = new SimpleHashMapV2<>();
        simpleHashMap.put(1, 2);
        simpleHashMap.put(3, 4);
        simpleHashMap.put(5, 6);
        simpleHashMap.put(7, 8);
        System.out.println(simpleHashMap);
    }
}
