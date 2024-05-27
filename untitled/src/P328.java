/**
 * @author wyb
 * @date 2020/7/23
 */
public class P328 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode evenHead = head.next;
            ListNode even = head.next;
            ListNode odd = head;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = even.next;
                even.next = odd.next;
                even = odd.next;
            }
            odd.next = evenHead;
            return head;
        }
    }
}
