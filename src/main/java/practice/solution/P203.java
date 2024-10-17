package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/9 18:30
 * @Author William Wang
 */
@Component
public class P203 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        while (head.val == val) {
            head = head.next;
            if (head == null) return head;
        }
        ListNode now = head;
        ListNode pre = now;
        while (true) {
            now = now.next;
            if (now == null) {
                pre.next = now;
                break;
            } else if (now.val == val) {
                continue;
            } else {
                pre.next = now;
                pre = now;
            }
        }
        return head;
    }
}


