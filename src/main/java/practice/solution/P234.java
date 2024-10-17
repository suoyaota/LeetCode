package practice.solution;

import org.springframework.stereotype.Component;



/**
 * @Date 2019/10/9 18:32
 * @Author William Wang
 */
@Component
public class P234 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    //边走边翻转链表
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode start = head;
        ListNode slowNext = slow.next;
        while (true) {
            start = slow;
            fast = fast.next;
            slow = slowNext;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            slowNext = slow.next;
            slow.next = start;
            if (fast.next == null) {
                slow = slowNext;
                break;
            }
        }
        while (slow != null) {
            if (start.val != slow.val) return false;
            slow = slow.next;
            start = start.next;
        }
        return true;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        ListNode toCmp = reverseList(slow);
        while (toCmp != null) {
            if (head.val != toCmp.val) {
                return false;
            }
            toCmp = toCmp.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
