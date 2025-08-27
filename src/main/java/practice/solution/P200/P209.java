package practice.solution.P200;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/3/17-21:25
 */

@Component
public class P209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int ans = len + 1;
        int right = 0;
        int left = 0;
        int sum = 0;
        int subLen = 0;
        while (right < len) {
            sum += nums[right];
            subLen++;
            right++;
            while (sum >= target) {
                ans = Math.min(ans, subLen);
                sum -= nums[left];
                left++;
                subLen--;
            }
        }
        return ans == len + 1 ? 0 : ans;
    }
}
