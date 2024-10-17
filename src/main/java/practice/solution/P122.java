package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @author William Wang
 * @date 2019/10/13 23:48
 */
@Component
public class P122 {
    public int maxProfit(int[] prices) {
        /**
         *@Date 2019/10/13 23:48
         *@Author William Wang
         *@Desicription 有利润可图就卖（计入总利润）。 Runtime:94.50% Memory Usage: 100.00%
         */
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
