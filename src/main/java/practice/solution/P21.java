package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2020/7/23
 */
@Component
public class P21 {
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

    //递归，写递归函数的时候站在最外层思考问题
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        int nowVal = Integer.MIN_VALUE;
        while (true) {
            if (cur1 == null) {
                tail.next = cur2;
                return head.next;
            }
            if (cur2 == null) {
                tail.next = cur1;
                return head.next;
            }
            if (cur1.val <= cur2.val) {
                tail.next = cur1;
                cur1 = cur1.next;
                tail = tail.next;
            } else {
                tail.next = cur2;
                cur2 = cur2.next;
                tail = tail.next;
            }
        }
    }
}

