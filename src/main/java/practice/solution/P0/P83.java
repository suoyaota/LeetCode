package practice.solution.P0;

import org.springframework.stereotype.Component;
import practice.solution.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


/**
 * @Author William Wang
 * @Date 2019/10/26 23:47
 */
@Component
public class P83 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * @Date 2019/10/26 23:47
     * @Author William Wang
     * @Desicription Runtime & Memory Usage: 100.00%
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    //递归 终止条件  返回次层级理想结果  本层级如何连接次层级
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = deleteDuplicates2(head.next);
        if (temp.val == head.val) {
            head.next = temp.next;
        }
        return head;
    }
}

