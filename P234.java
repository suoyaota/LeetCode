/**
 * @Date 2019/10/9 18:32
 * @Author William Wang
 */
public class P234 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null) return true;
            if(head.next == null) return true;
            ListNode fast = head;
            ListNode slow = head;
            ListNode start = head;
            ListNode slowNext = slow.next;
            while(true){
                start = slow;
                fast = fast.next;
                slow = slowNext;
                if(fast.next == null) {
                    break;
                }
                fast = fast.next;
                slowNext = slow.next;
                slow.next = start;
                if(fast.next == null){
                    slow = slowNext;
                    break;
                }
            }
            while(slow != null){
                if(start.val != slow.val) return false;
                slow = slow.next;
                start = start.next;
            }
            return true;
        }
    }

}
