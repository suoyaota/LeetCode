package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/10/27 23:29
 */
@Component
public class P70 {

    /**
     * @Date 2019/10/27 23:29
     * @Author William Wang
     * @Desicription Runtime: 100.00%  Memory Usage:5.26%
     * Dp 优化了空间没开数组
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre1 = 1;
        int pre2 = 2;
        int ans = 0;
        for (int i = 3; i < n + 1; i++) {
            ans = pre1 + pre2;
            pre1 = pre2;
            pre2 = ans;
        }
        return ans;
    }
}

