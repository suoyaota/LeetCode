package practice.solution.P300;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/11/20-08:14
 */

@Component
public class P303 {

    class NumArray {

        private long[] sums;

        public NumArray(int[] nums) {
            this.sums = new long[nums.length + 1];
            for (int i = 1; i < this.sums.length; i++) {
                this.sums[i] = this.sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return (int) (this.sums[right + 1] - this.sums[left]);
        }
    }

}
