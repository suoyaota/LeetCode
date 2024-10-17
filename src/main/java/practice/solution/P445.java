package practice.solution;

import java.util.Stack;

/**
 * @author wyb
 * @date 2020/7/23
 */
public class P445 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = toStack(l1);
        Stack<Integer> s2 = toStack(l2);
        ListNode newHead = new ListNode(-1);
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();
            int value = x + y + carry;
            carry = value / 10;
            value %= 10;
            ListNode temp = new ListNode(value);
            temp.next = newHead.next;
            newHead.next = temp;
        }
        return newHead.next;
    }

    private Stack<Integer> toStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack;
    }
}

