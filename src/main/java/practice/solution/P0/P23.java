package practice.solution.P0;

import practice.solution.common.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author WilliamWang
 * @Date 2025/3/5-14:19
 */


public class P23 {
    class Status implements Comparable<Status> {
        int val;
        ListNode node;
        public Status() {}
        public Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }
        public int compareTo(Status status) {
            return this.val - status.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<Status> queue = new PriorityQueue<>();
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode ans = new ListNode();
        ListNode cur = ans;
        while (queue.size() > 1) {
            ListNode node = queue.poll().node;
            cur.next = node;
            if (node.next != null) {
                queue.offer(new Status(node.next.val, node.next));
            }
            cur = cur.next;
        }
        if (queue.size() == 1) {
            cur.next = queue.poll().node;
        }
        return ans.next;
    }
}
