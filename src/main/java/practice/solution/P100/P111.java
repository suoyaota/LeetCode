package practice.solution.P100;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/9 18:21
 * @Author William Wang
 */
@Component
public class P111 {
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l == 0 || r == 0) return l + r + 1;
        return Math.min(l, r) + 1;
    }
}


