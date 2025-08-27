package practice.solution.P0;

import org.springframework.stereotype.Component;
import practice.solution.common.ListNode;

/**
 * @Author William Wang
 * @Date 2019/11/11 20:50
 */
@Component
public class P2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * @Date 2019/11/11 20:51
     * @Author William Wang
     * @Desicription Runtime 81.05%  Memory Usage 87.15%
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode now = ans;
        int c = 0;
        while (true) {
            ListNode temp = new ListNode(c);
            if (l1 != null) {
                temp.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp.val += l2.val;
                l2 = l2.next;
            }
            if (temp.val >= 10) {
                temp.val -= 10;
                c = 1;
            } else {
                c = 0;
            }
            now.next = temp;
            now = temp;
            if (l1 == null && l2 == null) {
                break;
            }
        }
        if (c == 1) {
            ListNode lastOne = new ListNode(1);
            now.next = lastOne;
        }
        return ans.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int num1 = list2num(l1);
        int num2 = list2num(l2);
        int num = num1 + num2;
        return num2list(num);
    }

    public int list2num(ListNode l1) {
        if (l1 == null) {
            return 0;
        }
        int pow = 1;
        int num = 0;
        while (l1 != null) {
            num += l1.val * pow;
            pow = pow * 10;
            l1 = l1.next;
        }
        return num;
    }

    public ListNode num2list(int num) {
        if (num <= 9) {
            return new ListNode(num);
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (num != 0) {
            int temp = num - num / 10 * 10;
            cur.next = new ListNode(temp);
            num = num / 10;
            cur = cur.next;
        }
        return head.next;
    }

}
