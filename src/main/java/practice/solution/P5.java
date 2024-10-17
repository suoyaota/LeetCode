package practice.solution;

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
}

