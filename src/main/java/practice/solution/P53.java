package practice.solution;

import org.springframework.stereotype.Component;


/**
 * @author William Wang
 * @date 2019/10/24 23:03
 */
@Component
public class P53 {

    /**
     * @Date 2019/10/24 23:04
     * @Author William Wang
     * @Desicription Runtime: 86.99%   Memory Usage: 99.53%
     */
    public int maxSubArray(int[] nums) {
        int dropNegtive = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dropNegtive = Math.max(dropNegtive + nums[i], nums[i]);
            ans = Math.max(ans, dropNegtive);
        }
        return ans;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum <= 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}

