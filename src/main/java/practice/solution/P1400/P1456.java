package practice.solution.P1400;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/11/19-15:34
 */

@Component
public class P1456 {

    /**
     * 定长滑动窗口
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int tempAns = 0;
        for (int left = 0, right = 0; right < s.length();right++) {
            if (isAEIOU(s.charAt(right))) {
                tempAns++;
            }
            if (right - left == k) {
                if (isAEIOU(s.charAt(left))) {
                    tempAns--;
                }
                left++;
            }
            ans = Math.max(tempAns, ans);
        }
        return ans;
    }

    private boolean isAEIOU(char c) {
        if (c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u') {
            return true;
        }
        return false;
    }
}
