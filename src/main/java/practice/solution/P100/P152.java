package practice.solution.P100;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/4/11-14:31
 */

@Component
public class P152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        // 第i位保存，以第i位结尾的乘积最小的值
        int[] dpMin = new int[len];
        int[] dpMax = new int[len];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] < 0) {
                dpMin[i] = Math.min(dpMax[i - 1] * nums[i], nums[i]);
                dpMax[i] = Math.max(dpMin[i - 1] * nums[i], nums[i]);
            } else {
                dpMin[i] = Math.min(dpMin[i - 1] * nums[i], nums[i]);
                dpMax[i] = Math.max(dpMax[i - 1] * nums[i], nums[i]);
            }
            ans = Math.max(dpMax[i], ans);
        }
        return ans;
    }
}
