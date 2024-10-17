package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @author William Wang
 * @date 2019/10/14 16:14
 */
@Component
public class P188 {

    /**
     * @Date 2019/10/14 16:49
     * @Author William Wang
     * @Desicription Runtime:65.15%
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        if (k >= len / 2) {
            //交易次数最大为len/2，超过则相当于不限制交易次数，退化为122题
            return quickSolve(prices);
        }

        int[][] maxMoney = new int[k + 1][len];//记录len天内，k次交易内的最优选择
        for (int i = 1; i <= k; i++) {
            int money = -prices[0];//money表示当前我有的金钱。初始化为：第0天我没有钱并且在第0天买入。
            for (int j = 1; j < len; j++) {
                //dp就像吃后悔药，每当新的一天来临，我可以根据第j天的价格改变以前的选择。
                maxMoney[i][j] = Math.max(money + prices[j], maxMoney[i][j - 1]);//调整最后一次交易的卖出时机：如果第j天卖了钱能变更多就在第j天卖，否则维持原样。
                money = Math.max(maxMoney[i - 1][j - 1] - prices[j], money);//调整最后一次交易的买入时机：如果第j天买入更省钱就在第j天买入，否则维持原样。
            }
        }
        return maxMoney[k][len - 1];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}

