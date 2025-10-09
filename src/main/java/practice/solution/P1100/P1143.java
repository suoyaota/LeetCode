package practice.solution.P1100;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/9/10-17:01
 */

@Component
public class P1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int m = len1 + 1;
        int n = len2 + 1;
        // i,j text1、text2分别以下标i，j结尾的最长公共子序列值
        // dp[0][j] = 0;
        // dp[i][0] = 0;
        // dp[0][0] = 0;
        // dp[i][j] = dp[i - 1][j - 1] + 1  i,j字母相同
        // dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])  i,j字母不相同
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char a = text1.charAt(i - 1);
                char b = text2.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
