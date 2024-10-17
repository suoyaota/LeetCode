package practice.solution;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wyb
 */
public class P503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i];
            }
            if (ans[i] == -1) {
                stack.push(i);
            }
        }
        return ans;

    }
}
