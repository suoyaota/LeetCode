package practice.solution;

/**
 * @author wyb
 */
public class P538 {
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

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        addSum(root);
        return root;
    }

    private void addSum(TreeNode root) {
        if (root == null) {
            return;
        }
        addSum(root.right);
        sum += root.val;
        root.val = sum;
        addSum(root.left);

    }
}
