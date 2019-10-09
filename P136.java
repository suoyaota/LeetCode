/**
 * @Date 2019/10/9 18:24
 * @Author William Wang
 */
public class P136 {
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for(int n : nums){
                ans^=n;
            }
            return ans;
        }
    }
}
