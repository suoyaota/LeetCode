package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/9 18:20
 * @Author William Wang
 */
@Component
public class P41 {
    class Solution41 {
        public static int firstMissingPositive(int[] nums) {

            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                    temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }
}
