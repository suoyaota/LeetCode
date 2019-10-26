/**
 * @author William Wang
 * @date 2019/10/26 23:47
 */
public class P83 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         *@Date 2019/10/26 23:47
         *@Author William Wang
         *@Desicription Runtime & Memory Usage: 100.00%
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
    }
}
