/**
 * @author William Wang
 * @date 2020/2/25 9:32
 */
public class P260 {
    /**
     *@date 2020/2/25 9:32
     *@author William Wang
     *@description  有两个唯一的数，全数组异或后，得到两唯一的数异或结果，利用异或结果最后一位
     * 将原数组分为两组，即化简为有唯一的数的题目。
     */
    class Solution {
        public int[] singleNumber(int[] nums) {
            int temp = 0;
            for (int num : nums) {
                temp ^= num;
            }
            int last1 = temp & (-temp);
            int[] ans = new int[2];
            for (int num : nums) {
                if ((num & last1) == 0) {
                    ans[0] ^= num;
                } else {
                    ans[1] ^= num;
                }
            }
            return ans;
        }
    }
}
