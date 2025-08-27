package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/10/12 10:57
 */
@Component
public class P55 {

    /**
     * @Date 2019/10/12 10:57
     * @Author William Wang
     * @Desicription Runtime 99.27% Memory Usage 100.00%
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0 && nums.length == 1) {
            return true;
        }
        int pos = nums.length - 2;
        int target = nums.length - 1;
        while (pos != -1) {
            for (pos = target - 1; pos >= 0; pos--) {
                if (nums[pos] >= target - pos) {
                    target = pos;
                    break;
                }
            }
        }
        return target == 0;

    }
}

