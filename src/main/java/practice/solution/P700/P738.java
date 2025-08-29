package practice.solution.P700;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author WilliamWang
 * @Date 2025/8/27-15:18
 */

@Component
public class P738 {

    // 暴力
    public int[] dailyTemperatures1(int[] temperatures) {
        // 存储温度在输入中的下标
        int[] idxOfT = new int[101];
        int len = temperatures.length;
        int[] ans = new int[len];
        Arrays.fill(idxOfT, Integer.MAX_VALUE);
        // 从输入末尾开始遍历寻找答案
        for (int i = len - 1; i >= 0; i--) {
            int t = temperatures[i];
            // 最近更高温度下标
            int minWormerIdx = Integer.MAX_VALUE;
            // 寻找比它高的温度是否已在数组末尾出现
            // 因为温度的范围比输入长度小，因此可以减少时间
            for (int j = t + 1; j < 101; j++) {
                int idx = idxOfT[j];
                if (idx != Integer.MAX_VALUE) {
                    minWormerIdx = Math.min(minWormerIdx, idx);
                }
            }
            if (minWormerIdx != Integer.MAX_VALUE) {
                ans[i] = minWormerIdx - i;
            }
            idxOfT[t] = i;
        }
        return ans;
    }

    // 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int nowT = temperatures[i];
            while (!stack.isEmpty() && nowT > temperatures[stack.peek()]) {
                int topTidx = stack.pop();
                ans[topTidx] = i - topTidx;
            }
            stack.push(i);
        }
        return ans;
    }
}
