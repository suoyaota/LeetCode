package practice.solution.P400;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/4/15-15:07
 */

@Component
public class P416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int tar = sum / 2;
        boolean[][] dp = new boolean[len][tar + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= tar) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < tar + 1; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    boolean include = dp[i - 1][j - nums[i]];
                    boolean notInclude = dp[i - 1][j];
                    dp[i][j] = include || notInclude;
                }
                if (j == tar && dp[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
