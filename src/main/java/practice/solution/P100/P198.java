package practice.solution.P100;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/4/8-8:58
 */

@Component
public class P198 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 0;
        for (int i = 0; i < nums.length; i++) {
            int max1 = p + nums[i];
            int max2 = q;
            int temp = q;
            q = Math.max(max1, max2);
            p = temp;
        }
        return q;
    }

}
