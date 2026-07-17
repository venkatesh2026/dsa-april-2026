package LinkedList;

import java.util.*;

public class LFUCache {

    private Map<Integer, Integer> keyValueMap;
    private Map<Integer, LinkedHashSet<Integer>> frequencyKeyListMap;
    private Map<Integer, Integer> keyFrequencyMap;
    private int cacheCapacity;
    private int minFrequency;

    public LFUCache(int capacity) {
        this.cacheCapacity = capacity;
        this.keyValueMap = new HashMap<>();
        this.frequencyKeyListMap = new HashMap<>();
        this.keyFrequencyMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyValueMap.containsKey(key)) {
            return -1;
        } else {
            increaseFrequency(key);
            return keyValueMap.get(key);
        }
    }

    public void put(int key, int value) {
        if (cacheCapacity == 0) {
            return;
        }
        if (keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            increaseFrequency(key);
            return;
        } else {
            if (keyValueMap.size() >= cacheCapacity) {
                LinkedHashSet<Integer> keys = frequencyKeyListMap.get(minFrequency);
                Integer removedKey = keys.removeFirst();
                if (keys.isEmpty()) {
                    frequencyKeyListMap.remove(minFrequency);
                }
                keyValueMap.remove(removedKey);
                keyFrequencyMap.remove(removedKey);
            }
            keyValueMap.put(key, value);
            keyFrequencyMap.put(key, 1);
            if (frequencyKeyListMap.containsKey(1)) {
                frequencyKeyListMap.get(1).add(key);
            } else {
                LinkedHashSet<Integer> keys = new LinkedHashSet<>();
                keys.add(key);
                frequencyKeyListMap.put(1, keys);
            }
            minFrequency = 1;
        }

    }

    private void increaseFrequency(int key) {
        Integer currentFrequency = keyFrequencyMap.get(key);
        Integer newFrequency = currentFrequency + 1;
        //update keyFrequencyMap with latest frequency
        keyFrequencyMap.put(key, newFrequency);

        Set<Integer> keysForCurrentFrequency = frequencyKeyListMap.get(currentFrequency);
        keysForCurrentFrequency.remove(key);
        if (keysForCurrentFrequency.isEmpty()) {
            frequencyKeyListMap.remove(currentFrequency);
            if (minFrequency == currentFrequency) {
                minFrequency = newFrequency;
            }
        }
        // update frequencyKeyListMap
        if (frequencyKeyListMap.containsKey(newFrequency)) {
            frequencyKeyListMap.get(newFrequency).add(key);
        } else {
            LinkedHashSet<Integer> keys = new LinkedHashSet<>();
            keys.add(key);
            frequencyKeyListMap.put(newFrequency, keys);
        }
    }
}
