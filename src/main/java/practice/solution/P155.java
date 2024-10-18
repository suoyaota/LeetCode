package practice.solution;

import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * @Author William Wang
 */
@Component
public class P155 {
    class MinStack {
        private final Stack<Integer> stack;
        private final Stack<Integer> minStack;
        private int min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            stack.push(x);
            min = Math.min(min, x);
            minStack.push(min);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
            if (minStack.isEmpty()) {
                min = Integer.MAX_VALUE;
            } else {
                min = minStack.peek();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
