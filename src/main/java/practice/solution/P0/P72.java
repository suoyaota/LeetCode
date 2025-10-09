package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/9/11-10:54
 */

@Component
public class P72 {
    public int minDistance(String word1, String word2) {
        // dp  horse ros
        int len1 = word1.length();
        int len2 = word2.length();
        int m = len1 + 1;
        int n = len2 + 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            // 从horse 变为空串
            dp[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            // 从空串变为 ros
            dp[0][j] = j;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                int temp1 = dp[i - 1][j] + 1;
                int temp2 = dp[i][j - 1] + 1;
                int temp3 = dp[i - 1][j - 1] + 1;
                if (a == b) {
                    temp3--;
                }
                dp[i][j] = Math.min(Math.min(temp1, temp2), temp3);
            }
        }
        return dp[len1][len2];
    }
}
