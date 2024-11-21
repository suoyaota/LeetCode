package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2020/7/23
 */
@Component
public class P24 {
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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = head.next;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode next = pre.next.next.next;
            ListNode first = pre.next;
            ListNode second = pre.next.next;
            pre.next = second;
            second.next = first;
            first.next = next;
            pre = first;
        }
        return ans;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next.next;
        ListNode ans = head.next;
        head.next.next = head;
        head.next = swapPairs(temp);
        return ans;
    }
}

