package practice.solution.P100;

import org.springframework.stereotype.Component;
import practice.solution.common.ListNode;

/**
 * @Author William Wang
 */
@Component
public class P109 {
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
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode midPreNode = getMidPreNode(head);
        ListNode rightHead = midPreNode.next.next;
        TreeNode root = new TreeNode(midPreNode.next.val);
        midPreNode.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightHead);
        return root;
    }

    private ListNode getMidPreNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (true) {
            fast = fast.next;
            if (fast == null) {
                return pre;
            }
            fast = fast.next;
            if (fast == null) {
                return pre;
            }
            pre = slow;
            slow = slow.next;
        }
    }
}

