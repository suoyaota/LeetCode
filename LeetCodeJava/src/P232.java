import java.util.Stack;

/**
 * @author wyb
 */
public class P232 {
    class MyQueue {

        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        private void in2out() {
            if (out.isEmpty()) {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            in.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            in2out();
            return out.pop();
        }

        /** Get the front element. */
        public int peek() {
            in2out();
            return out.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
