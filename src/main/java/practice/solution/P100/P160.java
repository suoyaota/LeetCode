package practice.solution.P100;

import org.springframework.stereotype.Component;
import practice.solution.common.ListNode;


import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/10/8 17:18
 * @Author William Wang
 */
@Component
public class P160 {
    /**
     * @Date 2019/10/8 17:18
     * @Author William Wang
     * @Description
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lA = headA;
        ListNode lB = headB;
        while (lA != lB) {
            lA = (lA.next == null) ? headB : lA.next;
            lB = (lB.next == null) ? headA : lB.next;
        }
        return lA;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        } else {
            Map<ListNode, Integer> map = new HashMap<>();
            ListNode start = headA;
            while (true) {
                map.put(start, start.val);
                if (start.next == null) {
                    break;
                }
                start = start.next;
            }
            start = headB;
            while (true) {
                if (map.containsKey(start)) {
                    return start;
                }

                if (start.next == null) {
                    break;
                }
                start = start.next;
            }
            return null;
        }
    }
}

