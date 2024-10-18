package practice.solution;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author WilliamWang
 * @Date 2024/10/18-10:24
 */

@Component
public class P49 {
    // o(nklogk)
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> strList = hashmap.getOrDefault(key, new ArrayList<>());
            strList.add(str);
            hashmap.put(key, strList);
        }
        return new ArrayList<>(hashmap.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] charCount = new int[26];
            for(char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i] != 0) {
                    sb.append('a' + i);
                    sb.append(charCount[i]);
                }
            }
            String key = sb.toString();
            List<String> strList = map.getOrDefault(key, new ArrayList<>());
            strList.add(str);
            map.put(key, strList);
        }
        return new ArrayList<>(map.values());
    }
}
