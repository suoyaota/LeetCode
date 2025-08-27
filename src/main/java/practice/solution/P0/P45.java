package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/10/12 11:25
 */
@Component
public class P45 {
    /**
     * @Date 2019/10/12 11:25
     * @Author William Wang
     * @Desicription 倒着找。 Runtime:23.82% Memory Usage:100.00%
     */
    public int jump(int[] nums) {
        int target = nums.length - 1;
        int pos = nums.length - 2;
        int ans = 0;
        while (target != 0) {
            for (pos = 0; pos <= target - 1; pos++) {
                if (nums[pos] >= target - pos) {
                    target = pos;
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }


    /**
     * @Date 2019/10/12 11:49
     * @Author William Wang
     * @Desicription 维护最小步数组，需再读。 Runtime:99.99%
     */
    public int jump2(int[] nums) {
        int[] minStep = new int[nums.length];
        int lastReached = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = lastReached - i + 1; j <= nums[i] && i + j < nums.length; j++) {
                lastReached = i + j;
                minStep[i + j] = 1 + minStep[i];
            }
        }
        return minStep[minStep.length - 1];
    }
}
