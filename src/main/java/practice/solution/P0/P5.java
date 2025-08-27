package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/9 18:17
 * @Author William Wang
 */
@Component
public class P5 {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String ans = s.substring(0, 1);
        int maxLength = 1;
        int[][] dp = new int[length][length];
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1] == 1)) {
                    dp[l][r] = 1;
                    if (r - l + 1 > maxLength) {
                        maxLength = r - l + 1;
                        ans = s.substring(l, r + 1);
                    }
                } else dp[r][l] = 0;
            }
        }
        return ans;
    }

    public String longestPalindrome2(String s) {
        if (s.length() == 1) {
            return s;
        }
        int len = s.length();
        // i,j 放下标i到j的子串是不是回文串
        boolean[][] dp = new boolean[len][len];
        int ansLen = 0;
        int ansLeft = 0;
        int ansRight = 0;
        // 枚举子串长度
        for (int i = 1; i <= len; i++) {
            int left = 0;
            int right = 0;
            // 枚举改长度的边界
            for (left = 0; left <= len - i; left ++) {
                right = left + i - 1;
                if (i < 3) {
                    if (s.charAt(left) == s.charAt(right)) {
                        dp[left][right] = true;
                    }
                } else {
                    if (s.charAt(left) == s.charAt(right) && dp[left + 1][right - 1]) {
                        dp[left][right] = true;
                    }
                }
                if (dp[left][right] && i > ansLen) {
                    ansLeft = left;
                    ansRight = right;
                    if (i == len) {
                        return s.substring(ansLeft, ansRight + 1);
                    }
                }
            }
        }
        return s.substring(ansLeft, ansRight + 1);
    }
}

