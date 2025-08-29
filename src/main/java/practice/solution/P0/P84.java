package practice.solution.P0;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author WilliamWang
 * @Date 2025/8/29-15:45
 */


public class P84 {
    /**
     * 寻找左右边界，遍历高
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int len = heights.length;
        int[] right = new int[len];
        for (int i = 0; i <= len; i++) {
            int nowH;
            if (i == len) {
                nowH = 0;
            } else {
                nowH = heights[i];
            }
            while (!stack.isEmpty() && nowH < heights[stack.peek()]) {
                int idx = stack.pop();
                right[idx] = i - idx - 1;
            }
            stack.push(i);
        }
        stack.pop();
        int[] left = new int[len];
        int ans = 0;
        for (int i = len - 1; i >= -1; i--) {
            int nowH;
            if (i == -1) {
                nowH = 0;
            } else {
                nowH = heights[i];
            }
            while (!stack.isEmpty() && nowH < heights[stack.peek()]) {
                int idx = stack.pop();
                left[idx] = idx - i - 1;
                int w = right[idx] + left[idx] + 1;
                int h = heights[idx];
                ans = Math.max(w * h, ans);
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 一次找出左右边界
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int len = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] right = new int[len];
        int[] left = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int nowH = heights[i];
            while (!stack.isEmpty() && nowH < heights[stack.peek()]) {
                int idx = stack.pop();
                right[idx] = i - 1;
            }
            // 左侧比i高的，都被i消除了
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            right[idx] = len - 1;
        }
        for (int i = 0; i < len; i++) {
            ans = Math.max((right[i] - left[i] + 1) * heights[i], ans);
        }
        return ans;
    }
}
