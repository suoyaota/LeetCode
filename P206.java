/**
 * @Date 2019/10/9 18:30
 * @Author William Wang
 */
public class P206 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    class Solution1 {
        /**
         *@Date 2019/10/9 18:31
         *@Author William Wang
         *@Desicription Reverse iteratively
         */
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode now = head.next;
            ListNode slow = head;
            ListNode fast;
            slow.next = null;
            while(true){
                if(now.next == null){
                    now.next = slow;
                    return now;
                }
                fast = now.next;
                now.next = slow;
                slow = now;
                now = fast;
            }
        }
    }


    class Solution {
        /**
         *@Date 2019/10/9 18:31
         *@Author William Wang
         *@Desicription Reverse recursively
         */
        ListNode ans;
        public ListNode reverseList(ListNode head) {
            if(head == null) return head;
            reverse(head);
            head.next = null;
            return ans;
        }
        public void reverse(ListNode node){
            if(node.next != null){
                reverse(node.next);
            }
            if(node.next == null){
                ans = node;
                return;
            }
            node.next.next = node;
            return;
        }
    }


}
