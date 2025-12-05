package practice.solution.P0;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author William Wang
 * @Date 2019/11/12 21:53
 */
@Component
public class P3 {

    /**
     * @Date 2019/11/12 21:53
     * @Author William Wang
     * @Desicription
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        int[] lastShow = new int[128];
        for (int i = 0, j = 0; j < len; j++) {
            i = Math.max(i, lastShow[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            lastShow[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int left = 0, right = 0; right < len; right++) {
            char c = chars[right];
            while (set.contains(c)) {
                set.remove(chars[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            set.add(c);
        }
        return ans;
    }
}

