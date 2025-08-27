package practice.solution.P500;



/**
 * @Author William Wang
 * @Date 2020/7/26
 */
public class P543 {
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

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int temp = getDepth(root);
        return ans;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ldepth = getDepth(root.left);
        int rdepth = getDepth(root.right);
        int tempans = ldepth + rdepth;
        ans = ans > tempans ? ans : tempans;
        return Math.max(ldepth, rdepth) + 1;
    }
}
