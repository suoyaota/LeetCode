package practice.solution.P700;

import practice.solution.common.ListNode;

/**
 * @Author William Wang
 * @Date 2020/7/23
 */
public class P725 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = getLength(root);
        //System.out.println(root.val);
        int baseLen = len / k;
        int mod = len % k;
        int[] eachLen = new int[k];
        for (int i = 0; i < k; i++) {
            if (mod > 0) {
                eachLen[i] = baseLen + 1;
                mod--;
            } else {
                eachLen[i] = baseLen;
            }
        }
        ListNode[] ans = new ListNode[k];
        ListNode cur = root;
        label:
        for (int i = 0; i < k; i++) {
            ListNode eachHead = new ListNode();
            ListNode pre = eachHead;
            while (eachLen[i] > 0) {
                if (cur == null) {
                    break label;
                }
                ListNode temp = new ListNode(cur.val);
                pre.next = temp;
                pre = temp;
                cur = cur.next;
                eachLen[i]--;
            }
            ans[i] = eachHead.next;
        }
        return ans;
    }

    private int getLength(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans++;
            head = head.next;
        }
        return ans;
    }
}

