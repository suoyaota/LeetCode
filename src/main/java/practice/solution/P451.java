package practice.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wyb
 */
public class P451 {

    public String frequencySort(String s) {
        int len = s.length();
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[len + 1];
        for (char c : charFrequency.keySet()) {
            int frequency = charFrequency.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<Character>();
            }
            buckets[frequency].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}

