package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @author William Wang
 * @date 2020/2/25 9:12
 */
@Component
public class P268 {
    /**
     * @date 2020/2/25 9:12
     * @author William Wang
     * @description 可用位运算  也可用加和来找缺失
     */

    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ i ^ nums[i];
        }
        ans = ans ^ nums.length;
        return ans;
    }
}
