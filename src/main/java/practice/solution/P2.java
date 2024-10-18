package practice.solution;

import org.springframework.stereotype.Component;

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

}
