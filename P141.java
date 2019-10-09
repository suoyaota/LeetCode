import java.util.HashMap;

/**
 * @Date 2019/10/9 18:25
 * @Author William Wang
 */
public class P141 {
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


    class Solution1 {
        /**
         *@Date 2019/10/9 18:25
         *@Author William Wang
         *@Desicription 快慢指针法
         */
        public boolean hasCycle(ListNode head) {
            if(head == null) return false;
            ListNode fast = new ListNode(0);
            ListNode slow = new ListNode(0);
            fast = head;
            slow = head;
            while(true){
                fast = fast.next;
                if (fast == null) return false;
                fast = fast.next;
                if(fast == null) return false;
                slow = slow.next;
                if(fast == slow) return true;
            }
        }
    }


    class Solution2 {
        /**
         *@Date 2019/10/9 18:26
         *@Author William Wang
         *@Desicription 哈希表法
         */
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            Map<ListNode,Integer> map = new HashMap<>();
            while(true){
                if(!map.containsKey(head)){
                    map.put(head,0);
                    head = head.next;
                    if(head == null) return false;
                }else return true;
            }
        }
    }


}
