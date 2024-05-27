/**
 * @author William Wang
 * @date 2019/10/16 19:47
 */
public class P334 {
    class Solution {
        /**
         *@Date 2019/10/16 19:47
         *@Author William Wang
         *@Desicription Runtime:100.00%  Memory Usage:95.35%
         */
        public boolean increasingTriplet(int[] nums) {
            int min = Integer.MAX_VALUE;
            int mid = Integer.MAX_VALUE;
            for (int x : nums) {
                if (x <= min) {
                    min = x;
                } else if (x <= mid) {
                    mid = x;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
