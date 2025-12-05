package practice.solution.P400;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author WilliamWang
 * @Date 2025/11/19-15:50
 */

@Component
public class P438 {

    /**
     * 定长滑窗
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return ans;
        }
        int[] pUsedChar = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pUsedChar[p.charAt(i) - 'a']++;
        }
        int[] nowUsedChar = new int[26];
        for (int left = 0, right = 0; right < s.length(); right++) {
            nowUsedChar[s.charAt(right) - 'a']++;
            if (right - left == p.length()) {
                nowUsedChar[s.charAt(left) - 'a']--;
                left++;
            }
            if (Arrays.equals(pUsedChar, nowUsedChar)) {
                ans.add(left);
            }
        }
        return ans;
    }

    /**
     * 不定长滑窗
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return ans;
        }
        int[] charCnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            charCnt[p.charAt(i) - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            charCnt[s.charAt(right) - 'a']--;
            while (charCnt[s.charAt(right) - 'a'] < 0) {
                charCnt[s.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == p.length()) {
                ans.add(left);
            }
        }
        return ans;
    }
}
