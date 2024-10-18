package practice.solution;

import java.util.Stack;

/**
 * @Author William Wang
 */
public class P739 {

    /**
     * 用栈存贮当前待解决的日子的index,遍历时遇到大的就依次检查能不能解决
     */
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] distance = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int indexOfDistanceToAdd = stack.pop();
                distance[indexOfDistanceToAdd] = i - indexOfDistanceToAdd;
            }
            stack.add(i);
        }
        return distance;
    }
}
