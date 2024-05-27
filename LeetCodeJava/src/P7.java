/**
 * @author William Wang
 * @date 2019/11/18 20:13
 */
public class P7 {
/**
 *@date 2019/11/18 20:13
 *@author William Wang
 *@description
 */
class Solution {
    public int reverse(int x) {
        /**
         *@Date 2019/11/18 20:14
         *@Author William Wang
         *@Desicription Runtime 100.00% Memory Usage 11.66%
         */
        int ans = 0;
        int pop = 0;
        while (x != 0) {
            pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE && pop > 7) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || ans == Integer.MIN_VALUE && pop < -8) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
}
