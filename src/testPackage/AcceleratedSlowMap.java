package testPackage;


import java.util.*;

public class AcceleratedSlowMap<K extends Comparable<? super K>, V> extends AbstractMap<K, V> {
    private List<MapEntry<K, V>> data = new ArrayList<MapEntry<K, V>>();

    private final Comparator<MapEntry<K, V>> comp = new Comparator<MapEntry<K, V>>() {
        @Override
        public int compare(MapEntry<K, V> o1, MapEntry<K, V> o2) {
            return o1.getKey().compareTo(o2.getKey());
        }
    };

    public V put(K key, V value) {
        V oldValue = null; // The old value or null
        for (MapEntry<K, V> entry : data) {
            if (entry.getKey().equals(key)) {
                oldValue = entry.getValue();
                entry.setValue(value);
                break;
            }
        }
        if (oldValue == null) {
            data.add(new MapEntry<>(key, value));
        }
        Collections.sort(data, comp);
        return oldValue;
    }

    public V get(Object key) { // key is type Object, not K
        if (key == null) {
            for (Map.Entry<K, V> entry : data) {
                if (entry.getKey() == null) {
                    return entry.getValue();
                }
            }
        } else {
            @SuppressWarnings("unchecked")
            MapEntry<K, V> mapEntry = new MapEntry<>((K) key, (V) new Object());
            int index = Collections.binarySearch(data, mapEntry, comp);
            if (index >= 0) {
                return data.get(index).getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        for (MapEntry<K, V> entry : data) {
            if (entry.getKey().equals(key))
                return true;
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (MapEntry<K, V> entry : data) {
            if (entry.getValue().equals(value))
                return true;
        }
        return false;
    }

    public V remove(Object key) {
        Iterator<MapEntry<K, V>> it = data.iterator();
        while (it.hasNext()) {
            MapEntry<K, V> entry = it.next();
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                it.remove();
                return oldValue;
            }
        }
        return null;
    }

    public void clear() {
        data.clear();
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entrySet;
        entrySet = new AbstractSet<Map.Entry<K, V>>() {
            public Iterator<Map.Entry<K, V>> iterator() {
                return new Iterator<Map.Entry<K, V>>() {

                    private final Iterator<MapEntry<K, V>> ki = data.iterator();

                    public boolean hasNext() {
                        return ki.hasNext();
                    }

                    public Entry<K, V> next() {
                        return ki.next();
                    }

                    public void remove() {
                        ki.remove();
                    }
                };
            }

            public int size() {
                return data.size();
            }

            public boolean isEmpty() {
                return data.isEmpty();
            }

            public void clear() {
                data.clear();
            }

            public boolean contains(Object k) {
                return data.contains(k);
            }
        };

        return entrySet;
    }

    public static void main(String[] args) {
        AcceleratedSlowMap<Integer, Integer> slowMap = new AcceleratedSlowMap<>();
        slowMap.put(1, 2);
        slowMap.put(3, 4);
        slowMap.put(5, 6);
        slowMap.put(7, 8);
        System.out.println(slowMap);
        slowMap.remove(1);
        System.out.println(slowMap.get(1));
        System.out.println(slowMap.get(3));
        slowMap.clear();
        System.out.println(slowMap);
    }
}

class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
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



