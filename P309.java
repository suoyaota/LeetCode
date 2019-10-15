/**
 * @author William Wang
 * @date 2019/10/15 23:42
 */
public class P309 {
    class Solution {
        /**
         *@Date 2019/10/15 23:43
         *@Author William Wang
         *@Desicription 状态转移方程
         * buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
         * sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
         * 优化空间，不开数组 b0代表当天，b1前一天，b2两天前。
         */
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length <= 1) {
                return 0;
            }
            int b0 = -prices[0], b1 = b0;
            int s0 = 0, s1 = 0, s2 = 0;

            for(int i = 1; i < prices.length; i++) {
                b0 = Math.max(b1, s2 - prices[i]);
                s0 = Math.max(s1, b1 + prices[i]);
                b1 = b0; s2 = s1; s1 = s0;
            }
            return s0;
        }
    }
}
