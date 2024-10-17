package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @author wyb
 * @date 2020/7/30
 */
@Component
public class P337 {
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

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val1 = root.val; //要抢该节点
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        int val2 = 0; //不抢该节点
        val2 += rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }
}

