package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @author William Wang
 * @date 2019/10/14 11:24
 */
@Component
public class P123 {

    /**
     * @Date 2019/10/14 11:24
     * @Author William Wang
     * @Desicription Runtime:99.77%; Memory Usage:100.00%
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] profit = new int[prices.length];
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < profit.length; i++) {
            //遍历建立一个profit数组，记录在第i天（包括第i天）之前完成一次交易所获得的最大利润
            maxProfit = Math.max(maxProfit, prices[i] - min);//检查第i天卖利润会不会更大
            min = Math.min(min, prices[i]);
            profit[i] = maxProfit;
        }
        int max = prices[prices.length - 1];
        maxProfit = profit[prices.length - 1];//在最后一天及以前完成一次交易可得到的最大利润
        //要再完成一次交易,倒着找即可保证两次交易不冲突
        for (int i = prices.length - 2; i > 0; i--) {
            maxProfit = Math.max(maxProfit, max - prices[i] + profit[i]);//max - prices[i]是第二次交易利润，maxProfit即是两次交易和的最大值。
            max = Math.max(max, prices[i]);
        }
        return maxProfit;
    }
}

