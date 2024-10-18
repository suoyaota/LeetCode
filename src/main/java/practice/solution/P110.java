package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2020/7/23
 */

@Component
public class P110 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
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

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        int depth = getDepth(root);
        return result;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ldepth = getDepth(root.left);
        int rdepth = getDepth(root.right);
        if (Math.abs(ldepth - rdepth) > 1) {
            result = false;
        }
        return Math.max(ldepth, rdepth) + 1;
    }
}

