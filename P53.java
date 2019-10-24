/**
 * @author William Wang
 * @date 2019/10/24 23:03
 */
public class P53 {
    class Solution {
        /**
         *@Date 2019/10/24 23:04
         *@Author William Wang
         *@Desicription Runtime: 86.99%   Memory Usage: 99.53%
         */
        public int maxSubArray(int[] nums) {
            int dropNegtive = nums[0];
            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dropNegtive = Math.max(dropNegtive + nums[i],nums[i]);
                ans = Math.max(ans,dropNegtive);
            }
            return ans;
        }
    }
}
