/**
 * @author wyb
 */
public class P485 {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int ans = 0;
            int temp = 0;
            for (int num : nums) {
                if (num == 1) {
                    temp++;

                } else {
                    ans = Math.max(ans,temp);
                    temp = 0;
                }
            }
            ans = Math.max(ans,temp);
            return ans;
        }
    }
}
