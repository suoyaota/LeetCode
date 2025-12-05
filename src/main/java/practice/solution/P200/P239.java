package practice.solution.P200;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author WilliamWang
 * @Date 2025/11/20-16:48
 */

@Component
public class P239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                // (a, b) -> {
                //     if (a[0] != b[0]) {
                //         return Integer.compare(b[0], a[0]);
                //     }
                //     return Integer.compare(b[0], a[0]);
                // }
                new Comparator<>() {
                    public int compare(int[] a, int[] b) {
                        if (a[0] != b[0]) {
                            return Integer.compare(b[0], a[0]);
                        }
                        return Integer.compare(b[1], a[1]);
                    }
                }
        );
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = queue.peek()[0];
        for (int right = k; right < nums.length; right++) {
            queue.offer(new int[]{nums[right], right});
            while (queue.peek()[1] <= right - k) {
                queue.poll();
            }
            ans[right - k + 1] = queue.peek()[0];
        }
        return ans;
    }
}
