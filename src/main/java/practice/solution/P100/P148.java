package practice.solution.P100;

import org.springframework.stereotype.Component;
import practice.solution.common.ListNode;

/**
 * @Author WilliamWang
 * @Date 2025/3/5-10:31
 */

@Component
public class P148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftTail = findLeftTail(head);
        ListNode right = leftTail.next;
        leftTail.next = null;
        ListNode leftSort = sortList(head);
        ListNode rightSort = sortList(right);
        return merge(leftSort, rightSort);
    }

    private ListNode findLeftTail(ListNode head) {
        ListNode slow = new ListNode();
        slow.next = head;
        ListNode fast = head;

        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        ListNode l = left;
        ListNode r = right;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l == null) {
            cur.next = r;
        } else {
            cur.next = l;
        }
        return ans.next;
    }
}
