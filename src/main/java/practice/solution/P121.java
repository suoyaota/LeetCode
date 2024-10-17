package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @author William Wang
 * @date 2019/10/13 23:40
 */
@Component
public class P121 {

    /**
     * @Date 2019/10/13 23:40
     * @Author William Wang
     * @Desicription Runtime: 86.37%  Memory Usage: 100%
     */
    public int maxProfit(int[] prices) {
        //记录下之前最小价格 然后之后每天试图卖出
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                ans = Math.max((prices[i] - min), ans);
            }
        }
        return ans;
    }
}

