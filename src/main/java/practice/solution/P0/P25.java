package practice.solution.P0;

import org.springframework.stereotype.Component;
import practice.solution.common.ListNode;

/**
 * @Author WilliamWang
 * @Date 2025/2/26-13:56
 */

@Component
public class P25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode ans = new ListNode();

        ListNode pre = ans;
        ListNode start = head;
        ListNode end = start;
        int cnt = 0;
        boolean needReverse = false;
        while (true) {
            cnt = 0;
            needReverse = false;
            while (end != null) {
                cnt++;
                if (cnt == k) {
                    needReverse = true;
                    break;
                }
                end = end.next;
            }
            if (needReverse) {
                ListNode nextStart = end.next;
                reverse(start, k);
                pre.next = end;
                start.next = nextStart;
                pre = start;
                start = pre.next;
                end = start;
            } else {
                break;
            }
        }
        return ans.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode ans = new ListNode();
        ListNode first = null;

        ListNode cur = head;
        ListNode temp = cur.next;

        while (k > 0) {
            ans.next = cur;
            cur.next = first;
            first = cur;
            k--;
            cur = temp;
            if (cur == null) {
                break;
            }
            temp = temp.next;
        }
        return ans.next;
    }
}
