package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/10/19 10:32
 */
@Component
public class P135 {

    /**
     * @Date 2019/10/19 10:33
     * @Author William Wang
     * @Desicription Runtime & Memory Usage: 100.00%
     */
    public int candy(int[] ratings) {
        int len = ratings.length;
        int ans = 1;
        int pre = 0;
        int[] candyNum = new int[len];
        candyNum[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyNum[i] = candyNum[i - 1] + 1;
            } else {
                candyNum[i] = 1;
            }
            ans += candyNum[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candyNum[i] <= candyNum[i + 1]) {
                ans += candyNum[i + 1] + 1 - candyNum[i];
                candyNum[i] = candyNum[i + 1] + 1;
            }
        }
        return ans;
    }
}

