package practice.solution.P0;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author WilliamWang
 * @Date 2025/4/16-8:24
 */


public class P32 {
    /**
     * dp
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')'
                    && i - 1 >= 0
                    && i - dp[i - 1] - 1 >= 0
                    && s.charAt(i - dp[i - 1] - 1) == '(') {
                // 中间子串长度加本次匹配
                dp[i] = dp[i - 1] + 2;
                // 加之前子串长度
                if (i - dp[i - 1] - 2 > 0) {
                    dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                }
            } else {
                dp[i] = 0;
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * 栈
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        // 上一个不能匹配的下标
        stack.push(-1);
        stack.push(0);
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')' && stack.peek() >= 0 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                int idx = stack.peek();
                ans = Math.max(ans, i - idx);
            } else {
                stack.push(i);
            }
        }
        return ans;
    }
}
