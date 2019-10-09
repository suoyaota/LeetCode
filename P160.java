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
            if(headA == null || headB == null) return null;
            else{
                ListNode startA = headA;
                ListNode startB = headB;
                int end = 0;
                while(end != 2){
                    if(startA == startB) {
                        return startA;
                    }
                    else{
                        if(startA.next == null) {
                            startA = headB;
                            end++;
                        }
                        else {
                            startA = startA.next;
                        }
                        if(startB.next == null) {
                            startB = headA;
                        }
                        else {
                            startB = startB.next;
                        }
                    }
                }
                return null;
            }
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
