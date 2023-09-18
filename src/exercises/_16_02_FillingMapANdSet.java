package exercises;

import testPackage.Countries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _16_02_FillingMapANdSet {
    public static void main(String[] args) {
        Map<String, String> capitals = Countries.capitals();
        Map<String, String> mapData = new HashMap<>();
        Set<String> setData = new HashSet<>();
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            if (entry.getKey().startsWith("A")) {
                mapData.put(entry.getKey(), entry.getValue());
                setData.add(entry.getKey());
            }
        }
        System.out.println(mapData);
        System.out.println(setData);
    }
}
