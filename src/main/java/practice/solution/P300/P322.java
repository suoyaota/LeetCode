package practice.solution.P300;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author WilliamWang
 * @Date 2025/4/8-21:23
 */

@Component
public class P322 {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, amount + 1);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int preMin = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    f[i] = Math.min(f[i], f[i - coin] + 1);
                }
            }
        }
        return f[amount] == amount + 1 ? -1 : f[amount];
    }
}
