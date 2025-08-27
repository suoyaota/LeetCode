package practice.solution.P0;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author WilliamWang
 * @Date 2025/8/8-15:46
 */

@Component
public class P17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> ans = new ArrayList<>();
        StringBuilder tempSb = new StringBuilder();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtracking(0, tempSb, ans, digits, map);
        return ans;
    }

    private void backtracking(int idx, StringBuilder tempSb, List<String> ans, String digits, Map<Character, String> map) {
        if (idx == digits.length()) {
            ans.add(tempSb.toString());
            return;
        }
        String letters = map.get(digits.charAt(idx));
        for(int i = 0; i < letters.length(); i++) {
            tempSb.append(letters.charAt(i));
            backtracking(idx + 1, tempSb, ans, digits, map);
            tempSb.deleteCharAt(idx);
        }
    }
}
