import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/10/8 17:18
 * @Author William Wang
 */
public class P160 {
/**
 *@Date 2019/10/8 17:18
 *@Author William Wang
 *@Description
 */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    class ListNode {
         int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
        }
    }

    class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode lA = headA;
            ListNode lB = headB;
            while (lA != lB) {
                lA = (lA.next == null) ? headB : lA.next;
                lB = (lB.next == null) ? headA : lB.next;
            }
            return lA;
        }
    }

    class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) {
                return null;
            }
            else{
                Map<ListNode,Integer> map = new HashMap<>();
                ListNode start = headA;
                while(true){
                    map.put(start,start.val);
                    if(start.next == null) {
                        break;
                    }
                    start = start.next;
                }
                start = headB;
                while(true){
                    if(map.containsKey(start)){
                        return start;
                    }

                    if(start.next == null) {
                        break;
                    }
                    start = start.next;
                }
                return null;
            }
        }
    }
}
